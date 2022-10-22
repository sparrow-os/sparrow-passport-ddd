package com.sparrow.passport.domain.service;

import com.sparrow.constant.Config;
import com.sparrow.constant.ConfigKeyLanguage;
import com.sparrow.constant.SparrowError;
import com.sparrow.exception.Asserts;
import com.sparrow.passport.domain.DomainRegistry;
import com.sparrow.passport.domain.entity.RegisteringUserEntity;
import com.sparrow.passport.domain.object.value.EmailActivateToken;
import com.sparrow.passport.repository.RegisteringUserRepository;
import com.sparrow.passport.support.suffix.UserFieldSuffix;
import com.sparrow.protocol.BusinessException;
import com.sparrow.protocol.ClientInformation;
import com.sparrow.protocol.LoginToken;
import com.sparrow.protocol.constant.magic.Symbol;
import com.sparrow.utility.ConfigUtility;
import com.sparrow.utility.DateTimeUtility;
import javax.inject.Named;

@Named
public class RegisteringUserService {
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

    public LoginToken registerByEmail(RegisteringUserEntity registeringUserEntity,
        ClientInformation client, DomainRegistry domainRegistry) throws BusinessException {
        domainRegistry.getUserLimitService().canRegister(client.getIp());
        RegisteringUserRepository registeringUserRepository = domainRegistry.getRegisteringUserRepository();
        RegisteringUserEntity oldUser = registeringUserRepository.findByEmail(registeringUserEntity.getEmail());
        Asserts.isTrue(oldUser != null,
            SparrowError.USER_EMAIL_EXIST,
            UserFieldSuffix.REGISTER_USER_EMAIL);
        registeringUserEntity.setCent(100L);
        //registeringUserEntity.setCent(domainRegistry.getCodeService().getLongValueByCode(ConfigKeyDB.USER_CENT_REGISTER));
        registeringUserEntity.register(domainRegistry);

        registeringUserRepository.saveRegisteringUser(registeringUserEntity, client);
        this.success(registeringUserEntity.getUserId(), client, domainRegistry);
        return LoginToken.create(
            registeringUserEntity.getUserId(),
            registeringUserEntity.getUserName(),
            Symbol.EMPTY,
            Symbol.EMPTY,
            registeringUserEntity.getCent(),
            client.getDeviceId(),
            false,
            1);
    }

    public void sendActivateEmail(RegisteringUserEntity registeringUserEntity,
        DomainRegistry domainRegistry) throws BusinessException {
        String currentDate = DateTimeUtility.getFormatCurrentTime();
        EmailActivateToken emailActivateToken = EmailActivateToken
            .createToken(registeringUserEntity.getUserId(),
                registeringUserEntity.getUserName(),
                registeringUserEntity.getEmail(),
                registeringUserEntity.getPassword(),
                currentDate,
                domainRegistry);
        String content = emailActivateToken.generateContent();

        String language = ConfigUtility.getValue(Config.LANGUAGE);
        String activateEmailSubject = ConfigUtility
            .getLanguageValue(ConfigKeyLanguage.EMAIL_ACTIVATE_SUBJECT,
                language);

        domainRegistry.getEmailService().send(registeringUserEntity.getEmail(),
            activateEmailSubject,
            content,
            language);
    }

    public void activeByEmail(RegisteringUserEntity registeringUserEntity,
        DomainRegistry domainRegistry) {

    }
}
