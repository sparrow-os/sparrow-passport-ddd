package com.sparrow.passport.domain.object.value;

import com.sparrow.protocol.ddd.ValueObject;
import java.util.Objects;

public class Login implements ValueObject<Login> {
    private Password password;
    private String encryptPassword;
    private Boolean rememberMe;
    private Integer rememberDays;

    public Login(String password, String encryptPassword, Boolean rememberMe, Integer rememberDays) {
        this.password = new Password(password);
        this.encryptPassword = encryptPassword;
        this.rememberMe = rememberMe;
        this.rememberDays = rememberDays;
    }

    public String getEncryptPassword() {
        return encryptPassword;
    }

    public Integer getTokenExpireDays() {
        if (this.rememberMe == null || !this.rememberMe) {
            return 1;
        }
        if (rememberDays == null) {
            return 15;
        }
        return rememberDays;
    }

    public Password getPassword() {
        return password;
    }

    @Override public boolean equals(Object o) {
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

    @Override public int hashCode() {
        return Objects.hash(getPassword(), getEncryptPassword(), rememberMe, rememberDays);
    }

    @Override public boolean sameValueAs(Login login) {
        if (this.hashCode() != login.hashCode()) {
            return false;
        }
        return this.equals(login);
    }
}
