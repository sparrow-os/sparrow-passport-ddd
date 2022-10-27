package com.sparrow.passport.protocol.param.password;

import java.io.Serializable;

public class ResetPasswordByMobileParam implements Serializable {
    private String validateCode;
    private String password;

    public String getValidateCode() {
        return validateCode;
    }

    public void setValidateCode(String validateCode) {
        this.validateCode = validateCode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
