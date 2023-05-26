package com.sparrow.passport.repository;

import com.sparrow.passport.protocol.dto.UserProfileDTO;
import com.sparrow.protocol.BusinessException;

public interface UserProfileRepository {
    UserProfileDTO findByUserName(String userName) throws BusinessException;

    UserProfileDTO findByUserEmail(String email) throws BusinessException;

    UserProfileDTO findByUserMobile(String mobile) throws BusinessException;

}
