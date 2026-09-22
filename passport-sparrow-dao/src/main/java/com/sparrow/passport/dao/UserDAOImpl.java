/*
Licensed to the Apache Software Foundation (ASF) under one or more
contributor license agreements.  See the NOTICE file distributed with
this work for additional information regarding copyright ownership.
The ASF licenses this file to You under the Apache License, Version 2.0
(the "License"); you may not use this file except in compliance with
the License.  You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/

package com.sparrow.passport.dao;

import com.sparrow.orm.query.Criteria;
import com.sparrow.orm.query.UpdateCriteria;
import com.sparrow.orm.query.UpdateSetClausePair;
import com.sparrow.orm.template.impl.ORMStrategy;
import com.sparrow.passport.po.SecurityPrincipal;
import com.sparrow.passport.po.User;
import com.sparrow.utility.StringUtility;

import jakarta.inject.Named;

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
