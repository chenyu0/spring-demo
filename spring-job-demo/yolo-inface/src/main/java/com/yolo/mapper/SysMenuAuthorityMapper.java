package com.yolo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yolo.entities.SysMenuAuthority;
import com.yolo.entities.examples.SysMenuAuthorityExample;
import java.util.List;

public interface SysMenuAuthorityMapper extends BaseMapper {
    List<SysMenuAuthority> selectByExample(SysMenuAuthorityExample example);
}