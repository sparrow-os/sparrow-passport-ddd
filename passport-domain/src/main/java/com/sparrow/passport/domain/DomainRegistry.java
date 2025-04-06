package com.sparrow.passport.domain;

import com.sparrow.email.EmailSender;
import com.sparrow.passport.domain.service.*;
import com.sparrow.passport.repository.RegisteringUserRepository;
import com.sparrow.passport.repository.SecurityPrincipalRepository;
import com.sparrow.passport.repository.UserProfileRepository;
import com.sparrow.support.AuthenticatorConfigReader;
import com.sparrow.support.web.WebConfigReader;

public interface DomainRegistry {
    RegisteringUserRepository getRegisteringUserRepository();

    UserProfileRepository getUserProfileRepository();

    RegisteringUserService getRegisteringUserService();

    SecurityPrincipalService getSecurityPrincipalService();

    UserLimitService getUserLimitService();

    SecurityPrincipalRepository getSecurityPrincipalRepository();

    EncryptionService getEncryptionService();


    UserProfileService getUserProfileService();

    AuthenticatorConfigReader getAuthenticatorConfigReader();

    EmailSender getEmailSender();

    WebConfigReader getWebConfigReader();

}
