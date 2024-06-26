package com.sparrow.passport.assemble;

import com.sparrow.passport.domain.entity.RegisteringUserEntity;
import com.sparrow.passport.protocol.param.register.EmailRegisterParam;

import javax.inject.Named;

@Named
public class RegisteringUserApplicationAssemble {
    public RegisteringUserEntity emailParam2Entity(EmailRegisterParam registerParam){
        RegisteringUserEntity registeringUser = new RegisteringUserEntity();
        registeringUser.setEmail(registerParam.getEmail());
        registeringUser.setPassword(registerParam.getPassword());
        registeringUser.setPasswordConfirm(registerParam.getPasswordConfirm());
        registeringUser.setUserName(registerParam.getUserName());
        registeringUser.setNationality(registeringUser.getNationality());
        return registeringUser;
    }
}
