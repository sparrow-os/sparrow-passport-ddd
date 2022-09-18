package com.sparrow.passport.controller;

import com.sparrow.cache.exception.CacheNotFoundException;
import com.sparrow.protocol.BusinessException;
import com.sparrow.protocol.ClientInformation;
import com.sparrow.protocol.LoginToken;
import com.sparrow.passport.controller.protocol.query.LoginQuery;

public interface UserLoginController {
    /**
     * 登录验证码
     */
    String USER_LOGIN_VALIDATE_CODE = "login_validate_code";

    LoginToken login(LoginQuery login,
        ClientInformation client) throws BusinessException, CacheNotFoundException;

    LoginToken shortcut(LoginQuery login, ClientInformation client) throws BusinessException;

    void logout();
}
