package com.sparrow.passport.config;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
@Import(PassportAutoConfiguration.class)
public @interface EnablePassport {
}
