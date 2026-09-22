/*
Licensed to the Apache Software Foundation (ASF) under one or more
contributor license agreements.  See the NOTICE file distributed with
this work for additional information regarding copyright ownership.
The ASF licenses this file to You under the Apache License, Version 2.0
(the "License"); you may not use this file except in compliance with
the License.  You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/

package com.sparrow.passport.infrastructure.services;

import com.sparrow.authenticator.AuthenticatorConfigReader;
import com.sparrow.email.EmailSender;
import com.sparrow.passport.domain.DomainRegistry;
import com.sparrow.passport.domain.service.*;
import com.sparrow.passport.repository.RegisteringUserRepository;
import com.sparrow.passport.repository.SecurityPrincipalRepository;
import com.sparrow.passport.repository.UserProfileRepository;
import com.sparrow.passport.repository.VisitorRepository;
import com.sparrow.support.web.WebConfigReader;

import jakarta.inject.Inject;
import jakarta.inject.Named;

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
    public AuthenticatorConfigReader getAuthenticatorConfigReader() {
        return this.authenticatorConfigReader;
    }

    @Override
    public UserProfileRepository getUserProfileRepository() {
        return userProfileRepository;
    }

    @Override
    public EmailSender getEmailSender() {
        return emailSender;
    }

    @Override
    public WebConfigReader getWebConfigReader() {
        return webConfigReader;
    }

}
