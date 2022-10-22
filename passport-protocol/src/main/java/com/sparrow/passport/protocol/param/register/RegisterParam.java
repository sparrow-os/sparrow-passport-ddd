package com.sparrow.passport.protocol.param.register;

import com.sparrow.protocol.ClientInformation;
import com.sparrow.protocol.POJO;

public abstract class RegisterParam implements POJO {
    public RegisterParam() {
    }


    protected String password;

    protected String passwordConfirm;

    protected String validateCode;

    protected String introducer;

    private ClientInformation client;

    public ClientInformation getClient() {
        return client;
    }

    public String getPassword() {
        return password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public String getValidateCode() {
        return validateCode;
    }

    public String getIntroducer() {
        return introducer;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public void setValidateCode(String validateCode) {
        this.validateCode = validateCode;
    }

    public void setIntroducer(String introducer) {
        this.introducer = introducer;
    }

    public void setClient(ClientInformation client) {
        this.client = client;
    }
}
