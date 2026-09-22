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

import com.sparrow.passport.infrastructure.persistence.data.converter.RegisteringUserConverter;
import com.sparrow.protocol.ClientInformation;
import com.sparrow.protocol.dao.UniqueKeyCriteria;
import com.sparrow.passport.dao.UserDAO;
import com.sparrow.passport.domain.entity.RegisteringUserEntity;
import com.sparrow.passport.po.User;
import com.sparrow.passport.repository.RegisteringUserRepository;

import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named("registeringUserRepository")
public class SparrowRegisteringUserRepository implements RegisteringUserRepository {
    @Inject
    private UserDAO userDao;
    @Inject
    private RegisteringUserConverter registeringUserConverter;

    @Override
    public RegisteringUserEntity findByEmail(String email) {
        UniqueKeyCriteria uniqueKeyCriteria = UniqueKeyCriteria.createUniqueCriteria(email, "email");
        User user = this.userDao.getEntityByUnique(uniqueKeyCriteria);
        return this.registeringUserConverter.user2RegisteringUser(user);
    }

    @Override
    public RegisteringUserEntity findByUserName(String userName) {
        UniqueKeyCriteria uniqueKeyCriteria = UniqueKeyCriteria.createUniqueCriteria(userName, "userName");
        User user = this.userDao.getEntityByUnique(uniqueKeyCriteria);
        return this.registeringUserConverter.user2RegisteringUser(user);
    }

    @Override
    public void saveRegisteringUser(RegisteringUserEntity registeringUserEntity, ClientInformation client) {
        User user = this.registeringUserConverter.registeringUser2User(registeringUserEntity, client);
        if (user.getUserId() == null) {
            Long userId = this.userDao.insert(user);
            registeringUserEntity.setUserId(userId);
        } else {
            this.userDao.update(user);
        }
    }
}
