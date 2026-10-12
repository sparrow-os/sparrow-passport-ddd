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

package com.sparrow.passport.domain.service;

import com.sparrow.exception.Asserts;
import com.sparrow.passport.protocol.dto.UserProfileDTO;
import com.sparrow.passport.protocol.enums.PassportError;
import com.sparrow.passport.protocol.param.AvatarModifyParam;
import com.sparrow.passport.repository.UserProfileRepository;
import com.sparrow.protocol.BusinessException;
import com.sparrow.protocol.constant.magic.Symbol;
import com.sparrow.protocol.enums.StatusRecord;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.extern.slf4j.Slf4j;

@Named
@Slf4j
public class UserProfileService {
    public UserProfileService() {
        log.info("UserProfileService init");
    }

    @Inject
    UserProfileRepository userProfileRepository;

    public UserProfileDTO getByIdentify(String userIdentify) throws BusinessException {
        UserProfileDTO userProfile = null;
        if (userIdentify.contains(Symbol.AT)) {
            userProfile = userProfileRepository.findByUserEmail(userIdentify);
        } else {
            userProfile = userProfileRepository.findByUserName(userIdentify);
//            if (securityPrincipal == null) {
//                Pair<String, String> mobilePair = shortMessageService.secretMobile(loginName);
//                securityPrincipal = securityPrincipalRepository.findByMobile(mobilePair.getFirst(), mobilePair.getSecond());
//            }
        }
        Asserts.isTrue(userProfile == null, PassportError.USER_NAME_NOT_EXIST);
        Asserts.isTrue(StatusRecord.DISABLE == userProfile.getStatus(), PassportError.USER_DISABLED);
        return userProfile;
    }

    public void modifyAvatar(AvatarModifyParam avatarModifyParam) throws BusinessException {
        this.userProfileRepository.modifyAvatar(avatarModifyParam.getAvatar());
    }
}
