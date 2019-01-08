package com.yolo.service;

import com.yolo.entities.CenterSql;
import com.yolo.models.base.MessageModel;


public interface CenterSqlService {

    MessageModel add(CenterSql centerSql,String userId);

    MessageModel listAll();
}
