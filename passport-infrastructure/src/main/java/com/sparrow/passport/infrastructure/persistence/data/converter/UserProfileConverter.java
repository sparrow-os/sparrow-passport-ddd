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

import com.sparrow.passport.po.User;
import com.sparrow.passport.protocol.dto.UserProfileDTO;
import com.sparrow.protocol.BeanCopier;
import com.sparrow.support.web.WebConfigReader;
import com.sparrow.utility.StringUtility;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.HashMap;
import java.util.Map;

@Named
public class UserProfileConverter {
    @Inject
    private WebConfigReader webConfigReader;

    @Inject
    private BeanCopier beanCopier;

    public UserProfileDTO user2Profile(User user) {
        if (user == null) {
            return null;
        }
        UserProfileDTO userProfileDTO = new UserProfileDTO();
        this.beanCopier.copyProperties(user, userProfileDTO);
        if (StringUtility.isNullOrEmpty(user.getAvatar())) {
            String defaultAvatar = this.webConfigReader.getDefaultAvatar();
            if (defaultAvatar != null && defaultAvatar.contains("$userId")) {
                defaultAvatar = defaultAvatar.replace("$userId", String.valueOf(user.getUserId() % 10));
            }
            userProfileDTO.setAvatar(defaultAvatar);
        }
        return userProfileDTO;
    }


    public Map<Long, UserProfileDTO> user2Profile(Map<Long, User> userMap) {
        if (userMap == null) {
            return null;
        }
        Map<Long, UserProfileDTO> userProfileDTOMap = new HashMap<>();
        for (Long userId : userMap.keySet()) {
            userProfileDTOMap.put(userId, this.user2Profile(userMap.get(userId)));
        }
        return userProfileDTOMap;
    }
}
