package com.yolo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yolo.entities.SysRoleAuthority;
import com.yolo.entities.examples.SysRoleAuthorityExample;
import java.util.List;

public interface SysRoleAuthorityMapper extends BaseMapper {
    List<SysRoleAuthority> selectByExample(SysRoleAuthorityExample example);
}