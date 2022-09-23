package com.sparrow.spring.reflect;

import com.sparrow.passport.po.User;

public class ReflectTest {
    public static void main(String[] args) {
        User user = new User();
        long t = System.currentTimeMillis();
        user.setUserName("zhangsan");
        for (int i = 0; i < 10000000; i++) {
            //user.getUserName();
            get(user, "userName");
        }
        System.out.println(System.currentTimeMillis() - t);
    }

    private static Object get(User user, String field) {
        if ("userName".equalsIgnoreCase(field)) {
            return user.getUserName();
        }
        if ("userId".equalsIgnoreCase(field)) {
            return user.getUserId();
        }
        return null;
    }
}
