package com.sparrow.passport.infrastructure.persistence;

import com.sparrow.passport.dao.UserDAO;
import com.sparrow.passport.domain.entity.SecurityPrincipalEntity;
import com.sparrow.passport.infrastructure.persistence.data.mapper.SecurityPrincipalMapper;
import com.sparrow.passport.infrastructure.persistence.data.mapper.UserMapper;
import com.sparrow.passport.po.SecurityPrincipal;
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
    @Inject
    private SecurityPrincipalMapper securityPrincipalMapper;

    @Override public SecurityPrincipalEntity findByUserId(Long userId) {
        User user = this.userDao.getEntity(userId);
        return this.userMapper.user2SecurityPrincipal(user);
    }

    @Override public SecurityPrincipalEntity findByEmail(String email) {
        UniqueKeyCriteria uniqueKeyCriteria = UniqueKeyCriteria.createUniqueCriteria(email, "email");
        User user = this.userDao.getEntityByUnique(uniqueKeyCriteria);
        return this.userMapper.user2SecurityPrincipal(user);
    }

    @Override public SecurityPrincipalEntity findByName(String userName) {
        UniqueKeyCriteria uniqueKeyCriteria = UniqueKeyCriteria.createUniqueCriteria(userName, "userName");
        User user = this.userDao.getEntityByUnique(uniqueKeyCriteria);
        return this.userMapper.user2SecurityPrincipal(user);
    }

    @Override public SecurityPrincipalEntity findByMobile(String mobile, String secretMobile) {
//        SearchCriteria searchCriteria = new SearchCriteria();
//        searchCriteria.setWhere(BooleanCriteria.criteria(Criteria.field("mobile").equal(mobile))
//            .and(Criteria.field("user.secretMobile").equal(secretMobile)));
        //return this.userMapper.user2SecurityPrincipal(this.userDao.getEntity(searchCriteria));
        return null;
    }

    @Override public void saveSecurity(SecurityPrincipalEntity securityPrincipalEntity) {
        SecurityPrincipal securityPrincipal = this.securityPrincipalMapper.entity2Po(securityPrincipalEntity);
        this.userDao.modifyPassword(securityPrincipal);
    }
}
