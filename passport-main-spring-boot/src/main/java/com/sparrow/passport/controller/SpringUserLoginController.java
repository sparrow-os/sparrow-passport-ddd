package com.sparrow.passport.controller;

import com.sparrow.cache.exception.CacheNotFoundException;
import com.sparrow.passport.controller.protocol.query.LoginQuery;
import com.sparrow.protocol.BusinessException;
import com.sparrow.protocol.ClientInformation;
import com.sparrow.protocol.LoginToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class SpringUserLoginController {
    @Autowired
    private UserLoginController userLoginController;

    public LoginToken login(LoginQuery login,
        ClientInformation client) throws BusinessException, CacheNotFoundException {
        return this.userLoginController.login(login, client);
    }

    public LoginToken shortcut(LoginQuery login, ClientInformation client) throws BusinessException {
        return this.userLoginController.shortcut(login, client);
    }

    public void logout() {
        this.userLoginController.logout();
    }
}
