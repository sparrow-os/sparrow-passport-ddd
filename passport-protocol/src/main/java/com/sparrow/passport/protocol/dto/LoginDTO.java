package com.sparrow.passport.protocol.dto;

import com.sparrow.protocol.DTO;
import com.sparrow.protocol.LoginUser;
import com.sparrow.protocol.VO;

public class LoginDTO implements VO, DTO {
    public LoginDTO(LoginUser loginUser, String permission) {
        this.loginUser = loginUser;
        this.permission = permission;
    }

    private LoginUser loginUser;
    private String permission;

    public LoginUser getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(LoginUser loginUser) {
        this.loginUser = loginUser;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }
}
