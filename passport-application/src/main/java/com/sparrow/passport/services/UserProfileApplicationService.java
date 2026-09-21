package com.sparrow.passport.services;

import com.sparrow.passport.api.UserProfileAppService;
import com.sparrow.passport.domain.DomainRegistry;
import com.sparrow.passport.domain.service.UserProfileService;
import com.sparrow.passport.protocol.dto.UserProfileDTO;
import com.sparrow.passport.protocol.param.UserModifyParam;
import com.sparrow.passport.repository.UserProfileRepository;
import com.sparrow.protocol.BusinessException;
import com.sparrow.protocol.LoginUser;
import com.sparrow.utility.CollectionsUtility;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

@Named
public class UserProfileApplicationService implements UserProfileAppService {

    @Inject
    private UserProfileService userProfileService;

    @Inject
    private UserProfileRepository userProfileRepository;

    @Override
    public UserProfileDTO getByIdentify(String userIdentify) throws BusinessException {
        return userProfileService.getByIdentify(userIdentify);
    }

    @Override
    public UserProfileDTO getByLoginUser(LoginUser loginUser) throws BusinessException {
        return userProfileRepository.findByUserId(loginUser.getUserId());
    }

    @Override
    public Map<Long, UserProfileDTO> getUserMap(Collection<Long> userIds) throws BusinessException {
        if (CollectionsUtility.isNullOrEmpty(userIds)) {
            return Collections.emptyMap();
        }
        return userProfileRepository.findByUserIds(userIds);
    }

    @Override
    public UserProfileDTO getUser(Long userId) throws BusinessException {
        return userProfileRepository.findByUserId(userId);
    }


    @Override
    public void modify(UserModifyParam user) throws BusinessException {
    }
}
