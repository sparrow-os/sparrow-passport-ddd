package com.sparrow.passport.protocol.param.register;

public class EmailRegisterParam extends UserNameRegisterParam {

    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "EmailRegisterDTO{" +
            "email='" + email + '\'' +
            '}';
    }
}
