package com.sparrow.passport.infrastructure.persistence;

import com.sparrow.passport.dao.UserDAO;
import com.sparrow.passport.domain.entity.SecurityPrincipal;
import com.sparrow.passport.infrastructure.persistence.data.mapper.UserMapper;
import com.sparrow.passport.po.User;
import com.sparrow.passport.repository.SecurityPrincipalRepository;
import com.sparrow.protocol.dao.UniqueKeyCriteria;
import javax.inject.Inject;
import javax.inject.Named;

@Named("securityPrincipalRepository")
public class SparrowSecurityPrincipalRepository implements SecurityPrincipalRepository {
    @Inject
    private UserDAO userDao;
    @Inject
    private UserMapper userMapper;

    @Override public SecurityPrincipal findByUserId(Long userId) {
        User user = this.userDao.getEntity(userId);
        return this.userMapper.user2SecurityPrincipal(user);
    }

    @Override public SecurityPrincipal findByEmail(String email) {
        UniqueKeyCriteria uniqueKeyCriteria = UniqueKeyCriteria.createUniqueCriteria(email, "email");
        User user = this.userDao.getEntityByUnique(uniqueKeyCriteria);
        return this.userMapper.user2SecurityPrincipal(user);
    }

    @Override public SecurityPrincipal findByName(String userName) {
        UniqueKeyCriteria uniqueKeyCriteria = UniqueKeyCriteria.createUniqueCriteria(userName, "userName");
        User user = this.userDao.getEntityByUnique(uniqueKeyCriteria);
        return this.userMapper.user2SecurityPrincipal(user);
    }

    @Override public SecurityPrincipal findByMobile(String mobile, String secretMobile) {
//        SearchCriteria searchCriteria = new SearchCriteria();
//        searchCriteria.setWhere(BooleanCriteria.criteria(Criteria.field("mobile").equal(mobile))
//            .and(Criteria.field("user.secretMobile").equal(secretMobile)));
        //return this.userMapper.user2SecurityPrincipal(this.userDao.getEntity(searchCriteria));
        return null;
    }

    @Override public void saveSecurity(SecurityPrincipal securityPrincipal) {
//        UpdateCriteria updateCriteria = new UpdateCriteria();
//        updateCriteria.set(UpdateSetClausePair.field("user.lastLoginTime").equal(securityPrincipal.getLastLoginTime()));
//        updateCriteria.set(UpdateSetClausePair.field("user.password").equal(securityPrincipal.getPassword()));
//        updateCriteria.set(UpdateSetClausePair.field("user.cent").add(securityPrincipal.getPlusCent()));
//        updateCriteria.set(UpdateSetClausePair.field("user.activate").equal(securityPrincipal.getActivate()));
//        updateCriteria.setWhere(Criteria.field("user.userId").equal(securityPrincipal.getUserId()));
        //this.userDao.update(updateCriteria);
    }
}
