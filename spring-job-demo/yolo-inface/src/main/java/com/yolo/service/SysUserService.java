package com.yolo.service;

import com.yolo.entities.SysUser;
import com.yolo.models.base.MessageModel;


public interface SysUserService {

    MessageModel add(SysUser sysUser);

    MessageModel listAll();

    MessageModel login(String username, String password, String rememberMe);

    MessageModel register(SysUser sysUser);

}
