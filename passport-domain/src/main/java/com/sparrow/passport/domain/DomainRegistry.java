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

package com.sparrow.passport.domain;

import com.sparrow.authenticator.AuthenticatorConfigReader;
import com.sparrow.email.EmailSender;
import com.sparrow.passport.domain.service.*;
import com.sparrow.passport.repository.RegisteringUserRepository;
import com.sparrow.passport.repository.SecurityPrincipalRepository;
import com.sparrow.passport.repository.UserProfileRepository;
import com.sparrow.passport.repository.VisitorRepository;
import com.sparrow.support.web.WebConfigReader;

/**
 * 不要被domain service 引用 会产生循环依赖
 */
public interface DomainRegistry {
    RegisteringUserRepository getRegisteringUserRepository();

    VisitorRepository getVisitorRepository();

    UserProfileRepository getUserProfileRepository();

    RegisteringUserService getRegisteringUserService();

    SecurityPrincipalService getSecurityPrincipalService();

    UserLimitService getUserLimitService();

    SecurityPrincipalRepository getSecurityPrincipalRepository();

    EncryptionService getEncryptionService();

    AuthenticatorConfigReader getAuthenticatorConfigReader();

    EmailSender getEmailSender();

    WebConfigReader getWebConfigReader();

}
