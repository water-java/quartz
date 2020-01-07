package com.hsl.quartz02;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@MapperScan("com.hsl.quartz02.mapper")
@EnableTransactionManagement
@EnableScheduling
@SpringBootApplication
public class Quartz02Application {

    public static void main(String[] args) {
        SpringApplication.run(Quartz02Application.class, args);
    }

}
