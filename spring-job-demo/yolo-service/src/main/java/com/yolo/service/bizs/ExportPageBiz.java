package com.yolo.service.bizs;

import com.yolo.mapper.CenterSqlMapper;
import com.yolo.models.ParamException;
import com.yolo.models.adapters.AdapterBiz;
import com.yolo.utils.ParamUtil;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: wzyin
 * Date: 2019/1/31
 * Time: 14:15
 */

@Repository
public class ExportPageBiz  extends AdapterBiz {

    @Resource
    private CenterSqlMapper centerSqlMapper;

    public String resolve2Page(Map paramsMap) {

        String taskCode = String.valueOf(paramsMap.get("taskCode"));
        String centerCode = String.valueOf(paramsMap.get("centerCode"));
        String centerTemplate = String.valueOf(paramsMap.get("centerTemplate"));

        Object templateId = paramsMap.get("templateId");
        if (ParamUtil.isNullOrEmpty(templateId)){
            throw new ParamException("参数 模板Id 不可为空");
        }




        return "";
    }
}
