package com.yolo.utils;


import org.apache.commons.lang3.StringUtils;

import java.util.Collection;

/**
 * Created by IntelliJ IDEA.
 * User: wzyin
 * Date: 2018/12/21
 * Time: 17:29
 */


public class ParamUtil {
    public static boolean isNullOrEmpty(Object object) {
        if (null == object) {
            return true;
        } else if (object instanceof String) {
            return null == StringUtils.trimToNull((String)object);
        } else {
            return object instanceof Collection && ((Collection) object).size() <= 0;
        }
    }
}
