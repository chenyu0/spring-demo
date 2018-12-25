package com.yolo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yolo.entities.SysUserRole;
import com.yolo.entities.examples.SysUserRoleExample;
import java.util.List;

public interface SysUserRoleMapper extends BaseMapper {
    List<SysUserRole> selectByExample(SysUserRoleExample example);
}