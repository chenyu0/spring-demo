package com.yolo.aop;

import com.yolo.annotations.TargetDataSource;
import com.yolo.config.MultipleDataSourceContextHolder;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 * User: wzyin
 * Date: 2019/5/21
 * Time: 14:30
 */


@Aspect
@Component
@Order(65568)
public class MultipleDataSourceAspect {
    private Logger logger = LoggerFactory.getLogger(MultipleDataSourceAspect.class);

    @Around("@annotation(dataSource)")
    public Object processed(ProceedingJoinPoint point, TargetDataSource dataSource) throws Throwable {
        try {
            logger.info("current " + dataSource.name() + " datasource");
            String dataSourceName = dataSource.name();
            if (MultipleDataSourceContextHolder.containsDataSource(dataSourceName)) {
                MultipleDataSourceContextHolder.setDataSourceName(dataSourceName);
            }
            return point.proceed();
        } finally {
            logger.info("reset datasource");
            MultipleDataSourceContextHolder.resetDataSourceName();
        }

    }
}
