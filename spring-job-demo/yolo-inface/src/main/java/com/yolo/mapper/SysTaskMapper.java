package com.yolo.mapper;

import com.yolo.entities.SysTask;
import com.yolo.entities.examples.SysTaskExample;

import java.util.List;

public interface SysTaskMapper extends BaseMapper<SysTask> {
    List<SysTask> selectByExampleWithBLOBs(SysTaskExample example);

    List<SysTask> selectByExample(SysTaskExample example);
}