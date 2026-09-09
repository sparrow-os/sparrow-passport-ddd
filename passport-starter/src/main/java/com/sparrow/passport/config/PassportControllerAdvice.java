package com.sparrow.passport.config;


import com.sparrow.spring.mvc.ControllerReturnAdvice;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(basePackages = {"com.sparrow.passport.controller"})
public class PassportControllerAdvice extends ControllerReturnAdvice {
}
