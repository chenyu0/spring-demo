package com.yolo.service;

import com.yolo.entities.SysAuthority;
import com.yolo.models.base.MessageModel;


public interface SysAuthorityService {

    MessageModel add(SysAuthority sysAuthority);

    MessageModel listAll();
}
