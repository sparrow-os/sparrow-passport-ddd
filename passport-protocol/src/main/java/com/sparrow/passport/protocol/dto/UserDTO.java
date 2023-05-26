package com.sparrow.passport.protocol.dto;

import java.util.HashMap;
import java.util.Map;

/**
 * 用户DTO
 *
 * @auth harry
 */
public class UserDTO extends UserProfileDTO {
    private String roleNames;
    private String groupLevel;
    private String secretMobile;

    /**
     * 用户的扩展信息
     */
    private Map<String, Object> extend = new HashMap<String, Object>();

    public Map<String, Object> getExtend() {
        return extend;
    }

    public void setExtend(Map<String, Object> extend) {
        this.extend = extend;
    }

    public String getRoleNames() {
        return roleNames;
    }

    public void setRoleNames(String roleNames) {
        this.roleNames = roleNames;
    }

    public String getGroupLevel() {
        return groupLevel;
    }

    public void setGroupLevel(String groupLevel) {
        this.groupLevel = groupLevel;
    }

    public String getSecretMobile() {
        return secretMobile;
    }

    public void setSecretMobile(String secretMobile) {
        this.secretMobile = secretMobile;
    }
}
