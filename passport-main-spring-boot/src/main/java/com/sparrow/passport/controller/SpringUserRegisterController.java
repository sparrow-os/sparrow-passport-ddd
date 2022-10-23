package com.sparrow.passport.controller;

import com.sparrow.cache.exception.CacheNotFoundException;
import com.sparrow.constant.User;
import com.sparrow.passport.controller.protocol.query.LoginQuery;
import com.sparrow.passport.protocol.param.register.EmailActivateParam;
import com.sparrow.passport.protocol.param.register.EmailRegisterParam;
import com.sparrow.protocol.BusinessException;
import com.sparrow.protocol.ClientInformation;
import com.sparrow.protocol.LoginToken;
import com.sparrow.protocol.Result;
import com.sparrow.protocol.constant.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/register")
public class SpringUserRegisterController {

    @Autowired
    private UserRegisterController userRegisterController;

    @PostMapping("/email/shortcut")
    public LoginToken shortcut(@RequestBody EmailRegisterParam user,
        ClientInformation client) throws BusinessException {
        return userRegisterController.shortcut(user, client);
    }

    @PostMapping("/email.do")
    public ModelAndView emailRegister(@RequestBody EmailRegisterParam user,
        ClientInformation client) throws BusinessException, CacheNotFoundException {
        this.userRegisterController.emailRegister(user, client);
        ModelAndView mv=new ModelAndView("redirect:/")
    }

    @PostMapping("/email/activate/send")
    public ModelAndView emailActivate(EmailActivateParam user,
        ClientInformation client) throws BusinessException {
        this.userRegisterController.sendTokenToEmail(user, client);
        return new ModelAndView("redirect:/email-activate-success");
    }
}
