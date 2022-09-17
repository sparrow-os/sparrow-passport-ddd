package com.sparrow.passport.api;

import com.sparrow.protocol.BusinessException;
import com.sparrow.protocol.MobileShortMessaging;
import com.sparrow.passport.protocol.param.password.PasswordModifyParam;
import com.sparrow.passport.protocol.param.password.ResetPasswordByMobileParam;

public interface UserSecurityService {

    void sendEmailTokenForFindPassword(String email) throws BusinessException;

    String findPasswordByEmail(String email) throws BusinessException;

    MobileShortMessaging findPasswordByMobile(String mobile) throws BusinessException;

    Boolean resetPasswordByMobile(ResetPasswordByMobileParam password) throws BusinessException;

    Boolean resetPasswordByEmailToken(String token, String newPassword) throws BusinessException;

    Boolean modifyPassword(PasswordModifyParam password) throws BusinessException;
}
