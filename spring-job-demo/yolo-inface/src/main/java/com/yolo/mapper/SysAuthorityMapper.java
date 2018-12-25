package com.yolo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yolo.entities.SysAuthority;
import com.yolo.entities.examples.SysAuthorityExample;

import java.util.List;

public interface SysAuthorityMapper extends BaseMapper<SysAuthority> {
    List<SysAuthority> selectByExample(SysAuthorityExample example);
}