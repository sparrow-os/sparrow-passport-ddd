package com.sparrow.spring.reflect;

import com.sparrow.cg.MethodAccessor;
import com.sparrow.passport.protocol.dto.BasicUserDTO;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

public class BasicUserDTOMethodAccess implements MethodAccessor {
    private static Map<String, BiFunction<BasicUserDTO, String, Object>> getMap = new HashMap<>(1280);
    private static Map<String, BiConsumer<BasicUserDTO, Object>> setMap = new HashMap<>();

    static {
        getMap.put("getUserName", (o, s) -> o.getUserName());
        setMap.put("setUserName", (o, arg) -> o.setUserName((String) arg));
    }

    public Object get(Object o, String methodName) {
        com.sparrow.passport.protocol.dto.BasicUserDTO basicUserDTO = (com.sparrow.passport.protocol.dto.BasicUserDTO) o;
        return getMap.get(methodName).apply(basicUserDTO, methodName);
    }

    public void set(Object o, String methodName, Object arg) {
        com.sparrow.passport.protocol.dto.BasicUserDTO basicUserDTO = (com.sparrow.passport.protocol.dto.BasicUserDTO) o;

        if (methodName.equalsIgnoreCase("setUserName") || methodName.equalsIgnoreCase("userName")) {
            basicUserDTO.setUserName((java.lang.String) arg);
            return;
        }

        if (methodName.equalsIgnoreCase("setDevice") || methodName.equalsIgnoreCase("device")) {
            basicUserDTO.setDevice((java.lang.String) arg);
        }

        if (methodName.equalsIgnoreCase("setDeviceId") || methodName.equalsIgnoreCase("deviceId")) {
            basicUserDTO.setDeviceId((java.lang.String) arg);
        }

        if (methodName.equalsIgnoreCase("setDeviceModel") || methodName.equalsIgnoreCase("deviceModel")) {
            basicUserDTO.setDeviceModel((java.lang.String) arg);
        }

        if (methodName.equalsIgnoreCase("setActivate") || methodName.equalsIgnoreCase("activate")) {
            basicUserDTO.setActivate((java.lang.Boolean) arg);
        }

        if (methodName.equalsIgnoreCase("setMobile") || methodName.equalsIgnoreCase("mobile")) {
            basicUserDTO.setMobile((java.lang.String) arg);
        }

        if (methodName.equalsIgnoreCase("setLastLoginTime") || methodName.equalsIgnoreCase("lastLoginTime")) {
            basicUserDTO.setLastLoginTime((java.lang.Long) arg);
        }

        if (methodName.equalsIgnoreCase("setStatus") || methodName.equalsIgnoreCase("status")) {
            basicUserDTO.setStatus((java.lang.String) arg);
        }

        if (methodName.equalsIgnoreCase("setCreateTime") || methodName.equalsIgnoreCase("createTime")) {
            basicUserDTO.setCreateTime((java.lang.Long) arg);
        }

        if (methodName.equalsIgnoreCase("setUpdateTime") || methodName.equalsIgnoreCase("updateTime")) {
            basicUserDTO.setUpdateTime((java.lang.Long) arg);
        }

        if (methodName.equalsIgnoreCase("setActivateTime") || methodName.equalsIgnoreCase("activateTime")) {
            basicUserDTO.setActivateTime((java.lang.Long) arg);
        }

        if (methodName.equalsIgnoreCase("setAvatar") || methodName.equalsIgnoreCase("avatar")) {
            basicUserDTO.setAvatar((java.lang.String) arg);
        }

        if (methodName.equalsIgnoreCase("setGender") || methodName.equalsIgnoreCase("gender")) {
            basicUserDTO.setGender((java.lang.String) arg);
        }

        if (methodName.equalsIgnoreCase("setBirthday") || methodName.equalsIgnoreCase("birthday")) {
            basicUserDTO.setBirthday((java.sql.Date) arg);
        }

        if (methodName.equalsIgnoreCase("setNickName") || methodName.equalsIgnoreCase("nickName")) {
            basicUserDTO.setNickName((java.lang.String) arg);
        }

        if (methodName.equalsIgnoreCase("setPersonalSignature") || methodName.equalsIgnoreCase("personalSignature")) {
            basicUserDTO.setPersonalSignature((java.lang.String) arg);
        }

        if (methodName.equalsIgnoreCase("setOnline") || methodName.equalsIgnoreCase("online")) {
            basicUserDTO.setOnline((java.lang.Boolean) arg);
        }

        if (methodName.equalsIgnoreCase("setUserId") || methodName.equalsIgnoreCase("userId")) {
            basicUserDTO.setUserId((java.lang.Long) arg);
        }

        if (methodName.equalsIgnoreCase("setIp") || methodName.equalsIgnoreCase("ip")) {
            basicUserDTO.setIp((java.lang.String) arg);
        }

        if (methodName.equalsIgnoreCase("setCent") || methodName.equalsIgnoreCase("cent")) {
            basicUserDTO.setCent((java.lang.Long) arg);
        }

        if (methodName.equalsIgnoreCase("setEmail") || methodName.equalsIgnoreCase("email")) {
            basicUserDTO.setEmail((java.lang.String) arg);
        }

        if (methodName.equalsIgnoreCase("setZone") || methodName.equalsIgnoreCase("zone")) {
            basicUserDTO.setZone((java.lang.String) arg);
        }
    }
}