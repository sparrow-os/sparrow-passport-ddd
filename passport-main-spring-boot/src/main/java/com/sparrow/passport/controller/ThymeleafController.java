package com.sparrow.passport.controller;

import com.sparrow.passport.po.User;

import javax.servlet.http.HttpServletRequest;

import com.sparrow.spring.starter.DefaultController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.thymeleaf.ThymeleafProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class ThymeleafController
        //extends DefaultController
{
    @Autowired
    private ThymeleafProperties thymeleafProperties;
    @RequestMapping("thymeleaf")
    public ModelAndView thymeleaf(HttpServletRequest request) {
        User user = new User();
        user.setUserId(10000L);
        request.setAttribute("user", user);
        return new ModelAndView("thymeleaf-test");
    }
}
