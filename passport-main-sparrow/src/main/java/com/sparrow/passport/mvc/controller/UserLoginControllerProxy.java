package com.sparrow.passport.mvc.controller;

import com.sparrow.cache.exception.CacheNotFoundException;
import com.sparrow.constant.Config;
import com.sparrow.mvc.RequestParameters;
import com.sparrow.mvc.ViewWithModel;
import com.sparrow.passport.controller.UserLoginController;
import com.sparrow.passport.controller.protocol.query.LoginQuery;
import com.sparrow.passport.po.User;
import com.sparrow.passport.protocol.dto.LoginDTO;
import com.sparrow.protocol.BusinessException;
import com.sparrow.protocol.ClientInformation;
import com.sparrow.servlet.Controller;
import com.sparrow.support.web.HttpContext;
import com.sparrow.utility.ConfigUtility;
import com.sparrow.utility.StringUtility;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

@Controller
public class UserLoginControllerProxy {
    @Inject
    private UserLoginController userLoginController;

    public ViewWithModel thymeleaf(HttpServletRequest request) {
        User user = new User();
        user.setUserId(1L);
        request.setAttribute("user", user);
        return ViewWithModel.forward("thymeleaf-test");
    }

    @RequestParameters("login,client")
    public ViewWithModel login(LoginQuery login,
        ClientInformation client) throws BusinessException, CacheNotFoundException {
        LoginDTO loginDto = userLoginController.login(login, client);
        String welcomePage = ConfigUtility.getValue(Config.DEFAULT_WELCOME_INDEX);
        if (StringUtility.isNullOrEmpty(login.getRedirectUrl()) || login.getRedirectUrl().equals("/")) {
            login.setRedirectUrl(welcomePage);
        } else {
            HttpContext.getContext().put(Config.DEFAULT_WELCOME_INDEX, welcomePage);
        }
        return ViewWithModel.transit("/login-success", login.getRedirectUrl(), loginDto);
    }

    @RequestParameters("login,client")
    public LoginDTO shortcut(LoginQuery login, ClientInformation client) throws BusinessException {
        return userLoginController.shortcut(login, client);
    }

    public void logout() {

    }
}
