package com.sparrow.passport.protocol.param.register;

public class MobileRegisterParam extends UserNameRegisterParam {

    private String mobile;

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getMobile() {
        return mobile;
    }

    @Override public String toString() {
        return "MobileRegisterDTO{" +
            "mobile='" + mobile + '\'' +
            "} " + super.toString();
    }
}
