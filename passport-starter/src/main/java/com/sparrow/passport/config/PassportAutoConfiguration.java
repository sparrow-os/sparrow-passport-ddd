package com.sparrow.passport.config;

import io.swagger.v3.oas.models.OpenAPI;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Passport starter 的自动配置入口。
 *
 * <p>由 {@link EnablePassport} 通过 {@code @Import} 显式启用，而不是走
 * {@code META-INF/spring/*.AutoConfiguration.imports} 的隐式装配，从而保证只有宿主项目
 * 显式声明 {@code @EnablePassport} 时才会生效，做到 starter 与宿主项目的隔离。
 */
@Configuration
@ComponentScan("com.sparrow.passport")
@ConditionalOnClass(OpenAPI.class)
@EnableConfigurationProperties(PassportOpenApiProperties.class)
public class PassportAutoConfiguration {

    /**
     * 注册一个分组，用于在 Swagger UI 右上角下拉中按应用隔离接口文档。
     *
     * <ul>
     *   <li>{@link ConditionalOnMissingBean}（按 bean 名）：仅当宿主没有同名 {@code passportGroup}
     *       时才注册，避免覆盖宿主自定义，同时允许宿主再注册其它分组共存。</li>
     *   <li>{@link ConditionalOnProperty}：与 {@code sparrow.passport.openapi.enabled} 联动，
     *       关闭时一并移除分组。</li>
     * </ul>
     */
    @Bean
    @ConditionalOnMissingBean(name = "passportGroup")
    public GroupedOpenApi passportGroup(PassportOpenApiProperties properties) {
        return GroupedOpenApi.builder()
                .group(properties.getGroup())
                .packagesToScan(properties.getPackagesToScan())
                .build();
    }
}
