package com.sparrow.passport.infrastructure.persistence;

import com.sparrow.passport.infrastructure.persistence.data.converter.RegisteringUserConverter;
import com.sparrow.protocol.ClientInformation;
import com.sparrow.protocol.dao.UniqueKeyCriteria;
import com.sparrow.passport.dao.UserDAO;
import com.sparrow.passport.domain.entity.RegisteringUserEntity;
import com.sparrow.passport.po.User;
import com.sparrow.passport.repository.RegisteringUserRepository;
import javax.inject.Inject;
import javax.inject.Named;

@Named("registeringUserRepository")
public class SparrowRegisteringUserRepository implements RegisteringUserRepository {
    @Inject
    private UserDAO userDao;
    @Inject
    private RegisteringUserConverter registeringUserConverter;

    @Override public RegisteringUserEntity findByEmail(String email) {
        UniqueKeyCriteria uniqueKeyCriteria = UniqueKeyCriteria.createUniqueCriteria(email, "email");
        User user = this.userDao.getEntityByUnique(uniqueKeyCriteria);
        return this.registeringUserConverter.user2RegisteringUser(user);
    }

    @Override public void saveRegisteringUser(RegisteringUserEntity registeringUserEntity, ClientInformation client) {
        User user = this.registeringUserConverter.registeringUser2User(registeringUserEntity, client);
        if (user.getUserId() == null) {
            Long userId = this.userDao.insert(user);
            registeringUserEntity.setUserId(userId);
        } else {
            this.userDao.update(user);
        }
    }
}
