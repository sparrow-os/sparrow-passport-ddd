package com.sparrow.spring.reflect;

import com.sparrow.cg.MethodAccessor;

public class BasicUserDTOMethodAccess implements MethodAccessor {
    public Object get(Object o, String methodName) {
        com.sparrow.passport.protocol.dto.BasicUserDTO basicUserDTO = (com.sparrow.passport.protocol.dto.BasicUserDTO) o;
        if (methodName.equalsIgnoreCase("getnickname") || methodName.equalsIgnoreCase("nickname")) {
            return basicUserDTO.getNickName();
        }
        if (methodName.equalsIgnoreCase("getgender") || methodName.equalsIgnoreCase("gender")) {
            return basicUserDTO.getGender();
        }
        if (methodName.equalsIgnoreCase("getavatar") || methodName.equalsIgnoreCase("avatar")) {
            return basicUserDTO.getAvatar();
        }
        if (methodName.equalsIgnoreCase("getpersonalsignature") || methodName.equalsIgnoreCase("personalsignature")) {
            return basicUserDTO.getPersonalSignature();
        }
        if (methodName.equalsIgnoreCase("getbirthday") || methodName.equalsIgnoreCase("birthday")) {
            return basicUserDTO.getBirthday();
        }
        if (methodName.equalsIgnoreCase("getactivatetime") || methodName.equalsIgnoreCase("activatetime")) {
            return basicUserDTO.getActivateTime();
        }
        if (methodName.equalsIgnoreCase("getdeviceid") || methodName.equalsIgnoreCase("deviceid")) {
            return basicUserDTO.getDeviceId();
        }
        if (methodName.equalsIgnoreCase("getupdatetime") || methodName.equalsIgnoreCase("updatetime")) {
            return basicUserDTO.getUpdateTime();
        }
        if (methodName.equalsIgnoreCase("getuserid") || methodName.equalsIgnoreCase("userid")) {
            return basicUserDTO.getUserId();
        }
        if (methodName.equalsIgnoreCase("getonline") || methodName.equalsIgnoreCase("online")) {
            return basicUserDTO.getOnline();
        }

        if (methodName.equalsIgnoreCase("getactivate") || methodName.equalsIgnoreCase("activate")) {
            return basicUserDTO.getActivate();
        }

        if (methodName.equalsIgnoreCase("getmobile") || methodName.equalsIgnoreCase("mobile")) {
            return basicUserDTO.getMobile();
        }

        if (methodName.equalsIgnoreCase("getlastlogintime") || methodName.equalsIgnoreCase("lastlogintime")) {
            return basicUserDTO.getLastLoginTime();
        }

        if (methodName.equalsIgnoreCase("getstatus") || methodName.equalsIgnoreCase("status")) {
            return basicUserDTO.getStatus();
        }

        if (methodName.equalsIgnoreCase("getdevice") || methodName.equalsIgnoreCase("device")) {
            return basicUserDTO.getDevice();
        }

        if (methodName.equalsIgnoreCase("getdevicemodel") || methodName.equalsIgnoreCase("devicemodel")) {
            return basicUserDTO.getDeviceModel();
        }

        if (methodName.equalsIgnoreCase("getcreatetime") || methodName.equalsIgnoreCase("createtime")) {
            return basicUserDTO.getCreateTime();
        }

        if (methodName.equalsIgnoreCase("getip") || methodName.equalsIgnoreCase("ip")) {
            return basicUserDTO.getIp();
        }

        if (methodName.equalsIgnoreCase("getcent") || methodName.equalsIgnoreCase("cent")) {
            return basicUserDTO.getCent();
        }

        if (methodName.equalsIgnoreCase("getemail") || methodName.equalsIgnoreCase("email")) {
            return basicUserDTO.getEmail();
        }

        if (methodName.equalsIgnoreCase("getzone") || methodName.equalsIgnoreCase("zone")) {
            return basicUserDTO.getZone();
        }

        if (methodName.equalsIgnoreCase("getusername") || methodName.equalsIgnoreCase("username")) {
            return basicUserDTO.getUserName();
        }
        return null;
    }

    public void set(Object o, String methodName, Object arg) {
        com.sparrow.passport.protocol.dto.BasicUserDTO basicUserDTO = (com.sparrow.passport.protocol.dto.BasicUserDTO) o;
        if (methodName.equalsIgnoreCase("setUserName") || methodName.equalsIgnoreCase("userName")) {
            basicUserDTO.setUserName((java.lang.String) arg);
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