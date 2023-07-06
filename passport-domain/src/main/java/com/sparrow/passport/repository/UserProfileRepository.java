package com.sparrow.passport.repository;

import com.sparrow.passport.protocol.dto.UserProfileDTO;
import com.sparrow.passport.protocol.param.AvatarModifyParam;
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
