package com.yolo.service.bizs;

import org.springframework.stereotype.Repository;

import com.yolo.models.adapters.AdapterBiz;
import com.yolo.utils.IdUtil;
import com.yolo.entities.examples.CenterTemplate;
import com.yolo.mapper.CenterTemplateMapper;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class CenterTemplateBiz extends AdapterBiz {

    @Resource
    private CenterTemplateMapper centerTemplateMapper;


    public Integer add(CenterTemplate centerTemplate,String userId) {
        centerTemplate.setId(IdUtil.uuid());
        return centerTemplateMapper.insert(centerTemplate);
    }

    public List<CenterTemplate> listAll() {
        return centerTemplateMapper.selectList(null);
    }
}
