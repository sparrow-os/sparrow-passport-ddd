/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.sparrow.passport.authenticate;

import com.sparrow.core.spi.JsonFactory;
import com.sparrow.json.Json;
import com.sparrow.passport.domain.DomainRegistry;
import com.sparrow.passport.domain.entity.SecurityPrincipalEntity;
import com.sparrow.protocol.LoginUserStatus;
import com.sparrow.support.DefaultAuthenticatorService;
public class AuthenticatorService extends DefaultAuthenticatorService {

    private Json json = JsonFactory.getProvider();
    private DomainRegistry domainRegistry;

    public AuthenticatorService(String encryptKey, Boolean validateDeviceId, Boolean validateStatus,DomainRegistry domainRegistry) {
        super(encryptKey, validateDeviceId, validateStatus);
        this.domainRegistry = domainRegistry;
    }


    @Override
    protected void setUserStatus(Long userId, LoginUserStatus loginUserStatus) {
//
    }

    @Override
    protected LoginUserStatus getUserStatus(Long userId) {
        //todo 从缓存中获取
        return this.getUserStatusFromDB(userId);
    }

    @Override
    protected LoginUserStatus getUserStatusFromDB(Long userId) {
        SecurityPrincipalEntity securityPrincipal = this.domainRegistry.getSecurityPrincipalRepository().findByUserId(userId);
        return new LoginUserStatus(securityPrincipal.getStatus(), 0L);
    }
}
