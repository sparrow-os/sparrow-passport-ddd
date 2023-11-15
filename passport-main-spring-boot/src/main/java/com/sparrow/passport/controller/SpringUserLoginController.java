package com.sparrow.passport.controller;

import com.alibaba.fastjson.JSON;
import com.sparrow.passport.protocol.dto.LoginDTO;
import com.sparrow.passport.protocol.enums.PassportError;
import com.sparrow.passport.protocol.query.login.LoginQuery;
import com.sparrow.protocol.BusinessException;
import com.sparrow.protocol.ClientInformation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@RestController
public class SpringUserLoginController {
    @Autowired
    private UserLoginController userLoginController;

    private static Logger logger = LoggerFactory.getLogger(SpringUserLoginController.class);

    @GetMapping("/session-id")
    public String sessionId(HttpServletRequest request) throws BusinessException {
        return request.getSession().getId();
    }

    //sparrow mvc 模式下 为了与login 区分开
    @PostMapping("/login.do")
    /**
     * @RequestBody DispatcherServlet Completed 415 UNSUPPORTED_MEDIA_TYPE
     */
    public ModelAndView login(LoginQuery login,
                              ClientInformation client) throws BusinessException {
        logger.info("client info {}", JSON.toJSONString(client));
        try {
            LoginDTO loginDto = this.userLoginController.login(login, client);
            ModelAndView mv = new ModelAndView(login.getRedirectUrl());
            mv.addObject(loginDto);
            return mv;
        } catch (BusinessException e) {
            if (e.getErrorSupport().getCode().equals(PassportError.USER_NOT_ACTIVATE.getCode())) {
                ModelAndView mv = new ModelAndView("redirect:/email-activate");
                mv.addObject("email", login.getUserName());
                return mv;
            }
            throw e;
        }
    }

    @PostMapping("/shortcut-login.json")
    public LoginDTO shortcut(LoginQuery login, ClientInformation client) throws BusinessException {
        return this.userLoginController.shortcut(login, client);
    }

    public void logout() {
        this.userLoginController.logout();
    }
}
