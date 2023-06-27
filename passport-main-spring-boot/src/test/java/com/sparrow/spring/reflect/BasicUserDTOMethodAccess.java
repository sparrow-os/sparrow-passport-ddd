package com.sparrow.spring.reflect;

import com.sparrow.cg.MethodAccessor;
import com.sparrow.passport.protocol.dto.UserProfileDTO;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

public class BasicUserDTOMethodAccess implements MethodAccessor {
    private static Map<String, BiFunction<UserProfileDTO, String, Object>> getMap = new HashMap<>(1280);
    private static Map<String, BiConsumer<UserProfileDTO, Object>> setMap = new HashMap<>();

    static {
        getMap.put("getUserName", (o, s) -> o.getUserName());
        setMap.put("setUserName", (o, arg) -> o.setUserName((String) arg));
    }

    public Object get(Object o, String methodName) {
        UserProfileDTO basicUserDTO = (UserProfileDTO) o;
        return getMap.get(methodName).apply(basicUserDTO, methodName);
    }

    public void set(Object o, String methodName, Object arg) {
        UserProfileDTO basicUserDTO = (UserProfileDTO) o;

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
            //basicUserDTO.setStatus((java.lang.String) arg);
        }

        if (methodName.equalsIgnoreCase("setCreateTime") || methodName.equalsIgnoreCase("createTime")) {
            basicUserDTO.setGmtCreate((java.lang.Long) arg);
        }

        if (methodName.equalsIgnoreCase("setActivateTime") || methodName.equalsIgnoreCase("activateTime")) {
            basicUserDTO.setActivateTime((java.lang.Long) arg);
        }

        if (methodName.equalsIgnoreCase("setAvatar") || methodName.equalsIgnoreCase("avatar")) {
            basicUserDTO.setAvatar((java.lang.String) arg);
        }

        if (methodName.equalsIgnoreCase("setGender") || methodName.equalsIgnoreCase("gender")) {
            basicUserDTO.setGender((Integer) arg);
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


        if (methodName.equalsIgnoreCase("setUserId") || methodName.equalsIgnoreCase("userId")) {
            basicUserDTO.setUserId((java.lang.Long) arg);
        }

        if (methodName.equalsIgnoreCase("setIp") || methodName.equalsIgnoreCase("ip")) {
            basicUserDTO.setIp((Long) arg);
        }


        if (methodName.equalsIgnoreCase("setEmail") || methodName.equalsIgnoreCase("email")) {
            basicUserDTO.setEmail((java.lang.String) arg);
        }
    }
}
