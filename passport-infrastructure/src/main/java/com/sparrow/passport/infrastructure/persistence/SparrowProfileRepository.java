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

import com.sparrow.context.SessionContext;
import com.sparrow.passport.dao.UserDAO;
import com.sparrow.passport.infrastructure.persistence.data.converter.UserProfileConverter;
import com.sparrow.passport.po.User;
import com.sparrow.passport.protocol.dto.UserProfileDTO;
import com.sparrow.passport.repository.UserProfileRepository;
import com.sparrow.protocol.BusinessException;
import com.sparrow.protocol.LoginUser;
import com.sparrow.protocol.dao.UniqueKeyCriteria;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.Collection;
import java.util.Map;

@Named
public class SparrowProfileRepository implements UserProfileRepository {
    @Inject
    private UserDAO userDao;

    @Inject
    private UserProfileConverter userProfileConverter;

    @Override
    public UserProfileDTO findByUserName(String userName) throws BusinessException {
        UniqueKeyCriteria uniqueKeyCriteria = UniqueKeyCriteria.createUniqueCriteria(userName, "userName");
        User user = this.userDao.getEntityByUnique(uniqueKeyCriteria);
        return this.userProfileConverter.user2Profile(user);
    }

    @Override
    public UserProfileDTO findByUserEmail(String email) throws BusinessException {
        UniqueKeyCriteria uniqueKeyCriteria = UniqueKeyCriteria.createUniqueCriteria(email, "email");
        User user = this.userDao.getEntityByUnique(uniqueKeyCriteria);
        return this.userProfileConverter.user2Profile(user);
    }

    @Override
    public UserProfileDTO findByUserMobile(String mobile) throws BusinessException {
        return null;
    }

    @Override
    public UserProfileDTO findByUserId(Long userId) throws BusinessException {
        User user = this.userDao.getEntity(userId);
        return this.userProfileConverter.user2Profile(user);
    }

    @Override
    public Map<Long, UserProfileDTO> findByUserIds(Collection<Long> userIds) throws BusinessException {
        Map<Long, User> userMap = this.userDao.getEntityMap(userIds);
        return this.userProfileConverter.user2Profile(userMap);
    }

    @Override
    public void modifyAvatar(String avatar) throws BusinessException {
        LoginUser loginUser = SessionContext.getLoginUser();
        this.userDao.modifyAvatar(loginUser.getUserId(), avatar);
    }
}
