package com.sparrow.passport.api;

import com.sparrow.protocol.BusinessException;
import com.sparrow.protocol.LoginToken;
import com.sparrow.passport.protocol.query.login.LoginQueryDTO;

public interface UserLoginService {
    LoginToken login(LoginQueryDTO login) throws BusinessException;
}
