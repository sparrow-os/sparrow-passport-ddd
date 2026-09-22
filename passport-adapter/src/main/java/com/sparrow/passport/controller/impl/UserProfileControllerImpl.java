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

package com.sparrow.passport.controller.impl;

import com.sparrow.context.SessionContext;
import com.sparrow.passport.controller.UserProfileController;
import com.sparrow.passport.controller.assemble.UserAssemble;
import com.sparrow.passport.controller.protocol.vo.BasicUserVO;
import com.sparrow.passport.domain.service.UserProfileService;
import com.sparrow.passport.protocol.dto.UserProfileDTO;
import com.sparrow.passport.protocol.param.AvatarModifyParam;
import com.sparrow.passport.repository.UserProfileRepository;
import com.sparrow.protocol.BusinessException;
import com.sparrow.protocol.LoginUser;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.IOException;

@Named
public class UserProfileControllerImpl implements UserProfileController {
    @Inject
    private UserProfileService userProfileService;
    @Inject
    private UserProfileRepository userProfileRepository;

    @Inject
    private UserAssemble userAssemble;

    @Override
    public BasicUserVO loadUserBasic() throws BusinessException {
        LoginUser loginUser = SessionContext.getLoginUser();
        UserProfileDTO userProfile = userProfileRepository.findByUserId(loginUser.getUserId());
        return this.userAssemble.assemble(userProfile);
    }

    @Override
    public String modifyAvatar(AvatarModifyParam avatarModifyParam) throws BusinessException, IOException {
        return userProfileService.modifyAvatar(avatarModifyParam);
    }
}
