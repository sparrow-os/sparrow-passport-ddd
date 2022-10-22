package com.sparrow.passport.protocol.param.register;

import com.sparrow.protocol.ClientInformation;

public class EmailActivateParam {
    private String email;
    private Long userId;
    private ClientInformation client;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public ClientInformation getClient() {
        return client;
    }

    public void setClient(ClientInformation client) {
        this.client = client;
    }
}
