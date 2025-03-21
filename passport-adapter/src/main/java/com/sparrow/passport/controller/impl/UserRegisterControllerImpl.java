package com.sparrow.passport.controller.impl;

import com.sparrow.constant.User;
import com.sparrow.exception.Asserts;
import com.sparrow.passport.api.UserRegisterService;
import com.sparrow.passport.controller.UserRegisterController;
import com.sparrow.passport.protocol.dto.LoginDTO;
import com.sparrow.passport.protocol.param.register.EmailActivateParam;
import com.sparrow.passport.protocol.param.register.EmailRegisterParam;
import com.sparrow.protocol.BusinessException;
import com.sparrow.protocol.ClientInformation;
import com.sparrow.protocol.constant.Constant;
import com.sparrow.protocol.constant.SparrowError;
import com.sparrow.servlet.ServletContainer;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class UserRegisterControllerImpl implements UserRegisterController {
    private static final String VALIDATE_CODE_SUFFIX = "register_validate_code";
    @Inject
    private UserRegisterService registeringUserApplicationService;
    @Inject
    private ServletContainer servletContainer;

    private void validateCaptcha(String captcha, String userValidateCode) throws BusinessException {
        boolean expression = captcha == null
                || !captcha.equalsIgnoreCase(userValidateCode);
        Asserts.isTrue(expression, SparrowError.GLOBAL_VALIDATE_CODE_ERROR, VALIDATE_CODE_SUFFIX);
    }

    @Override
    public LoginDTO emailRegister(EmailRegisterParam user,
                                  ClientInformation client) throws BusinessException {
        String captcha = servletContainer.flash(Constant.VALIDATE_CODE);
        this.validateCaptcha(user.getCaptcha(),
                captcha);
        LoginDTO loginDto = registeringUserApplicationService.register(user, client);
        servletContainer
                .rootCookie(Constant.REQUEST_HEADER_KEY_LOGIN_TOKEN, loginDto.getToken(), loginDto.getLoginUser().getDays());
        return loginDto;
    }

    @Override
    public Boolean sendTokenToEmail(EmailActivateParam emailActivateParam,
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
