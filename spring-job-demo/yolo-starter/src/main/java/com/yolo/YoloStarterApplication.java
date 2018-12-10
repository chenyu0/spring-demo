package com.yolo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.yolo")
@MapperScan("com.yolo.mapper")
public class YoloStarterApplication {

    public static void main(String[] args) {
        SpringApplication.run(YoloStarterApplication.class, args);
    }
}
