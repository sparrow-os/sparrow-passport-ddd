package com.sparrow.passport.services;

import com.sparrow.constant.ConfigKeyDB;
import com.sparrow.protocol.Authenticator;
import com.sparrow.protocol.BusinessException;
import com.sparrow.protocol.LoginToken;
import com.sparrow.passport.api.UserLoginService;
import com.sparrow.passport.domain.entity.SecurityPrincipal;
import com.sparrow.passport.domain.object.value.Login;
import com.sparrow.passport.domain.service.SecurityPrincipalService;
import com.sparrow.passport.protocol.query.login.LoginQueryDTO;
import com.sparrow.passport.domain.DomainRegistry;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class UserLoginApplicationService implements UserLoginService {

    @Inject
    private DomainRegistry domainRegistry;

    @Inject
    private Authenticator authenticatorService;

    @Override
    public LoginToken login(LoginQueryDTO login) throws BusinessException {
        SecurityPrincipalService securityPrincipalService = this.domainRegistry.getSecurityPrincipalService();
        SecurityPrincipal securityPrincipal = securityPrincipalService.findByLoginName(login.getUserName(), domainRegistry);
        String encryptLoginPassword = this.domainRegistry.getEncryptionService().encryptPassword(login.getPassword());
        Integer rememberDays =15; //domainRegistry.getCodeService().getIntegerValueByCode(ConfigKeyDB.USER_LOGIN_REMEMBER_DAYS);
        Long loginCent = 10L;//domainRegistry.getCodeService().getLongValueByCode(ConfigKeyDB.USER_CENT_LOGIN);
        securityPrincipal.setLoginInfo(new Login(login.getPassword(), encryptLoginPassword, login.getRemember(), loginCent.intValue(), rememberDays));
        LoginToken loginToken = securityPrincipalService.login(securityPrincipal, login.getClient(), this.domainRegistry);
        loginToken.setPermission(this.authenticatorService.sign(loginToken, encryptLoginPassword));
        return loginToken;
    }
}
