package com.yolo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.yolo.mapper")
@EnableTransactionManagement
public class YoloStarterApplication {

    public static void main(String[] args) {
        SpringApplication.run(YoloStarterApplication.class, args);
    }
}
