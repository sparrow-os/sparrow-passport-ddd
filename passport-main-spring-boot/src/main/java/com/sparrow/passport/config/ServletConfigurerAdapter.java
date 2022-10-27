package com.sparrow.passport.config;

import com.sparrow.passport.ValidateCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ServletConfigurerAdapter implements WebMvcConfigurer {
    private static Logger logger = LoggerFactory.getLogger(WebMvcConfigurer.class);
    @Bean
    public ServletRegistrationBean validateCode() {
        return new ServletRegistrationBean(new ValidateCode(), "/validate-code");
    }
}
