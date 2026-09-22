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

import com.sparrow.passport.api.UserSecurityService;
import com.sparrow.passport.domain.DomainRegistry;
import com.sparrow.passport.protocol.param.password.PasswordModifyParam;
import com.sparrow.passport.protocol.param.password.PasswordResetParam;
import com.sparrow.passport.protocol.param.password.ResetPasswordByMobileParam;
import com.sparrow.protocol.BusinessException;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
public class UserSecurityApplicationService implements UserSecurityService {

    @Inject
    private DomainRegistry domainRegistry;

    @Override public void sendFindPasswordToken(String email) throws BusinessException {
        this.domainRegistry.getSecurityPrincipalService().sendFindPasswordToken(email, domainRegistry);
    }

    @Override public Boolean resetPasswordByMobile(ResetPasswordByMobileParam password) throws BusinessException {
        return null;
    }

    @Override public void tokenVerify(String token) throws BusinessException {
        this.domainRegistry.getSecurityPrincipalService().tokenVerify(token, domainRegistry);
    }

    @Override public void resetPasswordByEmailToken(PasswordResetParam param) throws BusinessException {
        this.domainRegistry.getSecurityPrincipalService().resetPasswordByEmailToken(param.getToken(), param.getPassword(), domainRegistry);
    }

    @Override public Boolean modifyPassword(PasswordModifyParam password) {
        return null;
    }
}
