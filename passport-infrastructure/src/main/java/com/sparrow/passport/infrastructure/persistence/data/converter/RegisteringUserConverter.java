package com.sparrow.passport.infrastructure.persistence.data.converter;

import com.sparrow.enums.Gender;
import com.sparrow.passport.domain.entity.RegisteringUserEntity;
import com.sparrow.passport.po.User;
import com.sparrow.protocol.ClientInformation;
import com.sparrow.protocol.constant.magic.Symbol;
import com.sparrow.protocol.enums.StatusRecord;
import com.sparrow.support.IpSupport;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class RegisteringUserConverter
{
    @Inject
    private IpSupport ipSupport;

    public RegisteringUserEntity user2RegisteringUser(User user) {
        if (user == null) {
            return null;
        }
        RegisteringUserEntity registeringUser = new RegisteringUserEntity();
        registeringUser.setEmail(user.getEmail());
        registeringUser.setMobile(user.getMobile());
        registeringUser.setUserName(user.getUserName());
        registeringUser.setUserId(user.getUserId());
        registeringUser.setPassword(user.getPassword());
        return registeringUser;
    }

    public User registeringUser2User(RegisteringUserEntity registeringUser, ClientInformation client) {
        if (registeringUser == null) {
            return null;
        }
        User user = new User();
        user.setUserId(registeringUser.getUserId());
        user.setUserName(registeringUser.getUserName());
        user.setEmail(registeringUser.getEmail());
        user.setPassword(registeringUser.getPassword());
        user.setDevice(client.getDevice());
        user.setChannel(client.getChannel());
        user.setDeviceModel(client.getDeviceModel());
        user.setGmtCreate(System.currentTimeMillis());
        user.setGmtModified(user.getGmtCreate());
        user.setLastLoginTime(System.currentTimeMillis());
        user.setActivate(registeringUser.getActivate());
        if (user.getActivate()) {
            user.setActivateTime(System.currentTimeMillis());
        } else {
            user.setActivateTime(0L);
        }
        user.setAvatar(Symbol.EMPTY);
        user.setGender(Gender.NULL.ordinal());
        user.setBirthday(null);
        user.setNickName(user.getUserName());
        user.setPersonalSignature(Symbol.EMPTY);
        user.setIp(this.ipSupport.toLong(client.getIp()));
        user.setStatus(StatusRecord.ENABLE);
        user.setMobile(registeringUser.getMobile());
        if (user.getMobile() == null) {
            user.setMobile(Symbol.EMPTY);
        }
        return user;
    }
}
