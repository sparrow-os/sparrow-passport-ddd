package com.sparrow.passport.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.sparrow.passport")
public class PassportAutoConfiguration {
    @Bean
    @ConditionalOnMissingBean(OpenAPI.class)
    public OpenAPI passportOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Sparrow Community")
                        .description("Sparrow Community")
                        .contact(new Contact()
                                .name("harry")
                                .url("http://www.sparrowzoo.com")
                                .email("zh_harry@163.com"))
                        .version("1.0"));
    }
}
