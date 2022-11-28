package com.sparrow.passport.api;

import com.sparrow.passport.protocol.dto.LoginDTO;
import com.sparrow.passport.protocol.query.login.LoginQueryDTO;
import com.sparrow.protocol.BusinessException;

public interface UserLoginService {
    LoginDTO login(LoginQueryDTO login) throws BusinessException;
}
