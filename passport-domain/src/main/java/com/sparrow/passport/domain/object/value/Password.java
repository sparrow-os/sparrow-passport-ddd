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

package com.sparrow.passport.domain.object.value;

import com.sparrow.constant.Regex;
import com.sparrow.passport.protocol.enums.PassportError;
import com.sparrow.protocol.BusinessException;
import com.sparrow.protocol.ddd.ValueObject;
import com.sparrow.utility.RegexUtility;
import com.sparrow.utility.StringUtility;

public class Password implements ValueObject<Password> {
    public Password(String originPassword) {
        this.originPassword = originPassword;
    }

    private String originPassword;

    public void isValid() throws BusinessException {
        //新密码为空或格式不正确
        if (StringUtility.isNullOrEmpty(originPassword) || !RegexUtility
            .matches(originPassword, Regex.PASSWORD)) {
            throw new BusinessException(PassportError.USER_PASSWORD_FORMAT_ERROR);
        }
    }

    @Override public boolean sameValueAs(Password password) {
        return this.originPassword.equals(password.originPassword);
    }
}
