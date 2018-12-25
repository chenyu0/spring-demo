package com.yolo.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MarkerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: wzyin
 * Date: 2018/12/21
 * Time: 17:01
 */


public class LogUtil {
    private static final Map<Object, Logger> logger = new HashMap();
    public static final String frameName = "frame";
    public static final String logName = "log";

    public LogUtil() {
    }

    public static void debug(Object name, String message) {
        getLogger(name).debug(MarkerFactory.getMarker("DEBUG"), message);
    }

    public static void debug(Object name, String message, Throwable throwable) {
        getLogger(name).debug(MarkerFactory.getMarker("DEBUG"), message, throwable);
    }

    public static void info(String message) {
        getLogger(LogUtil.class).info(message);
    }

    public static void error(String message) {
        getLogger(LogUtil.class).error(message);
    }

    public static Logger getLogger(Object name) {
        if (name instanceof Class) {
            Class clazz = (Class) name;
            String className = clazz.getName();
            if (className.contains(".")) {
                name = className.substring(0, className.indexOf("."));
            }
        } else {
            if (!(name instanceof String)) {
                return getLogger(name.getClass());
            }

            String className = (String) name;
            if (className.contains(".")) {
                name = className.substring(0, className.indexOf("."));
            }
        }

        if (!logger.containsKey(name)) {
            if (name instanceof Class) {
                logger.put(name, LoggerFactory.getLogger((Class) name));
            } else {
                logger.put(name, LoggerFactory.getLogger((String) name));
            }
        }

        return logger.get(name);
    }
}
