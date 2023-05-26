
package com.sparrow.passport.api;

import com.sparrow.passport.protocol.dto.UserProfileDTO;
import com.sparrow.passport.protocol.param.AvatarModifyParam;
import com.sparrow.passport.protocol.param.UserModifyParam;
import com.sparrow.protocol.BusinessException;

public interface UserProfileAppService {

    UserProfileDTO getByIdentify(String userIdentify) throws BusinessException;

    void modify(UserModifyParam user) throws BusinessException;

    Boolean modifyAvatar(AvatarModifyParam avatarModify) throws BusinessException;
}
