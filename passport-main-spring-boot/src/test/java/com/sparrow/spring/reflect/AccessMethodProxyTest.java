package com.sparrow.spring.reflect;

import com.sparrow.passport.protocol.dto.BasicUserDTO;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AccessMethodProxyTest {
    public static void main(
        String[] args) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, InterruptedException {
        BasicUserDTOMethodAccess basicUserMethodAccess = new BasicUserDTOMethodAccess();
        BasicUserDTO basicUser = new BasicUserDTO();
        basicUser.setUserName("zhangsan");
        Thread.sleep(2000);
        long t = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            basicUserMethodAccess.set(basicUser, "setZone", "i");
        }
        System.out.println("access cost sparrow set " + (System.currentTimeMillis() - t));
        t = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            basicUserMethodAccess.get(basicUser, "getUserName");
        }
        System.out.println("access cost sparrow hash get " + (System.currentTimeMillis() - t));

        t = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            basicUser.setUserName("lisi");
            basicUser.getUserName();
        }
        System.out.println("origin jdk cost:" + (System.currentTimeMillis() - t));
        t = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            Method method = BasicUserDTO.class.getMethod("setUserName", String.class);
            method.invoke(basicUser, "zhang san");
        }
        System.out.println("reflect cost time " + (System.currentTimeMillis() - t));
    }
}
