package com.sparrow.passport.mvc.controller;

import com.sparrow.mvc.RequestParameters;
import com.sparrow.mvc.ViewWithModel;
import com.sparrow.passport.controller.UserRegisterController;
import com.sparrow.passport.domain.DomainRegistry;
import com.sparrow.passport.protocol.dto.LoginDTO;
import com.sparrow.passport.protocol.param.register.EmailRegisterParam;
import com.sparrow.protocol.BusinessException;
import com.sparrow.protocol.ClientInformation;
import com.sparrow.servlet.Controller;

import javax.inject.Inject;

@Controller
public class UserRegisterControllerProxy {
    @Inject
    private UserRegisterController userRegisterController;

    @Inject
    private DomainRegistry domainRegistry;

    @RequestParameters("user,client")
    public LoginDTO shortcut(EmailRegisterParam user,
                             ClientInformation client) throws BusinessException {
        return this.userRegisterController.emailRegister(user, client);
    }

    @RequestParameters("user,client")
    public ViewWithModel emailRegister(EmailRegisterParam user,
                                       ClientInformation client) throws BusinessException {
        LoginDTO loginToken = this.userRegisterController.emailRegister(user, client);
        String welcomeUrl = this.domainRegistry.getWebConfigReader().getDefaultWelcomePage();
        return ViewWithModel.transit("/login-success", welcomeUrl, loginToken);
    }
}
