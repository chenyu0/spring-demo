package com.yolo.config;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: wzyin
 * Date: 2019/5/21
 * Time: 17:03
 */


public class MultipleDataSourceContextHolder {
    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();
    public static List<String> dataSourceNames = new ArrayList<>(10);

    public static void setDataSourceName(String dataSourceName) {
        contextHolder.set(dataSourceName);
    }

    public static String getDataSourceName() {
        return contextHolder.get();
    }

    public static void resetDataSourceName() {
        contextHolder.remove();
    }

    public static boolean containsDataSource(String dataSourceName) {
        return dataSourceNames.contains(dataSourceName);
    }
}
