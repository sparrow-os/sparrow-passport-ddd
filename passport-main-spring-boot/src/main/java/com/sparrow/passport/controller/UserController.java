package com.sparrow.passport.controller;

import com.sparrow.protocol.LoginUser;
import com.sparrow.protocol.ThreadContext;

public class UserController {
    public String getUserName() {
        LoginUser loginUser = ThreadContext.getLoginToken();
        new Thread(new Runnable() {
            @Override public void run() {
                LoginUser loginUser = ThreadContext.getLoginToken();

            }
        });
        return "user";
    }
}
