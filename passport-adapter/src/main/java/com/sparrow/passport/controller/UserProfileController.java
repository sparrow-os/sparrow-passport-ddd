package com.sparrow.passport.controller;

import com.sparrow.passport.protocol.param.AvatarModifyParam;
import com.sparrow.protocol.BusinessException;
import com.sparrow.passport.controller.protocol.vo.BasicUserVO;

import java.io.IOException;
import java.util.List;

public interface UserProfileController {

    BasicUserVO loadUserBasic() throws BusinessException;

    String modifyAvatar(AvatarModifyParam avatarModifyParam) throws BusinessException, IOException;
}
