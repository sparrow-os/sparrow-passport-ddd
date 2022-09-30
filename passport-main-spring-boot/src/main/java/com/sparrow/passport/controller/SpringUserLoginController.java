package com.sparrow.passport.controller;

import com.sparrow.cache.exception.CacheNotFoundException;
import com.sparrow.passport.controller.protocol.query.LoginQuery;
import com.sparrow.passport.infrastructure.support.shiro.JwtToken;
import com.sparrow.protocol.BusinessException;
import com.sparrow.protocol.ClientInformation;
import com.sparrow.protocol.LoginToken;
import javax.servlet.http.HttpServletRequest;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/")
public class SpringUserLoginController {


    @Autowired
    private UserLoginController userLoginController;

    @GetMapping("/session-id")
    public String sessionId(HttpServletRequest request) throws BusinessException {
        return request.getSession().getId();
    }

    @PostMapping("/login")
    public LoginToken login(@RequestBody LoginQuery login,ClientInformation client) throws BusinessException, CacheNotFoundException {
        try {
            //使用shiro 编写认证操作
            JwtToken token = new JwtToken(login.getUserName(),login.getPassword());
            //拿到subject
            Subject subject = SecurityUtils.getSubject();
            // 执行登陆方法
            subject.login(token);
            // 执行到这里说明用户已登录成功
            return new LoginToken();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        //return this.userLoginController.login(login, client);
    }

    public LoginToken shortcut(LoginQuery login, ClientInformation client) throws BusinessException {
        return this.userLoginController.shortcut(login, client);
    }

    public void logout() {
        this.userLoginController.logout();
    }
}
