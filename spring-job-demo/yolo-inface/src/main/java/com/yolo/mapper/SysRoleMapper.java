package com.yolo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yolo.entities.SysRole;
import com.yolo.entities.examples.SysRoleExample;
import java.util.List;

public interface SysRoleMapper extends BaseMapper {
    List<SysRole> selectByExample(SysRoleExample example);
}