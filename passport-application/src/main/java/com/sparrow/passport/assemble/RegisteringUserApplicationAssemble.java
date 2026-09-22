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

package com.sparrow.passport.assemble;

import com.sparrow.passport.domain.entity.RegisteringUserEntity;
import com.sparrow.passport.protocol.param.register.EmailRegisterParam;
import jakarta.inject.Named;

@Named
public class RegisteringUserApplicationAssemble {
    public RegisteringUserEntity emailParam2Entity(EmailRegisterParam registerParam) {
        RegisteringUserEntity registeringUser = new RegisteringUserEntity();
        registeringUser.setEmail(registerParam.getEmail());
        registeringUser.setPassword(registerParam.getPassword());
        registeringUser.setPasswordConfirm(registerParam.getPasswordConfirm());
        registeringUser.setUserName(registerParam.getUserName());
        registeringUser.setNationality(registeringUser.getNationality());
        return registeringUser;
    }
}
