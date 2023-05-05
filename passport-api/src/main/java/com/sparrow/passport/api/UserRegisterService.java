package com.sparrow.passport.api;

import com.sparrow.passport.protocol.dto.LoginDTO;
import com.sparrow.passport.protocol.param.register.EmailActivateParam;
import com.sparrow.passport.protocol.param.register.EmailRegisterParam;
import com.sparrow.passport.protocol.param.register.MobileRegisterParam;
import com.sparrow.passport.protocol.param.register.UserNameRegisterParam;
import com.sparrow.protocol.BusinessException;
import com.sparrow.protocol.ClientInformation;
import com.sparrow.protocol.LoginUser;

public interface UserRegisterService {
    LoginDTO register(UserNameRegisterParam registerParam) throws BusinessException;

    LoginDTO register(MobileRegisterParam registerParam) throws BusinessException;

    LoginDTO register(EmailRegisterParam registerParam,ClientInformation client) throws BusinessException;

    void sendTokenToEmail(EmailActivateParam emailActivateParam) throws BusinessException;

    void activeEmail(String token, ClientInformation client) throws BusinessException;
}
