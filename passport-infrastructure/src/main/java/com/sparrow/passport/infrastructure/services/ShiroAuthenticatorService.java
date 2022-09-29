package com.sparrow.passport.infrastructure.services;

import com.sparrow.passport.infrastructure.support.shiro.JwtUtils;
import com.sparrow.protocol.LoginToken;
import com.sparrow.support.Authenticator;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class ShiroAuthenticatorService implements Authenticator {
    @Inject
    private JwtUtils jwtUtils;
    @Override public String sign(LoginToken token, String s) {
        return jwtUtils.generateToken(token);
    }

    @Override public LoginToken authenticate(String s, String s1) {
        return null;
    }
}
