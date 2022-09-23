package com.sparrow.spring.reflect;

import com.sparrow.passport.protocol.dto.BasicUserDTO;

public class Test2 {
    public static void main(String[] args) {

        BasicUserDTOMethodAccess user = new BasicUserDTOMethodAccess();
        long t = System.currentTimeMillis();
        BasicUserDTO basicUser=new BasicUserDTO();
        user.set(basicUser, "setUserName", "zhangsan");
        for (int i = 0; i < 10000000; i++) {
            //user.getUserName();
            user.get(basicUser, "userName");
        }
        System.out.println(System.currentTimeMillis() - t);
    }
}
