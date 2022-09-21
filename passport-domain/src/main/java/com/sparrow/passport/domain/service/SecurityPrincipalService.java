package com.sparrow.passport.domain.service;

import com.sparrow.constant.ConfigKeyDB;
import com.sparrow.constant.SparrowError;
import com.sparrow.enums.UserType;
import com.sparrow.exception.Asserts;
import com.sparrow.protocol.BusinessException;
import com.sparrow.protocol.ClientInformation;
import com.sparrow.protocol.LoginToken;
import com.sparrow.protocol.constant.magic.Symbol;
import com.sparrow.protocol.enums.StatusRecord;
import com.sparrow.support.mobile.ShortMessageService;
import com.sparrow.passport.domain.DomainRegistry;
import com.sparrow.passport.domain.entity.SecurityPrincipal;
import com.sparrow.passport.domain.object.value.EmailFindPasswordToken;
import com.sparrow.passport.domain.object.value.EmailTokenPair;
import com.sparrow.passport.domain.object.value.Password;
import com.sparrow.passport.repository.SecurityPrincipalRepository;
import com.sparrow.passport.support.suffix.UserFieldSuffix;
import com.sparrow.utility.DateTimeUtility;
import javax.inject.Named;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Named
public class SecurityPrincipalService {
    private static Logger logger = LoggerFactory.getLogger(SecurityPrincipalService.class);

    public SecurityPrincipal findByLoginName(String loginName,
        DomainRegistry domainRegistry) throws BusinessException {
        SecurityPrincipalRepository securityPrincipalRepository = domainRegistry.getSecurityPrincipalRepository();
        ShortMessageService shortMessageService = domainRegistry.getShortMessageService();
        SecurityPrincipal securityPrincipal;

        if (loginName.contains(Symbol.AT)) {
            securityPrincipal = securityPrincipalRepository.findByEmail(loginName);
        } else {
            securityPrincipal = securityPrincipalRepository.findByName(loginName);
//            if (securityPrincipal == null) {
//                Pair<String, String> mobilePair = shortMessageService.secretMobile(loginName);
//                securityPrincipal = securityPrincipalRepository.findByMobile(mobilePair.getFirst(), mobilePair.getSecond());
//            }
        }
        Asserts.isTrue(securityPrincipal == null, SparrowError.USER_NAME_NOT_EXIST, UserFieldSuffix.LOGIN_USER_NAME);
        Asserts.isTrue(StatusRecord.DISABLE.ordinal() == securityPrincipal.getStatus(),
            SparrowError.USER_DISABLED,
            UserFieldSuffix.LOGIN);

        Boolean isActiveLogin = false;
        if (isActiveLogin == null) {
            isActiveLogin = true;
        }

        if (isActiveLogin && !securityPrincipal.getActivate()) {
            throw new BusinessException(SparrowError.USER_NOT_ACTIVATE, UserFieldSuffix.LOGIN);
        }
        return securityPrincipal;
    }

    private void addLoginEvent(Long userId, ClientInformation client,
        DomainRegistry domainRegistry) throws BusinessException {
//        try {
//            EventService eventService = domainRegistry.getEventService();
//            OperationQueryDTO operationQuery = new OperationQueryDTO();
//            operationQuery.setUserType(UserType.Common.REGISTER.name());
//            operationQuery.setUserId(userId);
//            operationQuery.setContent(Symbol.EMPTY);
//            operationQuery.setEvent(EVENT.LOGIN);
//            operationQuery.setClient(client);
//            eventService.successfulOperation(
//                operationQuery);
//        } catch (Exception ex) {
//            logger.error("login event", ex);
//            throw new BusinessException(SparrowError.SYSTEM_SERVER_ERROR, UserFieldSuffix.LOGIN);
//        }
    }

    public LoginToken login(SecurityPrincipal securityPrincipal, ClientInformation client,
        DomainRegistry domainRegistry) throws BusinessException {
        domainRegistry.getUserLimitService().canLogin(securityPrincipal.getUserId());
        securityPrincipal.login();
        domainRegistry.getSecurityPrincipalRepository().saveSecurity(securityPrincipal);
        this.addLoginEvent(securityPrincipal.getUserId(), client, domainRegistry);
        Integer tokenExpireDays = securityPrincipal.getLoginInfo().getTokenExpireDays();
        return LoginToken.create(securityPrincipal.getUserId(),
            securityPrincipal.getUserName(),
            "",
            "",
            securityPrincipal.getCent(),
            client.getDeviceId(),
            securityPrincipal.getActivate(),
            tokenExpireDays
        );
    }

    public EmailFindPasswordToken getFindPasswordEmailToken(String email,
        DomainRegistry domainRegistry) {
        SecurityPrincipal securityPrincipal = domainRegistry.getSecurityPrincipalRepository().findByEmail(email);
        String currentDate = DateTimeUtility.getFormatCurrentTime();
        return EmailFindPasswordToken.createToken(
            securityPrincipal.getUserId(),
            securityPrincipal.getUserName(),
            securityPrincipal.getEmail(),
            securityPrincipal.getPassword(),
            currentDate, domainRegistry);
    }

    public void resetPasswordByEmailToken(String token, String newPassword, DomainRegistry domainRegistry)
        throws BusinessException {
        Asserts.isTrue(token == null, SparrowError.USER_PASSWORD_VALIDATE_TOKEN_ERROR);
        EncryptionService encryptionService = domainRegistry.getEncryptionService();
        EmailTokenPair emailTokenPair = EmailTokenPair.parse(encryptionService.base64Decode(token));
        SecurityPrincipal securityPrincipal = domainRegistry.getSecurityPrincipalRepository().findByEmail(emailTokenPair.getEmail());
        EmailFindPasswordToken emailFindPasswordToken = EmailFindPasswordToken.parse(emailTokenPair, securityPrincipal.getPassword(), domainRegistry);
        emailFindPasswordToken.isValid(securityPrincipal.getUserName());
        Password password = new Password(newPassword);
        password.isValid();
        securityPrincipal.resetPassword(encryptionService.encryptPassword(newPassword));
        domainRegistry.getSecurityPrincipalRepository().saveSecurity(securityPrincipal);
    }

    public void modifyPassword(SecurityPrincipal securityPrincipal,
        ClientInformation client,
        DomainRegistry domainRegistry) throws BusinessException {
        securityPrincipal.modifyPassword();
        domainRegistry.getSecurityPrincipalRepository().saveSecurity(securityPrincipal);
        this.addPasswordModifiedEvent(securityPrincipal, client, domainRegistry);
    }

    private void addPasswordModifiedEvent(SecurityPrincipal securityPrincipal, ClientInformation client,
        DomainRegistry domainRegistry) {
//        try {
//            OperationQueryDTO operationQuery = new OperationQueryDTO();
//            operationQuery.setUserId(securityPrincipal.getUserId());
//            operationQuery.setUserType(UserType.Common.REGISTER.name());
//            operationQuery.setEvent(EVENT.MODIFY_PASSWORD);
//            operationQuery.setClient(client);
//            domainRegistry.getEventService().successfulOperation(operationQuery);
//        } catch (Exception e) {
//            logger.error("modify password event error", e);
//        }
    }
}
