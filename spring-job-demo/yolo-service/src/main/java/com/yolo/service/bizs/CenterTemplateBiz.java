package com.yolo.service.bizs;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yolo.models.ParamException;
import com.yolo.utils.ParamUtil;
import org.springframework.stereotype.Repository;

import com.yolo.models.adapters.AdapterBiz;
import com.yolo.utils.IdUtil;
import com.yolo.entities.examples.CenterTemplate;
import com.yolo.mapper.CenterTemplateMapper;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Repository
public class CenterTemplateBiz extends AdapterBiz {

    @Resource
    private CenterTemplateMapper centerTemplateMapper;


    public Integer add(CenterTemplate centerTemplate,String userId) {
        if (ParamUtil.isNullOrEmpty(centerTemplate) || ParamUtil.isNullOrEmpty(centerTemplate.getCenterId())
                || ParamUtil.isNullOrEmpty(centerTemplate.getTemplateCode())
                || ParamUtil.isNullOrEmpty(centerTemplate.getTemplateIndex())
                || ParamUtil.isNullOrEmpty(centerTemplate.getTemplateName())){
            throw new ParamException("参数不可为空");
        }
        centerTemplate.setId(IdUtil.uuid());
        centerTemplate.setCreateTime(new Date());
        centerTemplate.setUpdateTime(new Date());
        centerTemplate.setCreateUser(userId);
        centerTemplate.setUpdateUser(userId);
        return centerTemplateMapper.insert(centerTemplate);
    }

    public List<CenterTemplate> listAll() {
        return centerTemplateMapper.selectList(null);
    }
    public IPage<CenterTemplate> listByCenter(String centerId,Integer pageSize,Integer pageIndex) {
        if (ParamUtil.isNullOrEmpty(centerId)){
            throw new ParamException("调度center的id为空");
        }
        QueryWrapper wrapper  = new QueryWrapper();
        wrapper.eq("center_id",centerId);
        IPage page = new Page(pageIndex,pageSize);
        return centerTemplateMapper.selectPage(page,wrapper);
    }
}
