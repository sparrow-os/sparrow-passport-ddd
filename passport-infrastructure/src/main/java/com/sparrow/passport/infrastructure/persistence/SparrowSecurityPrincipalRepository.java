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

package com.sparrow.passport.infrastructure.persistence;

import com.sparrow.passport.dao.UserDAO;
import com.sparrow.passport.domain.entity.SecurityPrincipalEntity;
import com.sparrow.passport.infrastructure.persistence.data.converter.SecurityPrincipalConverter;
import com.sparrow.passport.po.SecurityPrincipal;
import com.sparrow.passport.po.User;
import com.sparrow.passport.repository.SecurityPrincipalRepository;
import com.sparrow.protocol.dao.UniqueKeyCriteria;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named("securityPrincipalRepository")
public class SparrowSecurityPrincipalRepository implements SecurityPrincipalRepository {
    @Inject
    private UserDAO userDao;
    @Inject
    private SecurityPrincipalConverter securityPrincipalConverter;

    @Override public SecurityPrincipalEntity findByUserId(Long userId) {
        User user = this.userDao.getEntity(userId);
        return this.securityPrincipalConverter.user2SecurityPrincipal(user);
    }

    @Override public SecurityPrincipalEntity findByEmail(String email) {
        UniqueKeyCriteria uniqueKeyCriteria = UniqueKeyCriteria.createUniqueCriteria(email, "email");
        User user = this.userDao.getEntityByUnique(uniqueKeyCriteria);
        return this.securityPrincipalConverter.user2SecurityPrincipal(user);
    }

    @Override public SecurityPrincipalEntity findByName(String userName) {
        UniqueKeyCriteria uniqueKeyCriteria = UniqueKeyCriteria.createUniqueCriteria(userName, "userName");
        User user = this.userDao.getEntityByUnique(uniqueKeyCriteria);
        return this.securityPrincipalConverter.user2SecurityPrincipal(user);
    }

    @Override public SecurityPrincipalEntity findByMobile(String mobile, String secretMobile) {
//        SearchCriteria searchCriteria = new SearchCriteria();
//        searchCriteria.setWhere(BooleanCriteria.criteria(Criteria.field("mobile").equal(mobile))
//            .and(Criteria.field("user.secretMobile").equal(secretMobile)));
        //return this.userMapper.user2SecurityPrincipal(this.userDao.getEntity(searchCriteria));
        return null;
    }

    @Override public void saveSecurity(SecurityPrincipalEntity securityPrincipalEntity) {
        SecurityPrincipal securityPrincipal = this.securityPrincipalConverter.entity2Po(securityPrincipalEntity);
        this.userDao.save(securityPrincipal);
    }
}
