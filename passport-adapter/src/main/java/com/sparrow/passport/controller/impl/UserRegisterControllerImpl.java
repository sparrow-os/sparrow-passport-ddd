package com.sparrow.passport.controller.impl;

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
import com.sparrow.support.CaptchaService;
import com.sparrow.support.web.HttpContext;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class UserRegisterControllerImpl implements UserRegisterController {
    @Inject
    private UserRegisterService registeringUserApplicationService;
    @Inject
    private ServletContainer servletContainer;

    @Inject
    private CaptchaService captchaService;

    private void validateCaptcha(String captcha, String userValidateCode) throws BusinessException {
        boolean expression = captcha == null
                || !captcha.equalsIgnoreCase(userValidateCode);
        Asserts.isTrue(expression, SparrowError.GLOBAL_VALIDATE_CODE_ERROR);
    }

    @Override
    public LoginDTO emailRegister(EmailRegisterParam user,
                                  ClientInformation client) throws BusinessException {
        String captcha = captchaService.getCaptcha(HttpContext.getContext().getRequest().getRequestedSessionId());
        this.validateCaptcha(user.getCaptcha(),
                captcha);
        LoginDTO loginDto = registeringUserApplicationService.register(user, client);
        servletContainer
                .cookie(Constant.REQUEST_HEADER_KEY_LOGIN_TOKEN, loginDto.getToken(), loginDto.getLoginUser().getDays());
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
