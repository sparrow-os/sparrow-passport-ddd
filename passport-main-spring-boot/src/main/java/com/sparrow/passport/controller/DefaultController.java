package com.sparrow.passport.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DefaultController {
    /**
     * SpringMVC映射的 / 与 /* 与 /** 的区别
     * <p>
     * /* 是所有文件夹，不含子文件夹
     * <p>
     * ** 的意思是所有文件夹及里面的子文件夹
     */
    @GetMapping("/**")
    public ModelAndView all(HttpServletRequest request) {
        return new ModelAndView(request.getServletPath());
    }
    @GetMapping("/password/find")
    public ModelAndView passwordFind(HttpServletRequest request) {
        return new ModelAndView(request.getServletPath());
    }
}