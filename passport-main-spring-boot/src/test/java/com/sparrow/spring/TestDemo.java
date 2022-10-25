package com.sparrow.spring;

import com.sparrow.passport.boot.Application;
import com.sparrow.passport.dao.UserDAO;
import com.sparrow.passport.po.SecurityPrincipal;
import com.sparrow.spring.container.SparrowTestExecutionListener;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
@TestExecutionListeners(listeners = {SparrowTestExecutionListener.class, DependencyInjectionTestExecutionListener.class })
public class TestDemo {
    @Autowired
    private UserDAO userDao;
    @Test
    public void testUserDao() {
        SecurityPrincipal securityPrincipal = new SecurityPrincipal();
        securityPrincipal.setUserId(32L);
        securityPrincipal.setPassword("111111");
        userDao.save(securityPrincipal);
    }
}
