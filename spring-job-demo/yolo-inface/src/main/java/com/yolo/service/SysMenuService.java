package com.yolo.service;

import com.yolo.entities.SysMenu;
import com.yolo.models.base.MessageModel;


public interface SysMenuService {

    MessageModel add(SysMenu sysMenu);

    MessageModel listAll();

    MessageModel listMenus(String userId);
}
