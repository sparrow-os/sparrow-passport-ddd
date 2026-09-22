/*
Licensed to the Apache Software Foundation (ASF) under one or more
contributor license agreements.  See the NOTICE file distributed with
this work for additional information regarding copyright ownership.
The ASF licenses this file to You under the Apache License, Version 2.0
(the "License"); you may not use this file except in compliance with
the License.  You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/

package com.sparrow.passport.domain.entity;

import com.sparrow.exception.Asserts;
import com.sparrow.passport.domain.object.value.Login;
import com.sparrow.passport.domain.object.value.ModifyPassword;
import com.sparrow.passport.protocol.enums.PassportError;
import com.sparrow.protocol.BusinessException;
import com.sparrow.protocol.ddd.Entity;
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
            throw new BusinessException(PassportError.USER_NOT_ACTIVATE);
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
        Asserts.isTrue(!this.loginParam.getEncryptPassword().equals(this.password), PassportError.USER_PASSWORD_ERROR);
        this.setCurrent2LastLoginTime();
    }

    public void resetPassword(String encryptLoginPassword) {
        this.password = encryptLoginPassword;
    }

    public void setCurrent2LastLoginTime() {
        this.lastLoginTime = System.currentTimeMillis();
    }

    @Override
    public boolean sameIdentityAs(SecurityPrincipalEntity entity) {
        return this.userId.equals(entity.userId);
    }

    @Override
    public Long identity() {
        return this.userId;
    }
}
