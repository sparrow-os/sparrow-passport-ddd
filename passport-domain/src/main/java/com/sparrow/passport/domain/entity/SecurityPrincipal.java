package com.sparrow.passport.domain.entity;

import com.sparrow.constant.SparrowError;
import com.sparrow.exception.Asserts;
import com.sparrow.protocol.BusinessException;
import com.sparrow.protocol.ddd.Entity;
import com.sparrow.passport.domain.object.value.Login;
import com.sparrow.passport.domain.object.value.ModifyPassword;
import com.sparrow.passport.support.suffix.UserFieldSuffix;

public class SecurityPrincipal implements Entity<SecurityPrincipal, Long> {
    private Long userId;
    private String userName;
    private String password;
    private String email;
    private String mobile;
    private Boolean activate;
    private Long cent;
    private Long plusCent = 0L;
    private Long lastLoginTime;
    private Integer status;
    private Login loginInfo;
    private ModifyPassword modifyPasswordInfo;

    public void activateEmail() throws BusinessException {
        if (!this.activate) {
            throw new BusinessException(SparrowError.USER_NOT_ACTIVATE, UserFieldSuffix.LOGIN);
        }
    }

    public void setLastLoginTime(Long lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public void setModifyPasswordInfo(ModifyPassword modifyPasswordInfo) {
        this.modifyPasswordInfo = modifyPasswordInfo;
    }

    public void modifyPassword() throws BusinessException {
        this.modifyPasswordInfo.getNewOriginPassword().isValid();
        Asserts.isTrue(!this.modifyPasswordInfo.getOldEncryptionPassword().equals(this.password), SparrowError.USER_PASSWORD_ERROR);
        this.password = this.modifyPasswordInfo.getNewEncryptionPassword();
    }

    public void login() throws BusinessException {
        this.loginInfo.getPassword().isValid();
        Asserts.isTrue(!this.loginInfo.getEncryptPassword().equals(this.password), SparrowError.USER_PASSWORD_ERROR, UserFieldSuffix.LOGIN_PASSWORD);
        this.setCurrent2LastLoginTime();
        this.setCent((long) this.loginInfo.getCent());
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

    public Long getCent() {
        return cent;
    }

    public void setCent(Long cent) {
        this.cent = cent;
    }

    public Long getLastLoginTime() {
        return lastLoginTime;
    }

    public void setCurrent2LastLoginTime() {
        this.lastLoginTime = System.currentTimeMillis();
    }

    public Login getLoginInfo() {
        return loginInfo;
    }

    public void setLoginInfo(Login loginInfo) {
        this.loginInfo = loginInfo;
    }

    public Long getPlusCent() {
        return plusCent;
    }

    public void setPlusCent(Long plusCent) {
        this.plusCent = plusCent;
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

    @Override public boolean sameIdentityAs(SecurityPrincipal entity) {
        return this.userId.equals(entity.getUserId());
    }

    @Override public Long identity() {
        return this.userId;
    }
}
