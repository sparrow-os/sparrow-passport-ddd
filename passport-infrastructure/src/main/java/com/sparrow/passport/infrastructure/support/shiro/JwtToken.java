package com.sparrow.passport.infrastructure.support.shiro;

import org.apache.shiro.authc.UsernamePasswordToken;

public class JwtToken extends UsernamePasswordToken {

    public JwtToken(String username, String password, String host, String token) {
        super(username, password, host);
        this.token = token;
    }

    private String token;

    public JwtToken(String jwt) {
        this.token = jwt;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }

    @Override public boolean isRememberMe() {
        return true;
    }
}
