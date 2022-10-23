package com.sparrow.passport.protocol.param.password;

import com.sparrow.protocol.POJO;

public class PasswordResetParam implements POJO {
    private String token;
    private String password;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
