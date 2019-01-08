package com.yolo.mapper;

import com.yolo.entities.SysCenter;
import com.yolo.entities.examples.SysCenterExample;

import java.util.List;

public interface SysCenterMapper extends BasicMapper<SysCenter> {
    List<SysCenter> selectByExample(SysCenterExample example);
}