package com.sparrow.passport.controller.impl;

import com.sparrow.cache.exception.CacheNotFoundException;
import com.sparrow.constant.User;
import com.sparrow.exception.Asserts;
import com.sparrow.passport.api.UserRegisterService;
import com.sparrow.passport.controller.UserRegisterController;
import com.sparrow.passport.protocol.dto.LoginDTO;
import com.sparrow.passport.protocol.param.register.EmailActivateParam;
import com.sparrow.passport.protocol.param.register.EmailRegisterParam;
import com.sparrow.protocol.BusinessException;
import com.sparrow.protocol.ClientInformation;
import com.sparrow.protocol.constant.SparrowError;
import com.sparrow.servlet.ServletContainer;
import com.sparrow.support.Authenticator;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class UserRegisterControllerImpl implements UserRegisterController {
    private static final String VALIDATE_CODE = "register_validate_code";
    @Inject
    private UserRegisterService registeringUserApplicationService;
    @Inject
    private ServletContainer servletContainer;
    @Inject
    private Authenticator authenticatorService;

    private void validateCode(String validateCode, String userValidateCode) throws BusinessException {
        boolean expression = validateCode == null
            || !validateCode.equalsIgnoreCase(userValidateCode);
        Asserts.isTrue(expression, SparrowError.GLOBAL_VALIDATE_CODE_ERROR, VALIDATE_CODE);
    }

    @Override public LoginDTO emailRegister(EmailRegisterParam user,
        ClientInformation client) throws BusinessException, CacheNotFoundException {
        user.setClient(client);
        LoginDTO loginDto = registeringUserApplicationService.register(user);
        servletContainer
            .rootCookie(User.PERMISSION, loginDto.getPermission(), loginDto.getLoginUser().getDays());
        return loginDto;
    }

    @Override public Boolean sendTokenToEmail(EmailActivateParam emailActivateParam,
        ClientInformation client) throws BusinessException {
        emailActivateParam.setClient(client);
        this.registeringUserApplicationService.sendTokenToEmail(emailActivateParam);
        return true;
    }

    @Override
    public void activateEmail(String token, ClientInformation client) throws BusinessException {
        this.registeringUserApplicationService.activeEmail(token, client);
    }

}
