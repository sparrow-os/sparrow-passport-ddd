package com.sparrow.passport.controller.impl;

import com.sparrow.passport.controller.UserProfileController;
import com.sparrow.passport.controller.assemble.UserAssemble;
import com.sparrow.passport.controller.protocol.vo.BasicUserVO;
import com.sparrow.passport.domain.DomainRegistry;
import com.sparrow.passport.domain.service.UserProfileService;
import com.sparrow.passport.protocol.dto.UserProfileDTO;
import com.sparrow.passport.protocol.param.AvatarModifyParam;
import com.sparrow.protocol.BusinessException;
import com.sparrow.protocol.LoginUser;
import com.sparrow.protocol.ThreadContext;

import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;

@Named
public class UserProfileControllerImpl implements UserProfileController {
    @Inject
    private DomainRegistry domainRegistry;

    @Inject
    private UserAssemble userAssemble;

    @Override
    public BasicUserVO loadUserBasic() throws BusinessException {
        LoginUser loginUser = ThreadContext.getLoginToken();
        UserProfileDTO userProfile = this.domainRegistry.getUserProfileRepository().findByUserId(loginUser.getUserId());
        return this.userAssemble.assemble(userProfile);
    }

    @Override
    public String modifyAvatar(AvatarModifyParam avatarModifyParam) throws BusinessException, IOException {
        UserProfileService userProfileService = this.domainRegistry.getUserProfileService();
        return userProfileService.modifyAvatar(avatarModifyParam);
    }
}
