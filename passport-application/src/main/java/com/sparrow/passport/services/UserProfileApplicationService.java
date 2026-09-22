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

import com.sparrow.passport.api.UserProfileAppService;
import com.sparrow.passport.domain.service.UserProfileService;
import com.sparrow.passport.protocol.dto.UserProfileDTO;
import com.sparrow.passport.protocol.param.UserModifyParam;
import com.sparrow.passport.repository.UserProfileRepository;
import com.sparrow.protocol.BusinessException;
import com.sparrow.protocol.LoginUser;
import com.sparrow.utility.CollectionsUtility;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

@Named
public class UserProfileApplicationService implements UserProfileAppService {

    @Inject
    private UserProfileService userProfileService;

    @Inject
    private UserProfileRepository userProfileRepository;

    @Override
    public UserProfileDTO getByIdentify(String userIdentify) throws BusinessException {
        return userProfileService.getByIdentify(userIdentify);
    }

    @Override
    public UserProfileDTO getByLoginUser(LoginUser loginUser) throws BusinessException {
        return userProfileRepository.findByUserId(loginUser.getUserId());
    }

    @Override
    public Map<Long, UserProfileDTO> getUserMap(Collection<Long> userIds) throws BusinessException {
        if (CollectionsUtility.isNullOrEmpty(userIds)) {
            return Collections.emptyMap();
        }
        return userProfileRepository.findByUserIds(userIds);
    }

    @Override
    public UserProfileDTO getUser(Long userId) throws BusinessException {
        return userProfileRepository.findByUserId(userId);
    }


    @Override
    public void modify(UserModifyParam user) throws BusinessException {
    }
}
