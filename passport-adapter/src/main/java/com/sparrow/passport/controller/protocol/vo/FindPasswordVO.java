package com.sparrow.passport.controller.protocol.vo;

public class FindPasswordVO {

    public FindPasswordVO(String email, String officialEmailAddress) {
        this.email = email;
        this.officialEmailAddress = officialEmailAddress;
    }

    private String email;
    private String officialEmailAddress;

    public String getEmail() {
        return email;
    }

    public String getOfficialEmailAddress() {
        return officialEmailAddress;
    }
}
