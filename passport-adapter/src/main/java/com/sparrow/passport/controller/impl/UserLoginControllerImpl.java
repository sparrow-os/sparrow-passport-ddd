/*
Licensed to the Apache Software Foundation (ASF) under one or more
contributor license agreements.  See the NOTICE file distributed with
this work for additional information regarding copyright ownership.
The ASF licenses this file to You under the Apache License, Version 2.0
(the "License"); you may not use this file except in compliance with
the License.  You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/

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

import jakarta.inject.Inject;
import jakarta.inject.Named;

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
        boolean expression = validateCode == null
                || !validateCode.equalsIgnoreCase(userValidateCode);
        Asserts.isTrue(expression, SparrowError.GLOBAL_VALIDATE_CODE_ERROR);
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
    public LoginDTO getVisitorToken(ClientInformation client) throws BusinessException {
        return this.userLoginService.getVisitor(client.getDeviceId());
    }

    @Override
    public void logout() {

    }
}
