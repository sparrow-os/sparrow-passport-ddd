package com.sparrow.passport.infrastructure.services;

import com.sparrow.passport.domain.service.EmailService;
import com.sparrow.passport.domain.service.EncryptionService;
import com.sparrow.passport.domain.service.RegisteringUserService;
import com.sparrow.passport.domain.service.SecurityPrincipalService;
import com.sparrow.passport.domain.service.UserLimitService;
import com.sparrow.passport.repository.RegisteringUserRepository;
import com.sparrow.passport.repository.SecurityPrincipalRepository;
import com.sparrow.passport.domain.DomainRegistry;
import javax.inject.Inject;
import javax.inject.Named;

@Named("domainRegistry")
public class SparrowDomainRegistry implements DomainRegistry {
    @Inject
    private RegisteringUserRepository registeringUserRepository;
    @Inject
    private RegisteringUserService registeringUserService;
    @Inject
    private SecurityPrincipalRepository securityPrincipalRepository;
    @Inject
    private SecurityPrincipalService securityPrincipalService;
    @Inject
    private UserLimitService userLimitService;

     @Inject
    private EncryptionService encryptionService;
    @Inject
    private EmailService emailService;

    @Override public RegisteringUserRepository getRegisteringUserRepository() {
        return this.registeringUserRepository;
    }

    @Override public SecurityPrincipalService getSecurityPrincipalService() {
        return this.securityPrincipalService;
    }

    @Override public UserLimitService getUserLimitService() {
        return this.userLimitService;
    }

    @Override public SecurityPrincipalRepository getSecurityPrincipalRepository() {
        return this.securityPrincipalRepository;
    }

    @Override public EncryptionService getEncryptionService() {
        return this.encryptionService;
    }

    @Override public RegisteringUserService getRegisteringUserService() {
        return registeringUserService;
    }

    @Override public EmailService getEmailService() {
        return emailService;
    }
}
