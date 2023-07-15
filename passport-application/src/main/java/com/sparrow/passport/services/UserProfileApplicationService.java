package com.sparrow.passport.services;

import com.sparrow.passport.api.UserProfileAppService;
import com.sparrow.passport.domain.DomainRegistry;
import com.sparrow.passport.domain.service.UserProfileService;
import com.sparrow.passport.protocol.dto.UserProfileDTO;
import com.sparrow.passport.protocol.param.AvatarModifyParam;
import com.sparrow.passport.protocol.param.UserModifyParam;
import com.sparrow.protocol.BusinessException;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Collection;
import java.util.Map;

@Named
public class UserProfileApplicationService implements UserProfileAppService {

    @Inject
    private DomainRegistry domainRegistry;

    @Override
    public UserProfileDTO getByIdentify(String userIdentify) throws BusinessException {
        UserProfileService userProfileService = this.domainRegistry.getUserProfileService();
        return userProfileService.getByIdentify(userIdentify);
    }

    @Override
    public Map<Long, UserProfileDTO> getUserMap(Collection<Long> userIds) throws BusinessException {
        return this.domainRegistry.getUserProfileRepository().findByUserIds(userIds);
    }

    @Override
    public UserProfileDTO getUser(Long userId) throws BusinessException {
        return domainRegistry.getUserProfileRepository().findByUserId(userId);
    }


    @Override
    public void modify(UserModifyParam user) throws BusinessException {
    }
}
