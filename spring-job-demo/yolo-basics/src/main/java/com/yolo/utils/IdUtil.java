package com.yolo.utils;

import java.util.Random;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * User: wzyin
 * Date: 2018/12/21
 * Time: 17:51
 */


public class IdUtil {

    public static String uuid() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public static Long longId() {
        return Math.abs(new Random().nextLong());
    }

}
