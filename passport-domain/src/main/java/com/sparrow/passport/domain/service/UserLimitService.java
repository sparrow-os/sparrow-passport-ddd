package com.sparrow.passport.domain.service;

import com.sparrow.protocol.BusinessException;

public interface UserLimitService {
    
    boolean canLogin(Long userId) throws BusinessException;

    boolean canRegister(String ip) throws BusinessException;
}
