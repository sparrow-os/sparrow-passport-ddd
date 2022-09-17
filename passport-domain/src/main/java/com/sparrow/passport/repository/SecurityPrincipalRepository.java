package com.sparrow.passport.repository;

import com.sparrow.passport.domain.entity.SecurityPrincipal;

public interface SecurityPrincipalRepository {
    SecurityPrincipal findByUserId(Long userId);

    SecurityPrincipal findByEmail(String email);

    SecurityPrincipal findByName(String userName);

    SecurityPrincipal findByMobile(String mobile, String secretMobile);

    void saveSecurity(SecurityPrincipal securityPrincipal);
}
