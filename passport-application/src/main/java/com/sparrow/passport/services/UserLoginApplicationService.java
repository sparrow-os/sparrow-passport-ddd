package com.sparrow.passport.services;

import com.sparrow.constant.ConfigKeyLanguage;
import com.sparrow.container.ConfigReader;
import com.sparrow.core.spi.ApplicationContext;
import com.sparrow.passport.api.UserLoginService;
import com.sparrow.passport.domain.DomainRegistry;
import com.sparrow.passport.domain.entity.SecurityPrincipalEntity;
import com.sparrow.passport.domain.object.value.Login;
import com.sparrow.passport.domain.service.SecurityPrincipalService;
import com.sparrow.passport.protocol.dto.LoginDTO;
import com.sparrow.passport.protocol.query.login.LoginQuery;
import com.sparrow.protocol.BusinessException;
import com.sparrow.protocol.ClientInformation;
import com.sparrow.protocol.LoginUser;
import com.sparrow.support.Authenticator;
import com.sparrow.support.web.WebConfigReader;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class UserLoginApplicationService implements UserLoginService {

    @Inject
    private DomainRegistry domainRegistry;

    @Inject
    private Authenticator authenticator;

    @Override
    public LoginDTO login(LoginQuery login, ClientInformation client) throws BusinessException {
        SecurityPrincipalService securityPrincipalService = this.domainRegistry.getSecurityPrincipalService();
        SecurityPrincipalEntity securityPrincipal = securityPrincipalService.findByLoginName(login.getUserName(), domainRegistry);
        String encryptLoginPassword = this.domainRegistry.getEncryptionService().encryptPassword(login.getPassword());
        Integer rememberDays = 15; //domainRegistry.getCodeService().getIntegerValueByCode(ConfigKeyDB.USER_LOGIN_REMEMBER_DAYS);
        securityPrincipal.setLoginParam(new Login(login.getPassword(), encryptLoginPassword, login.getRemember(), rememberDays));
        return securityPrincipalService.login(securityPrincipal, client, this.domainRegistry);
    }

    public LoginDTO getVisitor(String deviceId) {
        Long visitorId = this.domainRegistry.getVisitorRepository().getVisitorId();
        WebConfigReader webConfigReader = ApplicationContext.getContainer().getBean(WebConfigReader.class);
        ConfigReader configReader = ApplicationContext.getContainer().getBean(ConfigReader.class);
        String visitorName = configReader.getI18nValue(ConfigKeyLanguage.USER_VISITOR_NAME, "","Visitor") + ":" + visitorId;
        String avatar = webConfigReader.getDefaultAvatar();
        LoginUser loginUser=LoginUser.create(visitorId, LoginUser.CATEGORY_VISITOR, visitorName, visitorName, avatar, deviceId, 1);
        String permission = this.authenticator.sign(loginUser, null);
        return new LoginDTO(loginUser, permission);
    }
}
