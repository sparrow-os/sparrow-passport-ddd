package com.sparrow.passport.api;

import com.sparrow.passport.protocol.param.password.PasswordResetParam;
import com.sparrow.protocol.BusinessException;
import com.sparrow.passport.protocol.param.password.PasswordModifyParam;
import com.sparrow.passport.protocol.param.password.ResetPasswordByMobileParam;

public interface UserSecurityService {

    void sendFindPasswordToken(String email) throws BusinessException;

    Boolean resetPasswordByMobile(ResetPasswordByMobileParam password) throws BusinessException;

    void tokenVerify(String token) throws BusinessException;

    void resetPasswordByEmailToken(PasswordResetParam param) throws BusinessException;

    Boolean modifyPassword(PasswordModifyParam password) throws BusinessException;
}
