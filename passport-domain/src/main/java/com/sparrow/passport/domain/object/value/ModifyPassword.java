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

public class ModifyPassword implements ValueObject<ModifyPassword> {
    private String oldEncryptionPassword;
    private String newEncryptionPassword;
    private Password password;

    public ModifyPassword(String oldEncryptionPassword, String newPassword, String newEncryptionPassword) {
        this.oldEncryptionPassword = oldEncryptionPassword;
        this.password = new Password(newPassword);
        this.newEncryptionPassword = newEncryptionPassword;
    }

    public Password getNewOriginPassword() {
        return password;
    }

    public String getOldEncryptionPassword() {
        return oldEncryptionPassword;
    }

    public String getNewEncryptionPassword() {
        return newEncryptionPassword;
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        ModifyPassword password1 = (ModifyPassword) o;
        return Objects.equals(oldEncryptionPassword, password1.oldEncryptionPassword) && Objects.equals(newEncryptionPassword, password1.newEncryptionPassword) && Objects.equals(password, password1.password);
    }

    @Override public int hashCode() {
        return Objects.hash(oldEncryptionPassword, newEncryptionPassword, password);
    }

    @Override public boolean sameValueAs(ModifyPassword other) {
        if (this.hashCode() != other.hashCode()) {
            return false;
        }
        return this.equals(other);
    }
}
