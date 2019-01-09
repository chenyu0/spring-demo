package com.yolo.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by IntelliJ IDEA.
 * User: wzyin
 * Date: 2019/1/9
 * Time: 10:34
 */


@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("/");
        registry.addViewController("/index.html").setViewName("/");
        registry.addViewController("/index.ftl").setViewName("/");
    }

}
