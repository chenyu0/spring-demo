package com.yolo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yolo.entities.SysFile;
import com.yolo.entities.examples.SysFileExample;
import java.util.List;

public interface SysFileMapper extends BaseMapper<SysFile> {
    List<SysFile> selectByExample(SysFileExample example);
}