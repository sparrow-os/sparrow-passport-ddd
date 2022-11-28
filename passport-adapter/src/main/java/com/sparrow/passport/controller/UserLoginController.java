package com.sparrow.passport.controller;

import com.sparrow.cache.exception.CacheNotFoundException;
import com.sparrow.passport.controller.protocol.query.LoginQuery;
import com.sparrow.passport.protocol.dto.LoginDTO;
import com.sparrow.protocol.BusinessException;
import com.sparrow.protocol.ClientInformation;

public interface UserLoginController {
    /**
     * 登录验证码
     */
    String USER_LOGIN_VALIDATE_CODE = "login_validate_code";

    LoginDTO login(LoginQuery login,
        ClientInformation client) throws BusinessException, CacheNotFoundException;

    LoginDTO shortcut(LoginQuery login, ClientInformation client) throws BusinessException;

    void logout();
}
