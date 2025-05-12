package com.sparrow.passport.domain.entity;

import com.sparrow.exception.Asserts;
import com.sparrow.passport.protocol.enums.PassportError;
import com.sparrow.protocol.BusinessException;
import com.sparrow.protocol.ddd.Entity;
import com.sparrow.passport.domain.object.value.Login;
import com.sparrow.passport.domain.object.value.ModifyPassword;
import com.sparrow.passport.support.suffix.UserFieldSuffix;
import lombok.Data;

@Data
public class SecurityPrincipalEntity implements Entity<SecurityPrincipalEntity, Long> {
    private Long userId;
    private Long tenantId;
    private Integer category;
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


    public void modifyPassword() throws BusinessException {
        this.modifyPasswordParam.getNewOriginPassword().isValid();
        Asserts.isTrue(!this.modifyPasswordParam.getOldEncryptionPassword().equals(this.password), PassportError.USER_PASSWORD_ERROR);
        this.password = this.modifyPasswordParam.getNewEncryptionPassword();
    }

    public void login() throws BusinessException {
        //登录暂不验证密码格式，为兼容老用户登录
        //this.loginParam.getPassword().isValid();
        Asserts.isTrue(!this.loginParam.getEncryptPassword().equals(this.password), PassportError.USER_PASSWORD_ERROR, UserFieldSuffix.LOGIN_PASSWORD);
        this.setCurrent2LastLoginTime();
    }

    public void resetPassword(String encryptLoginPassword) {
        this.password = encryptLoginPassword;
    }

    public void setCurrent2LastLoginTime() {
        this.lastLoginTime = System.currentTimeMillis();
    }

    @Override public boolean sameIdentityAs(SecurityPrincipalEntity entity) {
        return this.userId.equals(entity.userId);
    }

    @Override public Long identity() {
        return this.userId;
    }
}
