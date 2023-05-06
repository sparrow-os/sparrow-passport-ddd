package com.sparrow.passport.protocol.param.register;

import com.sparrow.protocol.ClientInformation;
import com.sparrow.protocol.Param;

public abstract class RegisterParam implements Param {
    public RegisterParam() {
    }

    protected String password;

    protected String passwordConfirm;

    protected String captcha;

    protected String introducer;

    public String getPassword() {
        return password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
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

    public void setIntroducer(String introducer) {
        this.introducer = introducer;
    }

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }
}
