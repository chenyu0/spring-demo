package com.yolo.service;

import com.yolo.entities.SysCenter;
import com.yolo.models.base.MessageModel;


public interface SysCenterService {

    MessageModel add(SysCenter sysCenter,String userId);

    MessageModel listAll();

    MessageModel listPage(int pageSize, int pageIndex);
}
