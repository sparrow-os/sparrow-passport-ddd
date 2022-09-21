package com.sparrow.spring.reflect;

import com.sparrow.passport.po.User;

public class ReflectTest {
    public static void main(String[] args) {
        User user=new User();
        long t=System.currentTimeMillis();
        for(int i=0;i<10000000;i++) {
            user.setUserName("zhangsan");
            user.getUserName();
        }
        System.out.println(System.currentTimeMillis()-t);
    }
}
