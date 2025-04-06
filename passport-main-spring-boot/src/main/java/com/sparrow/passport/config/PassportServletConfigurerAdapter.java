package com.sparrow.passport.config;

import com.sparrow.passport.authenticate.AuthenticatorService;
import com.sparrow.passport.domain.DomainRegistry;
import com.sparrow.spring.starter.config.SparrowConfig;
import com.sparrow.support.Authenticator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class PassportServletConfigurerAdapter implements WebMvcConfigurer {
    private static Logger logger = LoggerFactory.getLogger(WebMvcConfigurer.class);

    @Autowired
    private SparrowConfig sparrowConfig;

    @Autowired
    private DomainRegistry domainRegistry;

    @Bean
    Authenticator authenticator() {
        SparrowConfig.Authenticator authenticatorConfig = sparrowConfig.getAuthenticator();
        return new AuthenticatorService(authenticatorConfig.getEncryptKey(),
                authenticatorConfig.getValidateDeviceId(),
                authenticatorConfig.getValidateStatus(),
                domainRegistry);
    }
}
