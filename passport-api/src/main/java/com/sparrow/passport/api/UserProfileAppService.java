
package com.sparrow.passport.api;

import com.sparrow.passport.protocol.dto.UserProfileDTO;
import com.sparrow.passport.protocol.param.UserModifyParam;
import com.sparrow.protocol.BusinessException;
import com.sparrow.protocol.LoginUser;

import java.util.Collection;
import java.util.Map;

public interface UserProfileAppService {

    UserProfileDTO getByIdentify(String userIdentify) throws BusinessException;

    UserProfileDTO getByLoginUser(LoginUser loginUser) throws BusinessException;

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
}
