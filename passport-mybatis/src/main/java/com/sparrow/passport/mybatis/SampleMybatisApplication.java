package com.sparrow.passport.mybatis;

import com.sparrow.passport.dao.UserDAO;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.sparrow.passport.dao"})
public class SampleMybatisApplication implements CommandLineRunner {

  private final UserDAO userDao;

  public SampleMybatisApplication(UserDAO userDao) {
    this.userDao = userDao;
  }

  public static void main(String[] args) {
    SpringApplication.run(SampleMybatisApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    System.out.println(this.userDao.getEntity(32L));
  }
}