package com.yolo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.yolo.entities.${table_name};
import com.yolo.models.base.MessageModel;
import javax.annotation.Resource;

import com.yolo.service.${table_name}Service;


@RestController
@RequestMapping("controller/${table_name}Controller")
public class ${table_name}Controller extends BaseController {

    @Resource
    private ${table_name}Service ${table_name?uncap_first}Service;


    @RequestMapping("add")
    public MessageModel add(${table_name} ${table_name?uncap_first}) {
        String userId = this.currentLoginUser().getId();
        return ${table_name?uncap_first}Service.add(${table_name?uncap_first},userId);
    }

    @RequestMapping("listAll")
    public MessageModel listAll() {
        return ${table_name?uncap_first}Service.listAll();
    }
}
