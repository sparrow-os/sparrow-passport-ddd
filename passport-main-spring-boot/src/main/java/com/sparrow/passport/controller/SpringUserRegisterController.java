package com.sparrow.passport.controller;

import com.sparrow.cache.exception.CacheNotFoundException;
import com.sparrow.constant.User;
import com.sparrow.passport.controller.protocol.query.LoginQuery;
import com.sparrow.passport.protocol.param.register.EmailRegisterParam;
import com.sparrow.protocol.BusinessException;
import com.sparrow.protocol.ClientInformation;
import com.sparrow.protocol.LoginToken;
import com.sparrow.protocol.constant.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class SpringUserRegisterController {
    @Autowired
    private UserRegisterController userRegisterController;

    @PostMapping("/email/shortcut")
    public LoginToken shortcut(@RequestBody EmailRegisterParam user, ClientInformation client) throws BusinessException {
        return userRegisterController.shortcut(user, client);
    }

    @PostMapping("/email")
    public LoginToken emailRegister(@RequestBody EmailRegisterParam user,
        ClientInformation client) throws BusinessException, CacheNotFoundException {
        return this.userRegisterController.emailRegister(user, client);
    }
}
