package com.sparrow.passport.infrastructure.persistence.data.converter;

import com.sparrow.enums.Gender;
import com.sparrow.passport.domain.entity.RegisteringUserEntity;
import com.sparrow.passport.domain.entity.SecurityPrincipalEntity;
import com.sparrow.passport.po.SecurityPrincipal;
import com.sparrow.passport.po.User;
import com.sparrow.protocol.ClientInformation;
import com.sparrow.protocol.constant.magic.Symbol;
import com.sparrow.protocol.enums.StatusRecord;
import com.sparrow.support.IpSupport;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class SecurityPrincipalConverter {

    @Inject
    private IpSupport ipSupport;

    public SecurityPrincipal entity2Po(SecurityPrincipalEntity securityPrincipalEntity) {
        SecurityPrincipal securityPrincipal = new SecurityPrincipal();
        securityPrincipal.setUserId(securityPrincipalEntity.getUserId());
        securityPrincipal.setPassword(securityPrincipalEntity.getPassword());
        return securityPrincipal;
    }


    public SecurityPrincipalEntity user2SecurityPrincipal(User user) {
        if (user == null) {
            return null;
        }
        SecurityPrincipalEntity securityPrincipal = new SecurityPrincipalEntity();
        securityPrincipal.setActivate(user.getActivate());
        securityPrincipal.setEmail(user.getEmail());
        securityPrincipal.setMobile(user.getMobile());
        securityPrincipal.setUserName(user.getUserName());
        securityPrincipal.setLastLoginTime(user.getLastLoginTime());
        securityPrincipal.setUserId(user.getUserId());
        securityPrincipal.setCategory(user.getCategory());
        securityPrincipal.setPassword(user.getPassword());
        securityPrincipal.setStatus(user.getStatus().ordinal());
        return securityPrincipal;
    }
}
