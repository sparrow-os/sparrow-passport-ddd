package com.sparrow.passport.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@ComponentScan("com.sparrow.passport")
public class PassportAutoConfiguration {
    @Bean
    @ConditionalOnMissingBean(ApiInfo.class)
    public ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Sparrow Community").description("Sparrow Community").termsOfServiceUrl("www.sparrowzoo.com").contact(new Contact("harry", "http://www.sparrowzoo.com", "zh_harry@163.com")).version("1.0").build();
    }
    @Bean
    public Docket passportDocket(ApiInfo apiInfo) {
        return new
                Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo).groupName("认证服务").select().apis(
                RequestHandlerSelectors.basePackage("com.sparrow.passport.controller")
        ).paths(PathSelectors.any()).build();
    }
}
