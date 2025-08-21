package com.sparrow.passport.api;

import com.sparrow.passport.protocol.dto.LoginDTO;
import com.sparrow.passport.protocol.query.login.LoginQuery;
import com.sparrow.protocol.BusinessException;
import com.sparrow.protocol.ClientInformation;
import com.sparrow.protocol.LoginUser;

public interface UserLoginService {
    LoginDTO login(LoginQuery login, ClientInformation client) throws BusinessException;

    LoginDTO getVisitor(String host) throws BusinessException;
}
