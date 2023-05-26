package com.sparrow.passport.domain;

import com.sparrow.passport.domain.service.*;
import com.sparrow.passport.repository.RegisteringUserRepository;
import com.sparrow.passport.repository.SecurityPrincipalRepository;
import com.sparrow.passport.repository.UserProfileRepository;

public interface DomainRegistry {
    RegisteringUserRepository getRegisteringUserRepository();

    UserProfileRepository getUserProfileRepository();

    RegisteringUserService getRegisteringUserService();

    SecurityPrincipalService getSecurityPrincipalService();

    UserLimitService getUserLimitService();

    SecurityPrincipalRepository getSecurityPrincipalRepository();

    EncryptionService getEncryptionService();

    EmailService getEmailService();


    UserProfileService getUserProfileService();

}
