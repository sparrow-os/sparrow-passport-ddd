package com.sparrow.passport.controller.impl;

import com.sparrow.constant.ConfigKeyLanguage;
import com.sparrow.protocol.BusinessException;
import com.sparrow.passport.api.UserSecurityService;
import com.sparrow.passport.controller.UserSecurityController;
import com.sparrow.passport.controller.protocol.vo.FindPasswordVO;
import com.sparrow.passport.protocol.param.password.PasswordModifyParam;
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
    public String sendEmailTokenForFindPassword(String email) throws BusinessException {
        this.userSecurityService.sendEmailTokenForFindPassword(email);
        return ConfigUtility.getLanguageValue(ConfigKeyLanguage.PASSWORD_FIND_EMAIL_SEND_SUCCESSFUL);
    }

    @Override
    public FindPasswordVO findPassword(String email) throws BusinessException {
        String officialEmailAddress = this.userSecurityService.findPasswordByEmail(email);
        return new FindPasswordVO(email, officialEmailAddress);
    }

    @Override
    public Boolean resetPassword(String token, String newPassword) throws BusinessException {
        return this.userSecurityService.resetPasswordByEmailToken(token, newPassword);
    }
}
