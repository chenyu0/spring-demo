package com.yolo.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.yolo.entities.DataSourceProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: wzyin
 * Date: 2019/5/21
 * Time: 17:02
 */

@Configuration
@ConfigurationProperties(prefix = "job")
public class DataSourceConfig {
    private Logger logger = LoggerFactory.getLogger("frame");

    private Map<String, DataSourceProperty> dataSources;

    @Bean
    public DataSource dataSource() {
        Object defaultDataSource = null;
        Map<Object, Object> targetDataSources = new HashMap<>();
        for (String name : dataSources.keySet()) {
            try {
                DataSourceProperty property = dataSources.get(name);
                Class<DruidDataSource> dataSourceType =
                        (Class<DruidDataSource>) Class.forName(property.getType());
                DruidDataSource datasource =
                        DataSourceBuilder.create().driverClassName(property.getDriverClassName())
                                .url(property.getUrl()).username(property.getUsername())
                                .password(property.getPassword()).type(dataSourceType).build();


                datasource.setDefaultReadOnly(property.getReadOnly());
                if (name.equals("default")) {
                    defaultDataSource = datasource;
                } else {
                    targetDataSources.put(name, datasource);
                    MultipleDataSourceContextHolder.dataSourceNames.add(name);
                }
            } catch (ClassNotFoundException e) {
                logger.error("please check datasources config!!!");
                System.exit(1);
            }
        }
        MultipleDataSource multipleDataSource = new MultipleDataSource();
        multipleDataSource.setTargetDataSources(targetDataSources);
        multipleDataSource.setDefaultTargetDataSource(defaultDataSource);
        return multipleDataSource;

    }

    @Bean
    @Order(65569)
    public DataSourceTransactionManager transactionManager(DataSource dataSource) {
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource);
        return dataSourceTransactionManager;
    }

    public Map<String, DataSourceProperty> getDataSources() {
        return dataSources;
    }

    public void setDataSources(Map<String, DataSourceProperty> dataSources) {
        this.dataSources = dataSources;
    }
}
