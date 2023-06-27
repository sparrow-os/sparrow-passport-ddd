
package com.sparrow.passport.api;

import com.sparrow.passport.protocol.dto.UserProfileDTO;
import com.sparrow.passport.protocol.param.AvatarModifyParam;
import com.sparrow.passport.protocol.param.UserModifyParam;
import com.sparrow.protocol.BusinessException;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface UserProfileAppService {

    UserProfileDTO getByIdentify(String userIdentify) throws BusinessException;

    /**
     * 通过用户ID 列表 返回用户基本信息
     *
     * @param userIds
     * @return
     * @throws BusinessException
     */
    Map<Long,UserProfileDTO> getUserMap(Collection<Long> userIds) throws BusinessException;

    UserProfileDTO getUser(Long userId) throws BusinessException;

    void modify(UserModifyParam user) throws BusinessException;

    Boolean modifyAvatar(AvatarModifyParam avatarModify) throws BusinessException;
}
