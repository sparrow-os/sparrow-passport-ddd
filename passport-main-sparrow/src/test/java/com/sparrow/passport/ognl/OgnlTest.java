package com.sparrow.passport.ognl;

import com.sparrow.passport.po.User;
import ognl.Ognl;
import ognl.OgnlContext;
import ognl.OgnlException;

public class OgnlTest {
    public static void main(String[] args) throws OgnlException {
        /* OGNL提供的一个上下文类，它实现了Map接口*/
        OgnlContext context = new OgnlContext();

        User people1 = new User();
        people1.setUserName("user-1");

        User people2 = new User();
        people2.setUserName("user-2");

        User people3 = new User();
        people3.setUserName("user-3");

        context.put("people1", people1);
        context.put("people2", people2);
        context.put("people3", people3);

        context.setRoot(people1);

        /* 调用 成员方法*/
        Object userName = Ognl.getValue("#people2?#people2.userName:''", context, context.getRoot());
        System.out.println("people1 userName is :" + userName);


        /* 调用 成员方法*/
        Object value = Ognl.getValue("userName.length()", context, context.getRoot());
        System.out.println("people1 userName length is :" + value);

        Object upperCase = Ognl.getValue("#people2.userName.toUpperCase()", context, context.getRoot());
        System.out.println("people2 userName upperCase is :" + upperCase);

        Object invokeWithArgs = Ognl.getValue("userName.charAt(5)", context, context.getRoot());
        System.out.println("people1 userName.charAt(5) is :" + invokeWithArgs);

        /* 调用静态方法*/
        Object min = Ognl.getValue("@java.lang.Math@min(4,10)", context, context.getRoot());
        System.out.println("min(4,10) is :" + min);

        /* 调用静态变量*/
        Object e = Ognl.getValue("@java.lang.Math@E", context, context.getRoot());
        System.out.println("E is :" + e);
    }
}
