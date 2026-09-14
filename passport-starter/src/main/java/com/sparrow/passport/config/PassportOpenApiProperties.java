package com.sparrow.passport.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Passport starter 的 OpenAPI 元信息配置。
 *
 * <p>统一使用 {@code sparrow.passport.openapi.*} 前缀，避免与 springdoc 官方
 * {@code springdoc.*} 以及宿主应用的配置命名空间冲突，从而实现 starter 与宿主项目的隔离。
 */
@ConfigurationProperties(prefix = "sparrow.passport.openapi")
public class PassportOpenApiProperties {

    /**
     * 是否注册本 starter 提供的 OpenAPI 元信息 Bean。
     * 关闭后，若宿主未自定义，springdoc 会回退到默认的空 Info。
     */
    private boolean enabled = true;

    private String title = "Sparrow Passport";

    private String description = "Sparrow Passport";

    private String version = "1.0";

    /**
     * Swagger UI 分组名称，用于右上角下拉中隔离不同应用的接口文档。
     */
    private String group = "passport";

    /**
     * 该分组要扫描的包，默认只扫描本 starter 的包，实现接口文档隔离。
     */
    private String packagesToScan = "com.sparrow.passport";

    private String termsOfService;

    private final Contact contact = new Contact();

    private final License license = new License();

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getPackagesToScan() {
        return packagesToScan;
    }

    public void setPackagesToScan(String packagesToScan) {
        this.packagesToScan = packagesToScan;
    }

    public String getTermsOfService() {
        return termsOfService;
    }

    public void setTermsOfService(String termsOfService) {
        this.termsOfService = termsOfService;
    }

    public Contact getContact() {
        return contact;
    }

    public License getLicense() {
        return license;
    }

    public static class Contact {

        private String name = "harry";

        private String url = "http://www.sparrowzoo.com";

        private String email = "zh_harry@163.com";

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }

    public static class License {

        private String name;

        private String url;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
