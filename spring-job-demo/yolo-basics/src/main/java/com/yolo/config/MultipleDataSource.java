package com.yolo.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * Created by IntelliJ IDEA.
 * User: wzyin
 * Date: 2019/5/21
 * Time: 17:03
 */


public class MultipleDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return MultipleDataSourceContextHolder.getDataSourceName();
    }

}

