package com.sparrow.passport.protocol.param.register;

public abstract class UserNameRegisterParam extends RegisterParam {

    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
