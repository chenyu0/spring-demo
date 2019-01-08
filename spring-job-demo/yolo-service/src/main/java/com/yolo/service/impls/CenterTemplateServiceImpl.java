package com.yolo.service.impls;

import com.yolo.models.ResponseMessage;
import com.yolo.utils.LogUtil;
import org.springframework.stereotype.Service;

import com.yolo.entities.examples.CenterTemplate;
import com.yolo.models.base.MessageModel;
import com.yolo.service.CenterTemplateService;
import com.yolo.service.bizs.CenterTemplateBiz;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CenterTemplateServiceImpl implements CenterTemplateService {

    @Resource
    private CenterTemplateBiz centerTemplateBiz;


    @Override
    public MessageModel add(CenterTemplate centerTemplate,String userId) {
        ResponseMessage response = new ResponseMessage();
        try{
            centerTemplateBiz.add(centerTemplate,userId);
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
            List<CenterTemplate> centerTemplates= centerTemplateBiz.listAll();
            response.setSuccess(true).setMessage("查询成功").setObj(centerTemplates);
        }catch (Exception e){
            response.setSuccess(false).setMessage("查询失败："+e.getMessage());
            LogUtil.error("查询失败："+e.getMessage());
            e.printStackTrace();
        }
        return response;
    }
}
