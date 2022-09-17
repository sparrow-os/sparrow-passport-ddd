package com.sparrow.passport.controller.protocol.query;

import com.sparrow.protocol.VO;

/**
 * login query dto
 *
 * @author harry
 */
public class LoginQuery implements VO {
    /**
     * 用户名
     */
    private String userName;
    /**
     * 密码
     */
    private String password;

    private Boolean remember;

    private String validateCode;

    public Boolean getRemember() {
        return remember;
    }

    public void setRemember(Boolean remember) {
        this.remember = remember;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getValidateCode() {
        return validateCode;
    }

    public void setValidateCode(String validateCode) {
        this.validateCode = validateCode;
    }
}
