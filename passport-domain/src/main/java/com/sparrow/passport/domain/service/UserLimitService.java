package com.sparrow.passport.domain.service;

import com.sparrow.protocol.BusinessException;

public interface UserLimitService {
    boolean canDigThread(String userId, Long threadId) throws BusinessException;

    boolean canFindPassword(Long userId) throws BusinessException;

    boolean canLogin(Long userId) throws BusinessException;

    boolean canRegister(String ip) throws BusinessException;

    boolean canPublish(Long userId) throws BusinessException;

    boolean canLikeThread(Long userId, Long threadId);

    boolean canAddCentByLogin(Long userId);
}
