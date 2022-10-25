package com.sparrow.passport.dao;

import com.sparrow.passport.po.SecurityPrincipal;
import com.sparrow.protocol.dao.DaoSupport;
import com.sparrow.passport.po.User;
import com.sparrow.passport.protocol.query.UserQueryDTO;
import java.util.List;

public interface UserDAO extends DaoSupport<User, Long> {
    void save(SecurityPrincipal securityPrincipal);
}
