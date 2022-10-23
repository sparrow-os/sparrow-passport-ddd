package com.sparrow.passport.api;

import com.sparrow.passport.protocol.param.password.PasswordResetParam;
import com.sparrow.protocol.BusinessException;
import com.sparrow.protocol.MobileShortMessaging;
import com.sparrow.passport.protocol.param.password.PasswordModifyParam;
import com.sparrow.passport.protocol.param.password.ResetPasswordByMobileParam;

public interface UserSecurityService {

    void sendFindPasswordToken(String email) throws BusinessException;

    MobileShortMessaging findPasswordByMobile(String mobile) throws BusinessException;

    Boolean resetPasswordByMobile(ResetPasswordByMobileParam password) throws BusinessException;
    public void resetPasswordByEmailToken(PasswordResetParam param) throws BusinessException;
    Boolean modifyPassword(PasswordModifyParam password) throws BusinessException;
}
