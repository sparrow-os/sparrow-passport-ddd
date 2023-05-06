package com.sparrow.passport.protocol.query.login;

import com.sparrow.protocol.Query;

public class LoginQuery implements Query {
    /**
     * 用户名
     */
    private String userName;
    /**
     * 密码
     */
    private String password;

    private Boolean remember;

    private String captcha;

    private String redirectUrl;

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

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    @Override public String toString() {
        return "LoginQuery{" +
            "userName='" + userName + '\'' +
            ", password='" + password + '\'' +
            ", remember=" + remember +
            ", captcha='" + captcha + '\'' +
            ", redirectUrl='" + redirectUrl + '\'' +
            '}';
    }
}
