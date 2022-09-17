
package com.sparrow.passport.api;

import com.sparrow.protocol.BusinessException;
import com.sparrow.protocol.LoginToken;
import com.sparrow.protocol.dto.AuthorDTO;
import com.sparrow.passport.protocol.param.AvatarModifyParam;
import com.sparrow.passport.protocol.dto.BasicUserDTO;
import com.sparrow.passport.protocol.param.UserModifyParam;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface UserProfileService {

    String getOfficialUrlOfEmail(Long userId) throws BusinessException;

    BasicUserDTO getByEmail(String email);

    BasicUserDTO getByUserName(String userName);

    BasicUserDTO getByMobile(String mobile);

    Boolean existMobile(String mobile);

    Boolean existUserName(String userName);

    Boolean existEmail(String email);

    Long getCent(Long userId) throws BusinessException;

    String getUserName(Long userId) throws BusinessException;

    BasicUserDTO getUserDetailByUserName(String userName) throws BusinessException;

    Integer online(Long userId) throws BusinessException;

    Integer offline(Long userId) throws BusinessException;

    List<BasicUserDTO> getSort(Integer top, Integer popularityCount, String userSort) throws BusinessException;

    BasicUserDTO getBasicUser(Long userId, String size) throws BusinessException;

    AuthorDTO getAuthor(Long userId) throws BusinessException;

    Map<Long, AuthorDTO> getAuthorMap(Collection<Long> userIds) throws BusinessException;

    LoginToken modify(UserModifyParam user) throws BusinessException;

    Boolean modifyAvatar(AvatarModifyParam avatarModify) throws BusinessException;
}
