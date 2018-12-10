package com.yolo.service.impls;

import org.springframework.stereotype.Service;

import com.yolo.entities.${table_name};
import com.yolo.models.base.MessageModel;
import com.yolo.service.${table_name}Service;
import com.yolo.service.bizs.${table_name}Biz;

import javax.annotation.Resource;

@Service
public class ${table_name}ServiceImpl implements ${table_name}Service {

    @Resource
    private ${table_name}Biz ${table_name?uncap_first}Biz;


    @Override
    public MessageModel add(${table_name} ${table_name?uncap_first}) {
        return ${table_name?uncap_first}Biz.add(${table_name?uncap_first});
    }

    @Override
    public MessageModel listAll() {
        return ${table_name?uncap_first}Biz.listAll();
    }
}
