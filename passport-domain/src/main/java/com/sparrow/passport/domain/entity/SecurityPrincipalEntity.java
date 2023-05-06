package com.sparrow.passport.domain.entity;

import com.sparrow.exception.Asserts;
import com.sparrow.passport.protocol.enums.PassportError;
import com.sparrow.protocol.BusinessException;
import com.sparrow.protocol.ddd.Entity;
import com.sparrow.passport.domain.object.value.Login;
import com.sparrow.passport.domain.object.value.ModifyPassword;
import com.sparrow.passport.support.suffix.UserFieldSuffix;

public class SecurityPrincipalEntity implements Entity<SecurityPrincipalEntity, Long> {
    private Long userId;
    private String userName;
    private String password;
    private String email;
    private String mobile;
    private Boolean activate;
    /**
     * 激活时间
     */
    private Long activateTime;
    private Long lastLoginTime;
    private Integer status;

    private String nickName;
    private String avatar;

    private Login loginParam;
    private ModifyPassword modifyPasswordParam;

    public void activateEmail() throws BusinessException {
        if (!this.activate) {
            throw new BusinessException(PassportError.USER_NOT_ACTIVATE, UserFieldSuffix.LOGIN);
        }
        this.activateTime = System.currentTimeMillis();
    }

    public void setLastLoginTime(Long lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public void setModifyPassword(ModifyPassword modifyPasswordParam) {
        this.modifyPasswordParam = modifyPasswordParam;
    }

    public void modifyPassword() throws BusinessException {
        this.modifyPasswordParam.getNewOriginPassword().isValid();
        Asserts.isTrue(!this.modifyPasswordParam.getOldEncryptionPassword().equals(this.password), PassportError.USER_PASSWORD_ERROR);
        this.password = this.modifyPasswordParam.getNewEncryptionPassword();
    }

    public void login() throws BusinessException {
        this.loginParam.getPassword().isValid();
        Asserts.isTrue(!this.loginParam.getEncryptPassword().equals(this.password), PassportError.USER_PASSWORD_ERROR, UserFieldSuffix.LOGIN_PASSWORD);
        this.setCurrent2LastLoginTime();
    }

    public void resetPassword(String encryptLoginPassword) {
        this.password = encryptLoginPassword;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Boolean getActivate() {
        return activate;
    }

    public void setActivate(Boolean activate) {
        this.activate = activate;
    }

    public Long getLastLoginTime() {
        return lastLoginTime;
    }

    public void setCurrent2LastLoginTime() {
        this.lastLoginTime = System.currentTimeMillis();
    }

    public Login getLoginParam() {
        return loginParam;
    }

    public void setLoginParam(Login loginParam) {
        this.loginParam = loginParam;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override public boolean sameIdentityAs(SecurityPrincipalEntity entity) {
        return this.userId.equals(entity.getUserId());
    }

    public Long getActivateTime() {
        return activateTime;
    }

    public void setActivateTime(Long activateTime) {
        this.activateTime = activateTime;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public ModifyPassword getModifyPasswordParam() {
        return modifyPasswordParam;
    }

    public void setModifyPasswordParam(ModifyPassword modifyPasswordParam) {
        this.modifyPasswordParam = modifyPasswordParam;
    }

    @Override public Long identity() {
        return this.userId;
    }
}
