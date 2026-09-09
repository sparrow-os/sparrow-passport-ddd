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
