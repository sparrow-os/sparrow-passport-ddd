package com.sparrow.passport.controller;

import com.sparrow.cache.exception.CacheNotFoundException;
import com.sparrow.passport.protocol.param.register.EmailActivateParam;
import com.sparrow.passport.protocol.param.register.EmailRegisterParam;
import com.sparrow.protocol.BusinessException;
import com.sparrow.protocol.ClientInformation;
import com.sparrow.protocol.LoginToken;

public interface UserRegisterController {

    LoginToken shortcut(EmailRegisterParam user, ClientInformation client) throws BusinessException;

    LoginToken emailRegister(EmailRegisterParam user,
        ClientInformation client) throws BusinessException, CacheNotFoundException;

    Boolean sendTokenToEmail(EmailActivateParam emailActivateParam, ClientInformation client) throws BusinessException;

}
