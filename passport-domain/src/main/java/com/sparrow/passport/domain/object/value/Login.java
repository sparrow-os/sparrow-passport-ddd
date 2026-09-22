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

package com.sparrow.passport.domain.object.value;

import com.sparrow.protocol.ddd.ValueObject;

import java.util.Objects;

public class Login implements ValueObject<Login> {
    private Password password;
    private String encryptPassword;
    private Boolean rememberMe;
    private Double rememberDays;

    public Login(String password, String encryptPassword, Boolean rememberMe, Double rememberDays) {
        this.password = new Password(password);
        this.encryptPassword = encryptPassword;
        this.rememberMe = rememberMe;
        this.rememberDays = rememberDays;
    }

    public String getEncryptPassword() {
        return encryptPassword;
    }

    public Double getTokenExpireDays() {
        if (this.rememberMe == null || !this.rememberMe) {
            return 1D;
        }
        return rememberDays;
    }

    public Password getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Login))
            return false;
        Login login = (Login) o;
        return Objects.equals(getPassword(), login.getPassword()) &&
                Objects.equals(getEncryptPassword(), login.getEncryptPassword()) &&
                Objects.equals(rememberMe, login.rememberMe) &&
                Objects.equals(rememberDays, login.rememberDays);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPassword(), getEncryptPassword(), rememberMe, rememberDays);
    }

    @Override
    public boolean sameValueAs(Login login) {
        if (this.hashCode() != login.hashCode()) {
            return false;
        }
        return this.equals(login);
    }
}
