package com.sparrow.passport.mvc.controller;

import com.sparrow.cache.exception.CacheNotFoundException;
import com.sparrow.constant.Config;
import com.sparrow.mvc.RequestParameters;
import com.sparrow.mvc.ViewWithModel;
import com.sparrow.passport.controller.UserRegisterController;
import com.sparrow.passport.protocol.param.register.EmailRegisterParam;
import com.sparrow.protocol.BusinessException;
import com.sparrow.protocol.ClientInformation;
import com.sparrow.protocol.Controller;
import com.sparrow.protocol.LoginToken;
import com.sparrow.utility.ConfigUtility;
import javax.inject.Inject;

@Controller
public class UserRegisterControllerProxy {
    @Inject
    private UserRegisterController userRegisterController;

    @RequestParameters("user,client")
    public LoginToken shortcut(EmailRegisterParam user, ClientInformation client) throws BusinessException {
        return this.userRegisterController.shortcut(user, client);
    }

    @RequestParameters("user,client")
    public ViewWithModel emailRegister(EmailRegisterParam user,
        ClientInformation client) throws BusinessException, CacheNotFoundException {
        LoginToken loginToken = this.userRegisterController.emailRegister(user, client);
        String welcomeUrl = ConfigUtility.getValue(Config.DEFAULT_WELCOME_INDEX);
        return ViewWithModel.transit("/login-success", welcomeUrl, loginToken);
    }
}
