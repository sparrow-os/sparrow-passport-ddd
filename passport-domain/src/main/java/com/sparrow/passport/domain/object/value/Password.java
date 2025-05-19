package com.sparrow.passport.domain.object.value;

import com.sparrow.constant.Regex;
import com.sparrow.passport.protocol.enums.PassportError;
import com.sparrow.protocol.BusinessException;
import com.sparrow.protocol.ddd.ValueObject;
import com.sparrow.utility.RegexUtility;
import com.sparrow.utility.StringUtility;

public class Password implements ValueObject<Password> {
    public Password(String originPassword) {
        this.originPassword = originPassword;
    }

    private String originPassword;

    public void isValid() throws BusinessException {
        //新密码为空或格式不正确
        if (StringUtility.isNullOrEmpty(originPassword) || !RegexUtility
            .matches(originPassword, Regex.PASSWORD)) {
            throw new BusinessException(PassportError.USER_PASSWORD_FORMAT_ERROR);
        }
    }

    @Override public boolean sameValueAs(Password password) {
        return this.originPassword.equals(password.originPassword);
    }
}
