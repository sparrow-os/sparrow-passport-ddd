package com.sparrow.passport.infrastructure.persistence;

import com.sparrow.protocol.ClientInformation;
import com.sparrow.protocol.dao.UniqueKeyCriteria;
import com.sparrow.passport.dao.UserDAO;
import com.sparrow.passport.domain.entity.RegisteringUserEntity;
import com.sparrow.passport.infrastructure.persistence.data.mapper.UserMapper;
import com.sparrow.passport.po.User;
import com.sparrow.passport.repository.RegisteringUserRepository;
import javax.inject.Inject;
import javax.inject.Named;

@Named("registeringUserRepository")
public class SparrowRegisteringUserRepository implements RegisteringUserRepository {
    @Inject
    private UserDAO userDao;
    @Inject
    private UserMapper userMapper;

    @Override public RegisteringUserEntity findByEmail(String email) {
        UniqueKeyCriteria uniqueKeyCriteria = UniqueKeyCriteria.createUniqueCriteria(email, "email");
        User user = this.userDao.getEntityByUnique(uniqueKeyCriteria);
       return this.userMapper.user2RegisteringUser(user);
    }

    @Override public void saveRegisteringUser(RegisteringUserEntity registeringUserEntity, ClientInformation client) {
        User user = this.userMapper.registeringUser2User(registeringUserEntity, client);
        Long userId = this.userDao.insert(user);
        registeringUserEntity.setUserId(userId);
    }
}
