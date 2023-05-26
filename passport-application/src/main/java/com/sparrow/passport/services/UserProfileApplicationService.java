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
    public void modify(UserModifyParam user) throws BusinessException {
    }

    @Override
    public Boolean modifyAvatar(AvatarModifyParam avatarModify) throws BusinessException {
        return null;
    }
}
