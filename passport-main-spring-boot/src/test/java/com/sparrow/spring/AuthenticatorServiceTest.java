package com.sparrow.spring;

import com.sparrow.passport.boot.Application;
import com.sparrow.protocol.BusinessException;
import com.sparrow.protocol.LoginUser;
import com.sparrow.protocol.LoginUserStatus;
import com.sparrow.spring.container.SparrowTestExecutionListener;
import com.sparrow.support.Authenticator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
@TestExecutionListeners(listeners = {SparrowTestExecutionListener.class, DependencyInjectionTestExecutionListener.class})
public class AuthenticatorServiceTest {

    @Autowired
    private Authenticator authenticator;

    @Test
    public void simpleTest() {
        LoginUser loginUser = new LoginUser();
        loginUser.setUserId(1L);
        loginUser.setNickName("nick-name");
        loginUser.setUserName("user-name");
        loginUser.setAvatar("avator");
        loginUser.setDeviceId("device-id");
        loginUser.setDays(1);
        loginUser.setExpireAt(System.currentTimeMillis()+1000*60*60*24);

        LoginUserStatus loginUserStatus = new LoginUserStatus(LoginUserStatus.STATUS_NORMAL, System.currentTimeMillis() + 1000 * 60 * 60 * 24);

        String token = this.authenticator.sign(loginUser, loginUserStatus);
        System.out.println(token);
    }

    @Test
    public void testAuthenticator() throws BusinessException {
        String token="eyJhdmF0YXIiOiJhdmF0b3IiLCJkYXlzIjoxLCJkZXZpY2VJZCI6ImRldmljZS1pZCIsImV4cGlyZUF0IjoxNjgzMjk4MDg2MzYyLCJuaWNrTmFtZSI6Im5pY2stbmFtZSIsInVzZXJJZCI6MSwidXNlck5hbWUiOiJ1c2VyLW5hbWUifQ==.eyROqRpqj5bmmWnA6EHOI52TIH4=";
        authenticator.authenticate(token, "device-id");
    }
}
