package com.yolo.annotations;

import java.lang.annotation.*;

/**
 * Created by IntelliJ IDEA.
 * User: wzyin
 * Date: 2019/5/21
 * Time: 17:05
 */


@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TargetDataSource {
    String name();
}
