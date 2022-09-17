package com.sparrow.passport.controller.assemble;

import com.sparrow.protocol.ClientInformation;
import com.sparrow.passport.controller.protocol.query.LoginQuery;
import com.sparrow.passport.protocol.query.login.LoginQueryDTO;
import javax.inject.Named;

@Named
public class LoginControllerAssemble {
    public LoginQueryDTO vo2dto(LoginQuery vo, ClientInformation client) {
        LoginQueryDTO loginQuery = new LoginQueryDTO();
        loginQuery.setClient(client);
        loginQuery.setPassword(vo.getPassword());
        loginQuery.setUserName(vo.getUserName());
        loginQuery.setRemember(vo.getRemember());
        if (loginQuery.getRemember() == null) {
            loginQuery.setRemember(false);
        }
        return loginQuery;
    }
}
