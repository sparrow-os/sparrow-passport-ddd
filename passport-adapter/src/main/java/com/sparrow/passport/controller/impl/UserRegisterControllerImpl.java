package com.sparrow.passport.controller.impl;

import com.sparrow.constant.SparrowError;
import com.sparrow.constant.User;
import com.sparrow.exception.Asserts;
import com.sparrow.exception.CacheNotFoundException;
import com.sparrow.protocol.Authenticator;
import com.sparrow.protocol.BusinessException;
import com.sparrow.protocol.ClientInformation;
import com.sparrow.protocol.LoginToken;
import com.sparrow.protocol.constant.Constant;
import com.sparrow.servlet.ServletContainer;
import com.sparrow.passport.api.UserRegisterService;
import com.sparrow.passport.controller.UserRegisterController;
import com.sparrow.passport.protocol.param.register.EmailRegisterParam;
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

    @Override
    public LoginToken shortcut(EmailRegisterParam user, ClientInformation client) throws BusinessException {
        user.setClient(client);
        return registeringUserApplicationService.register(user);
    }

    @Override
    public LoginToken emailRegister(EmailRegisterParam user,
        ClientInformation client) throws BusinessException, CacheNotFoundException {
        String validateCode = servletContainer.flash(Constant.VALIDATE_CODE);
        this.validateCode(validateCode, user.getValidateCode());
        LoginToken login = shortcut(user, client);
        String token = authenticatorService.sign(login, user.getPassword());
        servletContainer.rootCookie(User.PERMISSION, token, login.getDays());
        return login;
    }
}
