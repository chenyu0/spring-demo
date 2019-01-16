package com.yolo.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 * User: wzyin
 * Date: 2019/1/16
 * Time: 13:53
 */


@Component
public class MybatisConfig {

    /**
     * 把 mybatis plus 的分页插件加载到ioc容器中
     * @return
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
