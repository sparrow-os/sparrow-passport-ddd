package com.sparrow.passport.dao;

import com.sparrow.orm.query.Criteria;
import com.sparrow.orm.query.UpdateCriteria;
import com.sparrow.orm.query.UpdateSetClausePair;
import com.sparrow.orm.template.impl.ORMStrategy;
import com.sparrow.passport.po.SecurityPrincipal;
import com.sparrow.passport.po.User;
import com.sparrow.utility.StringUtility;

import javax.inject.Named;

@Named("userDao")
public class UserDAOImpl extends ORMStrategy<User, Long> implements UserDAO {

    @Override
    public void save(SecurityPrincipal securityPrincipal) {
        UpdateCriteria updateCriteria = new UpdateCriteria();
        if (!StringUtility.isNullOrEmpty(securityPrincipal.getPassword())) {
            updateCriteria.set(UpdateSetClausePair.field("user.password").equal(securityPrincipal.getPassword()));
        }
        if (securityPrincipal.getLastLoginTime() != null) {
            updateCriteria.set(UpdateSetClausePair.field("user.lastLoginTime").equal(securityPrincipal.getLastLoginTime()));
        }
        updateCriteria.setWhere(Criteria.field("user.userId").equal(securityPrincipal.getUserId()));
        this.update(updateCriteria);
    }

    @Override
    public void modifyAvatar(Long userId, String avatar) {
        UpdateCriteria updateCriteria = new UpdateCriteria();
        if (!StringUtility.isNullOrEmpty(avatar)) {
            updateCriteria.set(UpdateSetClausePair.field("user.avatar").equal(avatar));
        }
        updateCriteria.set(UpdateSetClausePair.field("user.gmtModified").equal(System.currentTimeMillis()));
        updateCriteria.setWhere(Criteria.field("user.userId").equal(userId));
        this.update(updateCriteria);
    }
}
