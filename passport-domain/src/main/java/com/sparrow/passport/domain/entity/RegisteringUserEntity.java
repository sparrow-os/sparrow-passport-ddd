package com.sparrow.passport.domain.entity;

import com.sparrow.constant.Regex;
import com.sparrow.constant.SparrowError;
import com.sparrow.exception.Asserts;
import com.sparrow.protocol.BusinessException;
import com.sparrow.passport.domain.DomainRegistry;
import com.sparrow.passport.support.suffix.UserFieldSuffix;
import com.sparrow.utility.RegexUtility;
import com.sparrow.utility.StringUtility;

public class RegisteringUserEntity {
    private String userName;
    private String email;
    private String mobile;
    private String password;
    private String passwordConfirm;
    private Long userId;
    private Long cent;

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public String getMobile() {
        return mobile;
    }

    public String getPassword() {
        return password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPasswordConfirm(String passwordConfirm)  {
        this.passwordConfirm = passwordConfirm;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCent() {
        return cent;
    }

    public void setCent(Long cent) {
        this.cent = cent;
    }

    public void register(DomainRegistry domainRegistry) throws BusinessException {
        Asserts.isTrue(StringUtility.isNullOrEmpty(userName), SparrowError.GLOBAL_PARAMETER_NULL, UserFieldSuffix.REGISTER_USER_NAME);
        Asserts.isTrue(!RegexUtility.matches(password, Regex.PASSWORD), SparrowError.USER_PASSWORD_FORMAT_ERROR, UserFieldSuffix.REGISTER_PASSWORD);
        Asserts.isTrue(!RegexUtility.matches(passwordConfirm, Regex.PASSWORD), SparrowError.USER_PASSWORD_FORMAT_ERROR, UserFieldSuffix.REGISTER_CONFIRM_PASSWORD);
        Asserts.isTrue(!passwordConfirm.equals(password), SparrowError.USER_PASSWORD_ERROR, UserFieldSuffix.REGISTER_CONFIRM_PASSWORD);
        Asserts.isTrue(StringUtility.isNullOrEmpty(email)&&StringUtility.isNullOrEmpty(mobile), SparrowError.SYSTEM_ILLEGAL_REQUEST);
        this.setPassword(domainRegistry.getEncryptionService().encryptPassword(this.getPassword()));
    }
}
