package com.sparrow.passport.controller;

import com.sparrow.cache.exception.CacheNotFoundException;
import com.sparrow.passport.protocol.dto.LoginDTO;
import com.sparrow.passport.protocol.param.register.EmailActivateParam;
import com.sparrow.passport.protocol.param.register.EmailRegisterParam;
import com.sparrow.protocol.BusinessException;
import com.sparrow.protocol.ClientInformation;

public interface UserRegisterController {

    LoginDTO emailRegister(EmailRegisterParam user,
        ClientInformation client) throws BusinessException, CacheNotFoundException;

    Boolean sendTokenToEmail(EmailActivateParam emailActivateParam, ClientInformation client) throws BusinessException;

    void activateEmail(String token, ClientInformation client) throws BusinessException;
}
