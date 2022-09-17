package com.sparrow.passport.protocol.query.login;

import com.sparrow.protocol.ClientInformation;

public class LoginQueryDTO {
    /**
     * 用户名
     */
    private String userName;
    /**
     * 密码
     */
    private String password;

    private Boolean remember;

    private ClientInformation client;

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

    public ClientInformation getClient() {
        return client;
    }

    public void setClient(ClientInformation client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "LoginQueryDTO{" +
            "userName='" + userName + '\'' +
            ", password='" + password + '\'' +
            ", client=" + client +
            '}';
    }
}
