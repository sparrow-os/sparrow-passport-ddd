package com.sparrow.passport.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DefaultController {
    @GetMapping("/*")
    public ModelAndView all(HttpServletRequest request) {
        return new ModelAndView(request.getServletPath());
    }
}