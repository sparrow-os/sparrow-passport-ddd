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

package com.sparrow.passport.infrastructure.persistence.data.converter;

import com.sparrow.passport.domain.entity.SecurityPrincipalEntity;
import com.sparrow.passport.po.SecurityPrincipal;
import com.sparrow.passport.po.User;
import com.sparrow.support.IpSupport;

import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
public class SecurityPrincipalConverter {

    @Inject
    private IpSupport ipSupport;

    public SecurityPrincipal entity2Po(SecurityPrincipalEntity securityPrincipalEntity) {
        SecurityPrincipal securityPrincipal = new SecurityPrincipal();
        securityPrincipal.setUserId(securityPrincipalEntity.getUserId());
        securityPrincipal.setPassword(securityPrincipalEntity.getPassword());
        return securityPrincipal;
    }


    public SecurityPrincipalEntity user2SecurityPrincipal(User user) {
        if (user == null) {
            return null;
        }
        SecurityPrincipalEntity securityPrincipal = new SecurityPrincipalEntity();
        securityPrincipal.setActivate(user.getActivate());
        securityPrincipal.setTenantId(user.getTenantId());
        securityPrincipal.setEmail(user.getEmail());
        securityPrincipal.setMobile(user.getMobile());
        securityPrincipal.setUserName(user.getUserName());
        securityPrincipal.setLastLoginTime(user.getLastLoginTime());
        securityPrincipal.setUserId(user.getUserId());
        securityPrincipal.setCategory(user.getCategory());
        securityPrincipal.setPassword(user.getPassword());
        securityPrincipal.setStatus(user.getStatus().ordinal());
        return securityPrincipal;
    }
}
