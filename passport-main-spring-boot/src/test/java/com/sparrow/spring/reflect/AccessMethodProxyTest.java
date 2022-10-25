package com.sparrow.spring.reflect;

import com.sparrow.passport.protocol.dto.BasicUserDTO;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class AccessMethodProxyTest {
    public static void main(
        String[] args) throws IllegalAccessException, InterruptedException, NoSuchFieldException {
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
            basicUser.setUserName("lisi"+i);
//            basicUser.getUserName();
        }
        System.out.println("origin jdk cost:" + (System.currentTimeMillis() - t));
        Field field = BasicUserDTO.class.getDeclaredField("userName");

        t = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            field.setAccessible(true);
            field.set(basicUser,"zhangsan"+i);
            //method.invoke(basicUser, "zhang san"+i);
        }
        System.out.println("reflect cost time " + (System.currentTimeMillis() - t));
    }
}
