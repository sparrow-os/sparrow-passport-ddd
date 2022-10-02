package com.sparrow.passport.infrastructure.services;

import com.sparrow.passport.infrastructure.support.shiro.JwtToken;
import com.sparrow.passport.infrastructure.support.shiro.JwtUtils;
import com.sparrow.protocol.LoginToken;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class JwtRealm extends AuthorizingRealm {
    private JwtUtils jwtUtils;

    public JwtRealm(CacheManager cacheManager,
        JwtUtils jwtUtils) {
        super(cacheManager);
        this.jwtUtils = jwtUtils;
    }

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        JwtToken jwtToken = (JwtToken) authenticationToken;
        String userId = jwtUtils.getClaimsByToken((String) jwtToken.getPrincipal()).getSubject();
        LoginToken user = new LoginToken();//userService.getById(Long.valueOf(userId));
//        if (user == null) {
//            throw new UnknownAccountException("账户不存在");
//        }
//
//        if (user.getStatus() == -1) {
//            throw new LockedAccountException("账户已被锁定");
//        }
        return new SimpleAuthenticationInfo(user, jwtToken.getCredentials(), getName());
    }
}
