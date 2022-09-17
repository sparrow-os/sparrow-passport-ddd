package com.sparrow.passport.api;

import com.sparrow.protocol.BusinessException;
import com.sparrow.protocol.LoginToken;
import com.sparrow.passport.protocol.param.register.EmailRegisterParam;
import com.sparrow.passport.protocol.param.register.MobileRegisterParam;
import com.sparrow.passport.protocol.param.register.UserNameRegisterParam;

public interface UserRegisterService {
    LoginToken register(UserNameRegisterParam registerParam) throws BusinessException;

    LoginToken register(MobileRegisterParam registerParam) throws BusinessException;

    LoginToken register(EmailRegisterParam registerParam) throws BusinessException;

    void sendTokenToEmail(String email, Long userId) throws BusinessException;

    String activeEmail(String token) throws BusinessException;
}
