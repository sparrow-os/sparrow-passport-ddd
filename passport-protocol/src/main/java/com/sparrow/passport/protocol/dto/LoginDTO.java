package com.sparrow.passport.protocol.dto;

import com.sparrow.protocol.DTO;
import com.sparrow.protocol.LoginUser;
import lombok.Data;

@Data
public class LoginDTO implements DTO {
    public LoginDTO(LoginUser loginUser, String token) {
        this.loginUser = loginUser;
        this.token = token;
    }
    private LoginUser loginUser;
    private String token;
}
