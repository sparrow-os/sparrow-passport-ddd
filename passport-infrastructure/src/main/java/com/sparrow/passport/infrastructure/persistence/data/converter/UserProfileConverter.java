package com.sparrow.passport.infrastructure.persistence.data.converter;

import com.sparrow.passport.po.User;
import com.sparrow.passport.protocol.dto.UserProfileDTO;
import com.sparrow.utility.BeanUtility;

import javax.inject.Named;

@Named
public class UserProfileConverter {
    public UserProfileDTO user2Profile(User user) {
        if (user == null) {
            return null;
        }
        UserProfileDTO userProfileDTO = new UserProfileDTO();
        BeanUtility.copyProperties(user, userProfileDTO);
        return userProfileDTO;
    }
}
