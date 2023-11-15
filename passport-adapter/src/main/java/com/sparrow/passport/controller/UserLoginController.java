package com.sparrow.passport.controller;

import com.sparrow.passport.protocol.dto.LoginDTO;
import com.sparrow.passport.protocol.query.login.LoginQuery;
import com.sparrow.protocol.BusinessException;
import com.sparrow.protocol.ClientInformation;

public interface UserLoginController {
    /**
     * 登录验证码
     */
    String USER_LOGIN_VALIDATE_CODE_SUFFIX = "login_validate_code_suffix";

    LoginDTO login(LoginQuery login,
                   ClientInformation client) throws BusinessException;

    LoginDTO shortcut(LoginQuery login, ClientInformation client) throws BusinessException;

    void logout();
}
