package com.yolo.controller;

import com.yolo.utils.ParamUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.yolo.entities.CenterSql;
import com.yolo.models.base.MessageModel;

import javax.annotation.Resource;

import com.yolo.service.CenterSqlService;

import java.util.Map;


@RestController
@RequestMapping("controller/CenterSqlController")
public class CenterSqlController extends BaseController {

    @Resource
    private CenterSqlService centerSqlService;


    @RequestMapping("add")
    public MessageModel add(CenterSql centerSql) {
        String userId = this.currentLoginUser().getId();
        return centerSqlService.add(centerSql, userId);
    }

    @RequestMapping("listAll")
    public MessageModel listAll() {
        return centerSqlService.listAll();
    }

    @RequestMapping("listSQL")
    public MessageModel listSQL() {

        String templateId = this.getParam("templateId");
        Integer pageSize = Integer.valueOf(ParamUtil.isNullOrEmpty(this.getParam("pageSize")) ? "5" : this.getParam("pageSize"));
        Integer pageIndex = Integer.valueOf(ParamUtil.isNullOrEmpty(this.getParam("pageIndex")) ? "0" : this.getParam("pageIndex"));
        return centerSqlService.listSQL(templateId, pageSize, pageIndex);
    }

    @RequestMapping("excuteSQL")
    public MessageModel excuteSQL() {
        Map paramsMap = this.getParamsMap();

        return centerSqlService.excuteSQL(paramsMap);
    }

}
