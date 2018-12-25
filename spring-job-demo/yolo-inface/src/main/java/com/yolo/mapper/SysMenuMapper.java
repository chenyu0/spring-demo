package com.yolo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yolo.entities.SysMenu;
import com.yolo.entities.examples.SysMenuExample;

import java.util.List;

public interface SysMenuMapper extends BaseMapper<SysMenu> {
    List<SysMenu> selectByExample(SysMenuExample example);

    List<SysMenu> selectMenusByUser(String userId);
}