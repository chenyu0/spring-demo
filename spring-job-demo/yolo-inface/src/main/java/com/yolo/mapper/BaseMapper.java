package com.yolo.mapper;

import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: wzyin
 * Date: 2019/1/3
 * Time: 17:29
 */


public interface BaseMapper<T> extends com.baomidou.mybatisplus.core.mapper.BaseMapper<T> {

    List excuteSQL(Map params);

}
