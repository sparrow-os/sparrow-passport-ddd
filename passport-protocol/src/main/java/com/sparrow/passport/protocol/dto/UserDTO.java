package com.sparrow.passport.protocol.dto;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * 用户DTO
 *
 * @auth harry
 */
@Data
public class UserDTO extends UserProfileDTO {
    private String roleNames;
    private String groupLevel;
    private String secretMobile;

    /**
     * 用户的扩展信息
     */
    private Map<String, Object> extend = new HashMap<String, Object>();
}
