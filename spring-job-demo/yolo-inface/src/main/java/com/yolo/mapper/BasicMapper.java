package com.yolo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: wzyin
 * Date: 2019/1/3
 * Time: 17:29
 */


public interface BasicMapper<T> extends BaseMapper<T> {

    List excuteSQL(Map params);

}
