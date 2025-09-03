package com.sparrow.passport.boot;

import com.sparrow.file.config.EnableFileWebMvc;
import com.sparrow.passport.config.EnablePassport;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnablePassport
@EnableFileWebMvc
public class Config {
}
