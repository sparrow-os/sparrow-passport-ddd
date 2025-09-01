package com.sparrow.passport.boot;

import com.sparrow.file.config.EnableFileWebMvc;
import com.sparrow.passport.config.EnablePassportWebMvc;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnablePassportWebMvc
@EnableFileWebMvc
public class Config {
}
