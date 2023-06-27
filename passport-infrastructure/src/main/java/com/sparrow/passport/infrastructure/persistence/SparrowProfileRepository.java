package com.sparrow.passport.infrastructure.persistence;

import com.sparrow.passport.dao.UserDAO;
import com.sparrow.passport.infrastructure.persistence.data.converter.UserProfileConverter;
import com.sparrow.passport.po.User;
import com.sparrow.passport.protocol.dto.UserProfileDTO;
import com.sparrow.passport.repository.UserProfileRepository;
import com.sparrow.protocol.BusinessException;
import com.sparrow.protocol.dao.UniqueKeyCriteria;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Collection;
import java.util.Map;

@Named
public class SparrowProfileRepository implements UserProfileRepository {
    @Inject
    private UserDAO userDao;

    @Inject
    private UserProfileConverter userProfileConverter;

    @Override
    public UserProfileDTO findByUserName(String userName) throws BusinessException {
        UniqueKeyCriteria uniqueKeyCriteria = UniqueKeyCriteria.createUniqueCriteria(userName, "userName");
        User user = this.userDao.getEntityByUnique(uniqueKeyCriteria);
        return this.userProfileConverter.user2Profile(user);
    }

    @Override
    public UserProfileDTO findByUserEmail(String email) throws BusinessException {
        UniqueKeyCriteria uniqueKeyCriteria = UniqueKeyCriteria.createUniqueCriteria(email, "email");
        User user = this.userDao.getEntityByUnique(uniqueKeyCriteria);
        return this.userProfileConverter.user2Profile(user);
    }

    @Override
    public UserProfileDTO findByUserMobile(String mobile) throws BusinessException {
        return null;
    }

    @Override
    public UserProfileDTO findByUserId(Long userId) throws BusinessException {
        User user = this.userDao.getEntity(userId);
        return this.userProfileConverter.user2Profile(user);
    }

    @Override
    public Map<Long, UserProfileDTO> findByUserIds(Collection<Long> userIds) throws BusinessException {
        Map<Long,User> userMap = this.userDao.getEntityMap(userIds);
        return this.userProfileConverter.user2Profile(userMap);
    }
}
