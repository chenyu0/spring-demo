package com.yolo.service;

import com.yolo.entities.SysTask;
import com.yolo.models.base.MessageModel;

import java.util.Map;


public interface SysTaskService {

    MessageModel add(SysTask sysTask,String userId);

    MessageModel listAll();

    MessageModel excuteSQL(Map params);
}
