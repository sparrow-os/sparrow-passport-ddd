package com.sparrow.passport.controller;

import com.sparrow.cache.exception.CacheNotFoundException;
import com.sparrow.passport.protocol.param.register.EmailRegisterParam;
import com.sparrow.protocol.BusinessException;
import com.sparrow.protocol.ClientInformation;
import com.sparrow.protocol.LoginToken;

/**
 * Created by harry on 16/12/17.
 */
public interface UserRegisterController {

    /**
     * 用户名快捷注册
     *
     * @param user
     * @throws BusinessException
     */
    LoginToken shortcut(EmailRegisterParam user,ClientInformation client) throws BusinessException;

    /**
     * 用户名注册
     *
     * @param user
     * @return
     * @throws BusinessException
     */
    LoginToken emailRegister(EmailRegisterParam user, ClientInformation client) throws BusinessException, CacheNotFoundException;
}
