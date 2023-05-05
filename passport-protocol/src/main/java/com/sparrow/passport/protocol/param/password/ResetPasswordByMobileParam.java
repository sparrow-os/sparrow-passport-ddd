package com.sparrow.passport.protocol.param.password;

import com.sparrow.protocol.Param;

public class ResetPasswordByMobileParam implements Param {
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
