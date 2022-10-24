package com.sparrow.passport.infrastructure.persistence.data.mapper;

import com.sparrow.passport.domain.entity.SecurityPrincipalEntity;
import com.sparrow.passport.po.SecurityPrincipal;
import javax.inject.Named;

@Named
public class SecurityPrincipalMapper {
    public SecurityPrincipal entity2Po(SecurityPrincipalEntity securityPrincipalEntity) {
        SecurityPrincipal securityPrincipal = new SecurityPrincipal();
        securityPrincipal.setUserId(securityPrincipalEntity.getUserId());
        securityPrincipal.setPassword(securityPrincipalEntity.getPassword());
        return securityPrincipal;
    }
}
