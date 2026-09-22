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

package com.sparrow.passport.services;

import com.sparrow.passport.api.UserRegisterService;
import com.sparrow.passport.assemble.RegisteringUserApplicationAssemble;
import com.sparrow.passport.domain.DomainRegistry;
import com.sparrow.passport.domain.entity.RegisteringUserEntity;
import com.sparrow.passport.protocol.dto.LoginDTO;
import com.sparrow.passport.protocol.param.register.EmailActivateParam;
import com.sparrow.passport.protocol.param.register.EmailRegisterParam;
import com.sparrow.passport.protocol.param.register.MobileRegisterParam;
import com.sparrow.passport.protocol.param.register.UserNameRegisterParam;
import com.sparrow.protocol.BusinessException;
import com.sparrow.protocol.ClientInformation;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
public class RegisteringUserApplicationService implements UserRegisterService {

    @Inject
    private RegisteringUserApplicationAssemble registeringUserApplicationAssemble;

    @Inject
    private DomainRegistry domainRegistry;

    @Override public LoginDTO register(UserNameRegisterParam registerParam) throws BusinessException {
        return null;
    }

    @Override public LoginDTO register(MobileRegisterParam registerParam) throws BusinessException {
        return null;
    }

    @Override public LoginDTO register(EmailRegisterParam registerParam,ClientInformation client) throws BusinessException {
        RegisteringUserEntity registeringUser = this.registeringUserApplicationAssemble.emailParam2Entity(registerParam);
        return this.domainRegistry.getRegisteringUserService().registerByEmail(registeringUser,client, domainRegistry);
    }

    @Override public void sendTokenToEmail(EmailActivateParam emailActivateParam) throws BusinessException {
        RegisteringUserEntity registeringUserEntity = this.domainRegistry.getRegisteringUserRepository()
            .findByEmail(emailActivateParam.getEmail());
        this.domainRegistry.getRegisteringUserService().sendActivateEmail(registeringUserEntity, this.domainRegistry);
    }

    @Override public void activeEmail(String token, ClientInformation client) throws BusinessException {
        this.domainRegistry.getRegisteringUserService().activeEmail(token, client, this.domainRegistry);
    }
}
