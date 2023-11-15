package com.sparrow.passport.controller.impl;

import com.sparrow.constant.ConfigKeyLanguage;
import com.sparrow.passport.api.UserSecurityService;
import com.sparrow.passport.controller.UserSecurityController;
import com.sparrow.passport.protocol.param.password.PasswordModifyParam;
import com.sparrow.passport.protocol.param.password.PasswordResetParam;
import com.sparrow.protocol.BusinessException;
import com.sparrow.protocol.Result;
import com.sparrow.utility.ConfigUtility;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class UserSecurityControllerImpl implements UserSecurityController {
    @Inject
    private UserSecurityService userSecurityService;

    @Override
    public Boolean modifyPassword(String newPassword, String oldPassword) throws BusinessException {
        PasswordModifyParam passwordModifyDTO = null;
        return this.userSecurityService.modifyPassword(passwordModifyDTO);
    }

    @Override
    public Result<Boolean> sendEmailTokenForFindPassword(String email) throws BusinessException {
        this.userSecurityService.sendFindPasswordToken(email);
        String message=ConfigUtility.getLanguageValue(ConfigKeyLanguage.PASSWORD_FIND_EMAIL_SEND_SUCCESSFUL);
        Result<Boolean> result = new Result<>(true,message);
        return result;
    }

    @Override public void tokenVerify(String token) throws BusinessException {
        this.userSecurityService.tokenVerify(token);
    }

    @Override
    public void resetPassword(PasswordResetParam param) throws BusinessException {
         this.userSecurityService.resetPasswordByEmailToken(param);
    }
}
