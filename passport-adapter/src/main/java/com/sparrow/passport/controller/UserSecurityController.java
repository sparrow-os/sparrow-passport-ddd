package com.sparrow.passport.controller;

import com.sparrow.protocol.BusinessException;
import com.sparrow.passport.controller.protocol.vo.FindPasswordVO;

public interface UserSecurityController {

    Boolean modifyPassword(String newPassword, String oldPassword) throws BusinessException;

    String sendEmailTokenForFindPassword(String email) throws BusinessException;

    FindPasswordVO findPassword(String email) throws BusinessException;

    Boolean resetPassword(String token, String newPassword) throws BusinessException;

}
