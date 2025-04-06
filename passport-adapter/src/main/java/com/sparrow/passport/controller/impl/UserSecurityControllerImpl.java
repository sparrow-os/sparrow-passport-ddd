package com.sparrow.passport.controller.impl;

import com.sparrow.constant.ConfigKeyLanguage;
import com.sparrow.container.ConfigReader;
import com.sparrow.core.spi.ApplicationContext;
import com.sparrow.passport.api.UserSecurityService;
import com.sparrow.passport.controller.UserSecurityController;
import com.sparrow.passport.domain.DomainRegistry;
import com.sparrow.passport.protocol.param.password.PasswordModifyParam;
import com.sparrow.passport.protocol.param.password.PasswordResetParam;
import com.sparrow.protocol.BusinessException;
import com.sparrow.protocol.Result;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class UserSecurityControllerImpl implements UserSecurityController {
    @Inject
    private UserSecurityService userSecurityService;

    @Inject
    private DomainRegistry domainRegistry;

    @Override
    public Boolean modifyPassword(String newPassword, String oldPassword) throws BusinessException {
        PasswordModifyParam passwordModifyDTO = null;
        return this.userSecurityService.modifyPassword(passwordModifyDTO);
    }

    @Override
    public Result<Boolean> sendEmailTokenForFindPassword(String email) throws BusinessException {
        this.userSecurityService.sendFindPasswordToken(email);

        ConfigReader configReader = ApplicationContext.getContainer().getBean(ConfigReader.class);

        String message = configReader.getI18nValue(ConfigKeyLanguage.PASSWORD_FIND_EMAIL_SEND_SUCCESSFUL);
        return new Result<>(true, message);
    }

    @Override
    public void tokenVerify(String token) throws BusinessException {
        this.userSecurityService.tokenVerify(token);
    }

    @Override
    public void resetPassword(PasswordResetParam param) throws BusinessException {
        this.userSecurityService.resetPasswordByEmailToken(param);
    }
}
