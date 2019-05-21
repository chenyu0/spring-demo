package com.yolo;

import com.yolo.config.DataSourceConfig;
import com.yolo.config.ServletConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
@MapperScan("com.yolo.mapper")
@EnableTransactionManagement
@EnableConfigurationProperties(DataSourceConfig.class)
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class YoloStarterApplication {

    public static void main(String[] args) {
        SpringApplication.run(YoloStarterApplication.class, args);
    }
    static {
        ServletConfig.init();
    }
}
