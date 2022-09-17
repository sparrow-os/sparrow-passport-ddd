package com.sparrow.passport.dao;

import com.sparrow.orm.query.BooleanCriteria;
import com.sparrow.orm.query.Criteria;
import com.sparrow.orm.query.SearchCriteria;
import com.sparrow.orm.template.impl.ORMStrategy;
import com.sparrow.passport.po.User;
import com.sparrow.passport.protocol.query.UserQueryDTO;
import java.util.List;
import javax.inject.Named;

@Named("userDao")
public class UserDAOImpl extends ORMStrategy<User, Long> implements UserDAO {

    private SearchCriteria getSearchCriteria(UserQueryDTO userQuery) {
        SearchCriteria searchCriteria = new SearchCriteria();
        searchCriteria.setWhere(BooleanCriteria.criteria(
            Criteria.field("user.userName").equal(userQuery.getUserName())).
            and(Criteria.field("user.nickName").equal(userQuery.getNickName()))
            .and(Criteria.field("user.status").equal(userQuery.getStatus()))
            .and(Criteria.field("user.gender").equal(userQuery.getGender()))
            .and(Criteria.field("user.registerTime").greaterThan(userQuery.getRegisterStartTime()))
            .and(Criteria.field("user.registerTime").lessThan(userQuery.getRegisterEndTime()))
            .and(Criteria.field("user.activate").equal(userQuery.getActivate()))
            .and(Criteria.field("user.email").equal(userQuery.getEmail()))
        );
        return searchCriteria;
    }

    @Override public List<User> queryList(UserQueryDTO userQuery) {
        return this.getList(this.getSearchCriteria(userQuery));
    }

    @Override public Integer getCount(UserQueryDTO userQuery) {
        return this.getCount(userQuery);
    }
}
