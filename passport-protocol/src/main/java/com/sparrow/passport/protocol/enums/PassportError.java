package com.sparrow.passport.protocol.enums;

import com.sparrow.protocol.ErrorSupport;
import com.sparrow.protocol.ModuleSupport;
public enum PassportError implements ErrorSupport {

    USER_NAME_EXIST(false, PassportModule.USER, "01", "User name exist"),
    USER_EMAIL_EXIST(false, PassportModule.USER, "02", "User email exist"),
    USER_MOBILE_EXIST(false, PassportModule.USER, "03", "User mobile exist"),
    USER_OLD_PASSWORD_ERROR(false, PassportModule.USER, "04", "User old password error"),
    USER_NAME_NOT_EXIST(false, PassportModule.USER, "05", "Username not exist"),
    USER_MOBILE_NOT_EXIST(false, PassportModule.USER, "06", "Mobile not exist"),
    USER_EMAIL_NOT_EXIST(false, PassportModule.USER, "07", "User email not exist"),
    USER_PASSWORD_ERROR(false, PassportModule.USER, "08", "User password error"),
    USER_PASSWORD_FORMAT_ERROR(false, PassportModule.USER, "09", "User password format error"),
    USER_DISABLED(false, PassportModule.USER, "10", "User disabled"),
    USER_NOT_ACTIVATE(false, PassportModule.USER, "11", "User not activate"),
    USER_PASSWORD_VALIDATE_TOKEN_ERROR(false, PassportModule.USER, "12", "user password validate_token error"),
    USER_VALIDATE_TIME_OUT(false, PassportModule.USER, "13", "user validate_code time out"),
    USER_VALIDATE_NOT_EXIST(false, PassportModule.USER, "14", "user validate_code not exist"),
    USER_VALIDATE_VALID(false, PassportModule.USER, "15", "user validate code valid"),
    USER_VALIDATE_TOKEN_TIME_OUT(false, PassportModule.USER, "16", "user validate token time out"),
    USER_REGISTER_NAME_NULL(false, PassportModule.USER, "17", "user name can't be null"),
    USER_REGISTER_MOBILE_NULL(false, PassportModule.USER, "18", "user mobile can't be null"),
    USER_REGISTER_EMAIL_NULL(false, PassportModule.USER, "19", "user email can't be null"),
    USER_AVATAR_NULL(false, PassportModule.USER, "20", "user avatar can't be null"),
    USER_AVATAR_CUT_COORDINATE_NULL(false, PassportModule.USER, "21", "user avatar cut coordinate can't be null"),
    USER_NOT_LOGIN(false, PassportModule.USER, "22", "user not login"),
    USER_TOKEN_TYPE_ERROR(false, PassportModule.USER, "23", "user token type error"),
    USER_TOKEN_ERROR(false, PassportModule.USER, "24", "user token error"),

    ;
    private boolean system;
    private ModuleSupport module;
    private String code;
    private String message;

    PassportError(boolean system, ModuleSupport module, String code, String message) {
        this.system = system;
        this.message = message;
        this.module = module;
        this.code = (system ? 0 : 1) + module.code() + code;
    }

    @Override
    public boolean system() {
        return this.system;
    }

    @Override
    public ModuleSupport module() {
        return this.module;
    }

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}