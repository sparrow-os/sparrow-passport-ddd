package com.sparrow.passport.infrastructure.services;

import com.sparrow.protocol.BusinessException;
import com.sparrow.passport.domain.service.UserLimitService;
import javax.inject.Named;

@Named("userLimitService")
public class RedisUserLimitService implements UserLimitService {
    @Override
    public boolean canDigThread(String userId, Long threadId) throws BusinessException {
        return true;
    }

    @Override
    public boolean canFindPassword(Long userId) throws BusinessException {
        return true;
    }

    @Override
    public boolean canLogin(Long userId) throws BusinessException {
        return true;
    }

    @Override
    public boolean canRegister(String ip) throws BusinessException {
        return true;
    }

    @Override
    public boolean canPublish(Long userId) throws BusinessException {
        return true;
    }

    @Override
    public boolean canLikeThread(Long userId, Long threadId) {
        return true;
    }

    @Override
    public boolean canAddCentByLogin(Long userId) {
        return true;
    }
}