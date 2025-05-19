package com.sparrow.passport.domain.service;

import com.sparrow.concurrent.SparrowThreadFactory;
import com.sparrow.constant.ConfigKeyLanguage;
import com.sparrow.container.ConfigReader;
import com.sparrow.core.spi.ApplicationContext;
import com.sparrow.email.EmailSender;
import com.sparrow.exception.Asserts;
import com.sparrow.passport.domain.DomainRegistry;
import com.sparrow.passport.domain.entity.RegisteringUserEntity;
import com.sparrow.passport.domain.object.value.EmailActivateToken;
import com.sparrow.passport.domain.object.value.EmailTokenPair;
import com.sparrow.passport.protocol.dto.LoginDTO;
import com.sparrow.passport.protocol.enums.PassportError;
import com.sparrow.passport.repository.RegisteringUserRepository;
import com.sparrow.protocol.BusinessException;
import com.sparrow.protocol.ClientInformation;
import com.sparrow.protocol.LoginUser;
import com.sparrow.protocol.LoginUserStatus;
import com.sparrow.protocol.constant.magic.Symbol;
import com.sparrow.support.Authenticator;
import com.sparrow.utility.DateTimeUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Named
public class RegisteringUserService {
    @Inject
    private Authenticator authenticatorService;

    @Inject
    private EmailSender emailSender;

    private static final ExecutorService ACTIVATE_EMAIL_THREAD_POOL = new ThreadPoolExecutor(2, 4, 1, TimeUnit.MINUTES, new ArrayBlockingQueue<>(128)
            , new SparrowThreadFactory.Builder().daemon(true).namingPattern("activate-email-%d").build(), new ThreadPoolExecutor.CallerRunsPolicy());

    private static Logger logger = LoggerFactory.getLogger(RegisteringUserService.class);

    private void success(Long userId, ClientInformation client,
                         DomainRegistry domainRegistry) throws BusinessException {
//        EventService eventService = domainRegistry.getEventService();
//        try {
//            OperationQueryDTO operationQuery = new OperationQueryDTO();
//            operationQuery.setUserType(UserType.Common.REGISTER.name());
//            operationQuery.setUserId(userId);
//            operationQuery.setEvent(EVENT.REGISTER);
//            operationQuery.setContent(Symbol.EMPTY);
//            operationQuery.setClient(client);
//            eventService.successfulOperation(
//                operationQuery);
//        } catch (Exception ex) {
//            throw new BusinessException(SparrowError.SYSTEM_SERVER_ERROR);
//        }
    }

    public LoginDTO registerByEmail(RegisteringUserEntity registeringUserEntity,
                                    ClientInformation client, DomainRegistry domainRegistry) throws BusinessException {
        domainRegistry.getUserLimitService().canRegister(client.getIp());
        RegisteringUserRepository registeringUserRepository = domainRegistry.getRegisteringUserRepository();

        RegisteringUserEntity oldUser = registeringUserRepository.findByEmail(registeringUserEntity.getEmail());
        Asserts.isTrue(oldUser != null,
                PassportError.USER_EMAIL_EXIST);

        oldUser = registeringUserRepository.findByUserName(registeringUserEntity.getUserName());
        Asserts.isTrue(oldUser != null,
                PassportError.USER_NAME_EXIST);


        registeringUserEntity.register(domainRegistry);

        registeringUserRepository.saveRegisteringUser(registeringUserEntity, client);
        this.success(registeringUserEntity.getUserId(), client, domainRegistry);
        //异步发消息
        this.sendActivateEmail(registeringUserEntity, domainRegistry);

        String defaultAvatar = domainRegistry.getWebConfigReader().getDefaultAvatar();
        LoginUser loginUser = LoginUser.create(
                registeringUserEntity.getUserId(),
                "",
                LoginUser.CATEGORY_REGISTER,
                registeringUserEntity.getUserName(),
                Symbol.EMPTY,
                defaultAvatar,
                client.getDeviceId(),
                1);
        LoginUserStatus loginUserStatus = new LoginUserStatus(LoginUserStatus.STATUS_NORMAL, loginUser.getExpireAt());
        String permission = this.authenticatorService.sign(loginUser, loginUserStatus);
        return new LoginDTO(loginUser, permission);
    }

    private void asyncSendActivateEmail(RegisteringUserEntity registeringUserEntity, DomainRegistry domainRegistry) throws BusinessException {
        String currentDate = DateTimeUtility.getFormatCurrentTime();
        EmailActivateToken emailActivateToken = EmailActivateToken
                .createToken(registeringUserEntity.getUserId(),
                        registeringUserEntity.getUserName(),
                        registeringUserEntity.getEmail(),
                        registeringUserEntity.getPassword(),
                        currentDate,
                        domainRegistry);
        String content = emailActivateToken.generateContent();

        ConfigReader configReader = ApplicationContext.getContainer().getBean(ConfigReader.class);
        String activateEmailSubject = configReader
                .getI18nValue(ConfigKeyLanguage.EMAIL_ACTIVATE_SUBJECT);
        String websiteName = configReader.getI18nValue(ConfigKeyLanguage.WEBSITE_NAME);
        emailSender.send(websiteName,registeringUserEntity.getEmail(),
                activateEmailSubject,
                content);
    }

    public void sendActivateEmail(RegisteringUserEntity registeringUserEntity,
                                  DomainRegistry domainRegistry) throws BusinessException {
        ACTIVATE_EMAIL_THREAD_POOL.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    asyncSendActivateEmail(registeringUserEntity, domainRegistry);
                } catch (BusinessException e) {
                    logger.error("send activate email error", e);
                }
            }
        });
    }

    public void activeEmail(String token, ClientInformation client,
                            DomainRegistry domainRegistry) throws BusinessException {

        String originToken = domainRegistry.getEncryptionService().base64Decode(token);
        EmailTokenPair emailTokenPair = EmailTokenPair.parse(originToken);
        RegisteringUserEntity registeringUserEntity = domainRegistry.getRegisteringUserRepository().findByEmail(emailTokenPair.getEmail());
        EmailActivateToken emailActivateToken = EmailActivateToken.parse(emailTokenPair, registeringUserEntity.getPassword(), domainRegistry);
        emailActivateToken.isValid(registeringUserEntity.getUserName());
        registeringUserEntity.active();
        domainRegistry.getRegisteringUserRepository().saveRegisteringUser(registeringUserEntity, client);
    }
}
