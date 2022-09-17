package com.sparrow.passport.protocol.param.register;

import com.sparrow.protocol.ClientInformation;

public abstract class RegisterParam {
    public RegisterParam() {
    }

    /**
     * 密码
     */
    protected String password;
    /**
     * 密码确认
     */
    protected String passwordConfirm;
    /**
     * 验证码
     */
    protected String validateCode;

    /**
     * 介绍人
     */
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
