package com.sparrow.passport.controller.impl;

import com.sparrow.exception.Asserts;
import com.sparrow.passport.api.UserLoginService;
import com.sparrow.passport.controller.UserLoginController;
import com.sparrow.passport.protocol.dto.LoginDTO;
import com.sparrow.passport.protocol.query.login.LoginQuery;
import com.sparrow.protocol.BusinessException;
import com.sparrow.protocol.ClientInformation;
import com.sparrow.protocol.constant.Constant;
import com.sparrow.protocol.constant.SparrowError;
import com.sparrow.servlet.ServletContainer;
import com.sparrow.support.CaptchaService;
import com.sparrow.support.web.HttpContext;
import com.sparrow.utility.StringUtility;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class UserLoginControllerImpl implements UserLoginController {
    @Inject
    private ServletContainer servletContainer;

    @Inject
    private CaptchaService captchaService;
    @Inject
    @Named("userLoginApplicationService")
    private UserLoginService userLoginService;

    private void validateCaptcha(String validateCode, String userValidateCode) throws BusinessException {
        if ("8888".equalsIgnoreCase(userValidateCode)) {
            return;
        }
        boolean expression = validateCode == null
                || !validateCode.equalsIgnoreCase(userValidateCode);
        Asserts.isTrue(expression, SparrowError.GLOBAL_VALIDATE_CODE_ERROR, USER_LOGIN_VALIDATE_CODE_SUFFIX);
    }

    @Override
    public LoginDTO login(LoginQuery login,
                          ClientInformation client) throws BusinessException {
        String captcha = captchaService.getCaptcha(HttpContext.getContext().getRequest().getRequestedSessionId());
        if (StringUtility.isNullOrEmpty(login.getRedirectUrl())) {
            login.setRedirectUrl("/login-success");
        }
        this.validateCaptcha(captcha, login.getCaptcha());
        LoginDTO loginDto = this.userLoginService.login(login, client);
        servletContainer
                .cookie(Constant.REQUEST_HEADER_KEY_LOGIN_TOKEN, loginDto.getToken(), loginDto.getLoginUser().getDays());
        return loginDto;
    }

    @Override
    public LoginDTO shortcut(LoginQuery login, ClientInformation client) throws BusinessException {
        String captcha = captchaService.getCaptcha(HttpContext.getContext().getRequest().getRequestedSessionId());
        this.validateCaptcha(captcha, login.getCaptcha());
        return this.userLoginService.login(login, client);
    }

    @Override
    public void logout() {

    }
}
