package com.sparrow.passport.infrastructure.persistence.data.converter;

import com.sparrow.constant.Config;
import com.sparrow.passport.po.User;
import com.sparrow.passport.protocol.dto.UserProfileDTO;
import com.sparrow.utility.BeanUtility;
import com.sparrow.utility.ConfigUtility;
import com.sparrow.utility.StringUtility;

import javax.inject.Named;
import java.util.HashMap;
import java.util.Map;

@Named
public class UserProfileConverter {
    public UserProfileDTO user2Profile(User user) {
        if (user == null) {
            return null;
        }
        UserProfileDTO userProfileDTO = new UserProfileDTO();
        BeanUtility.copyProperties(user, userProfileDTO);
        if (StringUtility.isNullOrEmpty(user.getAvatar())) {
            userProfileDTO.setAvatar(ConfigUtility.getValue(Config.DEFAULT_AVATAR));
        }
        return userProfileDTO;
    }


    public Map<Long, UserProfileDTO> user2Profile(Map<Long, User> userMap) {
        if (userMap == null) {
            return null;
        }
        Map<Long, UserProfileDTO> userProfileDTOMap = new HashMap<>();
        for (Long userId : userMap.keySet()) {
            userProfileDTOMap.put(userId, this.user2Profile(userMap.get(userId)));
        }
        return userProfileDTOMap;
    }
}
