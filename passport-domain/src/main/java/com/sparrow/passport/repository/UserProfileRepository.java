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

package com.sparrow.passport.repository;

import com.sparrow.passport.protocol.dto.UserProfileDTO;
import com.sparrow.protocol.BusinessException;

import java.util.Collection;
import java.util.Map;

public interface UserProfileRepository {
    UserProfileDTO findByUserName(String userName) throws BusinessException;

    UserProfileDTO findByUserEmail(String email) throws BusinessException;

    UserProfileDTO findByUserMobile(String mobile) throws BusinessException;

    UserProfileDTO findByUserId(Long userId) throws BusinessException;

    Map<Long, UserProfileDTO> findByUserIds(Collection<Long> userIds) throws BusinessException;

    void modifyAvatar(String avatar) throws BusinessException;
}
