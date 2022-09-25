package com.sparrow.passport.mvc.controller;

import com.sparrow.cache.exception.CacheNotFoundException;
import com.sparrow.constant.Config;
import com.sparrow.mvc.RequestParameters;
import com.sparrow.mvc.ViewWithModel;
import com.sparrow.passport.controller.UserLoginController;
import com.sparrow.passport.controller.protocol.query.LoginQuery;
import com.sparrow.protocol.BusinessException;
import com.sparrow.protocol.ClientInformation;
import com.sparrow.protocol.Controller;
import com.sparrow.protocol.LoginToken;
import com.sparrow.support.web.HttpContext;
import com.sparrow.utility.ConfigUtility;
import com.sparrow.utility.StringUtility;
import javax.inject.Inject;

@Controller
public class UserLoginControllerProxy {
    @Inject
    private UserLoginController userLoginController;

    @RequestParameters("login,client")
    public ViewWithModel login(LoginQuery login,
        ClientInformation client) throws BusinessException, CacheNotFoundException {
        LoginToken loginToken = userLoginController.login(login, client);
        String welcomePage = ConfigUtility.getValue(Config.DEFAULT_WELCOME_INDEX);
        if (StringUtility.isNullOrEmpty(login.getRedirectUrl())||login.getRedirectUrl().equals("/")) {
            login.setRedirectUrl(welcomePage);
        } else {
            HttpContext.getContext().put(Config.DEFAULT_WELCOME_INDEX, welcomePage);
        }
        return ViewWithModel.transit("/login-success", login.getRedirectUrl(), loginToken);
    }

    @RequestParameters("login,client")
    public LoginToken shortcut(LoginQuery login, ClientInformation client) throws BusinessException {
        return userLoginController.shortcut(login, client);
    }
    public void logout() {

    }
}
