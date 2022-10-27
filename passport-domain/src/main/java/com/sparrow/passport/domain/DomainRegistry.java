package com.sparrow.passport.domain;

import com.sparrow.passport.domain.service.EmailService;
import com.sparrow.passport.domain.service.EncryptionService;
import com.sparrow.passport.domain.service.RegisteringUserService;
import com.sparrow.passport.domain.service.SecurityPrincipalService;
import com.sparrow.passport.domain.service.UserLimitService;
import com.sparrow.passport.repository.RegisteringUserRepository;
import com.sparrow.passport.repository.SecurityPrincipalRepository;

public interface DomainRegistry {
    RegisteringUserRepository getRegisteringUserRepository();

    RegisteringUserService getRegisteringUserService();

    SecurityPrincipalService getSecurityPrincipalService();

    UserLimitService getUserLimitService();

    SecurityPrincipalRepository getSecurityPrincipalRepository();

    EncryptionService getEncryptionService();

    EmailService getEmailService();

}
