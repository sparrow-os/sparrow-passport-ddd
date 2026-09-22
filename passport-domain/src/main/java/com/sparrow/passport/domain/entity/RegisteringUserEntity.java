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

import com.sparrow.constant.Regex;
import com.sparrow.exception.Asserts;
import com.sparrow.passport.domain.DomainRegistry;
import com.sparrow.passport.protocol.enums.PassportError;
import com.sparrow.protocol.BusinessException;
import com.sparrow.protocol.constant.SparrowError;
import com.sparrow.utility.RegexUtility;
import com.sparrow.utility.StringUtility;
import lombok.Data;

@Data
public class RegisteringUserEntity {
    private String userName;
    private String email;
    private String mobile;
    private String password;
    private String passwordConfirm;
    private Long userId;
    private Boolean activate = false;

    private String nationality;


    public void register(DomainRegistry domainRegistry) throws BusinessException {
        Asserts.isTrue(StringUtility.isNullOrEmpty(userName), SparrowError.GLOBAL_PARAMETER_NULL);
        Asserts.isTrue(!RegexUtility.matches(password, Regex.PASSWORD), PassportError.USER_PASSWORD_FORMAT_ERROR);
        Asserts.isTrue(!RegexUtility.matches(passwordConfirm, Regex.PASSWORD), PassportError.USER_PASSWORD_FORMAT_ERROR);
        Asserts.isTrue(!passwordConfirm.equals(password), PassportError.USER_PASSWORD_ERROR);
        Asserts.isTrue(StringUtility.isNullOrEmpty(email) && StringUtility.isNullOrEmpty(mobile), SparrowError.SYSTEM_ILLEGAL_REQUEST);
        this.setPassword(domainRegistry.getEncryptionService().encryptPassword(this.getPassword()));
    }

    public void active() {
        this.activate = true;
    }
}
