package com.yolo.service;

import com.yolo.entities.${table_name};
import com.yolo.models.base.MessageModel;


public interface ${table_name}Service {

    MessageModel add(${table_name} ${table_name?uncap_first});

    MessageModel listAll();
}
