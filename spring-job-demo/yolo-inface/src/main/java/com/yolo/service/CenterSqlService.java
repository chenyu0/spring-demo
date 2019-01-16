package com.yolo.service;

import com.yolo.entities.CenterSql;
import com.yolo.models.base.MessageModel;

import java.util.Map;


public interface CenterSqlService {

    MessageModel add(CenterSql centerSql,String userId);

    MessageModel listAll();

    MessageModel listSQL(String templateId, Integer pageSize, Integer pageIndex);

    MessageModel excuteSQL(Map paramsMap);
}
