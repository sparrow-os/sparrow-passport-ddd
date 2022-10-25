package com.sparrow.passport.mybatis;

import com.sparrow.passport.mybatis.mapper.User;
import com.sparrow.passport.mybatis.mapper.UserMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.sparrow.passport.mybatis"})
public class SampleMybatisPlusApplication implements CommandLineRunner {
  private final UserMapper userMapper;
  public SampleMybatisPlusApplication(UserMapper userMapper) {
    this.userMapper = userMapper;
  }
  public static void main(String[] args) {
    SpringApplication.run(SampleMybatisPlusApplication.class, args);
  }
  @Override
  public void run(String... args) {
    User user=this.userMapper.selectById(32L);
    System.out.println(user.getUserName());
  }
}