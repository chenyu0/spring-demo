package com.yolo.service.bizs;

import org.springframework.stereotype.Repository;

import com.yolo.models.adapters.AdapterBiz;

import com.yolo.entities.${table_name};
import com.yolo.models.base.MessageModel;
import com.yolo.models.ResponseMessage;
import com.yolo.mapper.${table_name}Mapper;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class ${table_name}Biz extends AdapterBiz {

    @Resource
    private ${table_name}Mapper ${table_name?uncap_first}Mapper;


    public MessageModel add(${table_name} ${table_name?uncap_first}) {
        ResponseMessage response = new ResponseMessage();

        int insert = ${table_name?uncap_first}Mapper.insert(${table_name?uncap_first});

        if (insert > 0) {
            response.setMessage("插入失败！");
        } else {
            response.setMessage("插入成功！");
        }
        return response.setSuccess(true);
    }

    public MessageModel listAll() {
        ResponseMessage response = new ResponseMessage();
        List select = ${table_name?uncap_first}Mapper.selectList(null);
        return response.setSuccess(true).setObj(select).toMessage();
    }
}
