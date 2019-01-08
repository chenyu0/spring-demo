package com.yolo.service.impls;

import com.yolo.models.ResponseMessage;
import com.yolo.utils.LogUtil;
import org.springframework.stereotype.Service;

import com.yolo.entities.${table_name};
import com.yolo.models.base.MessageModel;
import com.yolo.service.${table_name}Service;
import com.yolo.service.bizs.${table_name}Biz;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ${table_name}ServiceImpl implements ${table_name}Service {

    @Resource
    private ${table_name}Biz ${table_name?uncap_first}Biz;


    @Override
    public MessageModel add(${table_name} ${table_name?uncap_first},String userId) {
        ResponseMessage response = new ResponseMessage();
        try{
            ${table_name?uncap_first}Biz.add(${table_name?uncap_first},userId);
            response.setSuccess(true).setMessage("添加成功");
        }catch (Exception e){
            response.setSuccess(false).setMessage("添加失败："+e.getMessage());
            LogUtil.error("添加失败："+e.getMessage());
            e.printStackTrace();
        }
        return response;
    }

    @Override
    public MessageModel listAll() {
        ResponseMessage response = new ResponseMessage();
        try{
            List<${table_name}> ${table_name?uncap_first}s= ${table_name?uncap_first}Biz.listAll();
            response.setSuccess(true).setMessage("查询成功").setObj(${table_name?uncap_first}s);
        }catch (Exception e){
            response.setSuccess(false).setMessage("查询失败："+e.getMessage());
            LogUtil.error("查询失败："+e.getMessage());
            e.printStackTrace();
        }
        return response;
    }
}
