package com.sparrow.passport.infrastructure.services;

import com.sparrow.container.ConfigReader;
import com.sparrow.email.EmailSender;
import com.sparrow.passport.domain.service.*;
import com.sparrow.passport.repository.RegisteringUserRepository;
import com.sparrow.passport.repository.SecurityPrincipalRepository;
import com.sparrow.passport.domain.DomainRegistry;
import com.sparrow.passport.repository.UserProfileRepository;
import com.sparrow.passport.repository.VisitorRepository;
import com.sparrow.support.AuthenticatorConfigReader;
import com.sparrow.support.web.WebConfigReader;

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
    private AuthenticatorConfigReader authenticatorConfigReader;

    @Inject
    private WebConfigReader webConfigReader;
    @Inject
    private EncryptionService encryptionService;

    @Inject
    private UserProfileService userProfileService;

    @Inject
    private UserProfileRepository userProfileRepository;

    @Inject
    private EmailSender emailSender;

    @Inject
    private VisitorRepository visitorRepository;

    @Override
    public RegisteringUserRepository getRegisteringUserRepository() {
        return this.registeringUserRepository;
    }

    @Override
    public VisitorRepository getVisitorRepository() {
        return this.visitorRepository;
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
    public UserProfileService getUserProfileService() {
        return userProfileService;
    }

    @Override
    public AuthenticatorConfigReader getAuthenticatorConfigReader() {
        return this.authenticatorConfigReader;
    }

    @Override
    public UserProfileRepository getUserProfileRepository() {
        return userProfileRepository;
    }

    public EmailSender getEmailSender() {
        return emailSender;
    }

    public WebConfigReader getWebConfigReader() {
        return webConfigReader;
    }

}
