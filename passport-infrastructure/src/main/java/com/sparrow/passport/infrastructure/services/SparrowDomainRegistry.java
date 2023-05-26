package com.sparrow.passport.infrastructure.services;

import com.sparrow.passport.domain.service.*;
import com.sparrow.passport.repository.RegisteringUserRepository;
import com.sparrow.passport.repository.SecurityPrincipalRepository;
import com.sparrow.passport.domain.DomainRegistry;
import com.sparrow.passport.repository.UserProfileRepository;

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


    @Inject
    private UserProfileService userProfileService;

    @Inject
    private UserProfileRepository userProfileRepository;

    @Override
    public RegisteringUserRepository getRegisteringUserRepository() {
        return this.registeringUserRepository;
    }

    @Override
    public SecurityPrincipalService getSecurityPrincipalService() {
        return this.securityPrincipalService;
    }

    @Override
    public UserLimitService getUserLimitService() {
        return this.userLimitService;
    }

    @Override
    public SecurityPrincipalRepository getSecurityPrincipalRepository() {
        return this.securityPrincipalRepository;
    }

    @Override
    public EncryptionService getEncryptionService() {
        return this.encryptionService;
    }

    @Override
    public RegisteringUserService getRegisteringUserService() {
        return registeringUserService;
    }

    @Override
    public EmailService getEmailService() {
        return emailService;
    }

    @Override
    public UserProfileService getUserProfileService() {
        return userProfileService;
    }

    @Override
    public UserProfileRepository getUserProfileRepository() {
        return userProfileRepository;
    }
}
