package com.yolo.service.bizs;

import org.springframework.stereotype.Repository;

import com.yolo.models.adapters.AdapterBiz;

import com.yolo.entities.${table_name};
import com.yolo.mapper.${table_name}Mapper;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class ${table_name}Biz extends AdapterBiz {

    @Resource
    private ${table_name}Mapper ${table_name?uncap_first}Mapper;


    public Integer add(${table_name} ${table_name?uncap_first}) {
        return ${table_name?uncap_first}Mapper.insert(${table_name?uncap_first});
    }

    public List<${table_name}> listAll() {
        return ${table_name?uncap_first}Mapper.selectList(null);
    }
}
