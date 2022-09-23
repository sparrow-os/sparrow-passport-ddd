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
        String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        Container container = ApplicationContext.getContainer();
        ContainerBuilder builder = new ContainerBuilder()
            .scanBasePackage("com.sparrow")
            .initController(false)
            .initSingletonBean(false)
            .initInterceptor(false);
        container.init(builder);
        long t = System.currentTimeMillis();
        User user = new User();
        user.setUserName("zhangsan");
//        MethodAccessor methodAccessor = container.getProxyBean(User.class);

        for (int i = 0; i < 10000000; i++) {
            //Object userName = methodAccessor.get(user, "userName");
            //System.out.println(userName);
            Method method = User.class.getMethod("setUserName", String.class);
            method.invoke(user, "zhansan");
            //System.out.println(user.getUserName());
        }
        System.out.println(System.currentTimeMillis() - t);
    }
}
