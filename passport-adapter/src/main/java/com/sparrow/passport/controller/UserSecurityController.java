package com.sparrow.passport.controller;

import com.sparrow.passport.protocol.param.password.PasswordResetParam;
import com.sparrow.protocol.BusinessException;
import com.sparrow.passport.controller.protocol.vo.FindPasswordVO;
import com.sparrow.protocol.Result;

public interface UserSecurityController {

    Boolean modifyPassword(String newPassword, String oldPassword) throws BusinessException;

    Result<Boolean> sendEmailTokenForFindPassword(String email) throws BusinessException;

    void tokenVerify(String token) throws BusinessException;


    void resetPassword(PasswordResetParam param) throws BusinessException;

}
