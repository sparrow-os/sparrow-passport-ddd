package com.sparrow.passport.controller;

import com.sparrow.passport.protocol.param.register.EmailActivateParam;
import com.sparrow.passport.protocol.param.register.EmailRegisterParam;
import com.sparrow.protocol.BusinessException;
import com.sparrow.protocol.ClientInformation;
import com.sparrow.protocol.LoginToken;

public interface UserRegisterController {

    LoginToken emailRegister(EmailRegisterParam user,
        ClientInformation client) throws BusinessException;

    Boolean sendTokenToEmail(EmailActivateParam emailActivateParam, ClientInformation client) throws BusinessException;

}
