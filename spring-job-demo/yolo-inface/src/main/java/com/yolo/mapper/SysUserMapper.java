package com.yolo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yolo.entities.SysUser;
import com.yolo.entities.examples.SysUserExample;

import java.util.List;

public interface SysUserMapper extends BaseMapper<SysUser> {

    List<SysUser> selectByExample(SysUserExample example);
}