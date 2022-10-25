package com.sparrow.spring.reflect;

import com.sparrow.cg.MethodAccessor;
import com.sparrow.container.Container;
import com.sparrow.container.ContainerBuilder;
import com.sparrow.core.spi.ApplicationContext;
import com.sparrow.passport.po.User;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Reflect2Test {
    public static void main(
        String[] args){

        Container container = ApplicationContext.getContainer();
        ContainerBuilder builder = new ContainerBuilder()
            .scanBasePackage("com.sparrow")
            .initController(false)
            .initSingletonBean(false)
            .initInterceptor(false);
        container.init(builder);
        User user = new User();
        user.setUserName("zhangsan");
        MethodAccessor methodAccessor = container.getProxyBean(User.class);
        long t = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            methodAccessor.set(user, "zone","zhangsan"+i);
            //System.out.println(userName);
//            Method method = User.class.getMethod("setUserName", String.class);
//            method.invoke(user, "zhansan");
            //System.out.println(user.getUserName());
        }
        System.out.println(System.currentTimeMillis() - t);
    }
}
