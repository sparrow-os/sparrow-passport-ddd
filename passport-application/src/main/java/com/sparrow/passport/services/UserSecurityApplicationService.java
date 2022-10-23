package com.sparrow.passport.services;

import com.sparrow.passport.api.UserSecurityService;
import com.sparrow.passport.domain.DomainRegistry;
import com.sparrow.passport.domain.entity.SecurityPrincipal;
import com.sparrow.passport.domain.object.value.EmailFindPasswordToken;
import com.sparrow.passport.protocol.param.password.PasswordModifyParam;
import com.sparrow.passport.protocol.param.password.PasswordResetParam;
import com.sparrow.passport.protocol.param.password.ResetPasswordByMobileParam;
import com.sparrow.protocol.BusinessException;
import com.sparrow.protocol.MobileShortMessaging;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class UserSecurityApplicationService implements UserSecurityService {

    @Inject
    private DomainRegistry domainRegistry;

    @Override public void sendFindPasswordToken(String email) throws BusinessException {
        this.domainRegistry.getSecurityPrincipalService().sendFindPasswordToken(email, domainRegistry);
    }

    @Override public MobileShortMessaging findPasswordByMobile(String mobile) throws BusinessException {
        return null;
    }

    @Override public Boolean resetPasswordByMobile(ResetPasswordByMobileParam password) throws BusinessException {
        return null;
    }

    @Override public void resetPasswordByEmailToken(PasswordResetParam param) throws BusinessException {
        this.domainRegistry.getSecurityPrincipalService().resetPasswordByEmailToken(param.getToken(), param.getPassword(), domainRegistry);
    }

    @Override public Boolean modifyPassword(PasswordModifyParam password) {
        return null;
    }
}
