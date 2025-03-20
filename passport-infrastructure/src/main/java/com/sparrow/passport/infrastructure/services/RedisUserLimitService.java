package com.sparrow.passport.infrastructure.services;

import com.sparrow.protocol.BusinessException;
import com.sparrow.passport.domain.service.UserLimitService;

import javax.inject.Named;

@Named("userLimitService")
public class RedisUserLimitService implements UserLimitService {
    @Override
    public boolean canLogin(Long userId) throws BusinessException {
        return true;
    }

    @Override
    public boolean canRegister(String ip) throws BusinessException {
        return true;
    }
}
