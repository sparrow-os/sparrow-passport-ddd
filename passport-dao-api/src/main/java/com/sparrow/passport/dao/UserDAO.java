package com.sparrow.passport.dao;

import com.sparrow.passport.po.SecurityPrincipal;
import com.sparrow.protocol.dao.DaoSupport;
import com.sparrow.passport.po.User;

public interface UserDAO extends DaoSupport<User, Long> {
    void save(SecurityPrincipal securityPrincipal);
}
