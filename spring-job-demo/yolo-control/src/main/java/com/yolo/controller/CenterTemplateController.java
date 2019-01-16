package com.yolo.controller;

import com.yolo.utils.ParamUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.yolo.entities.examples.CenterTemplate;
import com.yolo.models.base.MessageModel;

import javax.annotation.Resource;

import com.yolo.service.CenterTemplateService;


@RestController
@RequestMapping("controller/CenterTemplateController")
public class CenterTemplateController extends BaseController {

    @Resource
    private CenterTemplateService centerTemplateService;


    @RequestMapping("add")
    public MessageModel add(CenterTemplate centerTemplate) {
        String userId = this.currentLoginUser().getId();
        return centerTemplateService.add(centerTemplate, userId);
    }

    @RequestMapping("listAll")
    public MessageModel listAll() {
        return centerTemplateService.listAll();
    }

    @RequestMapping("listByCenter")
    public MessageModel listByCenter() {
        String centerId = this.getParam("centerId");
        Integer pageSize = Integer.valueOf(ParamUtil.isNullOrEmpty(this.getParam("pageSize")) ? "5" : this.getParam("pageSize"));
        Integer pageIndex = Integer.valueOf(ParamUtil.isNullOrEmpty(this.getParam("pageIndex")) ? "0" : this.getParam("pageIndex"));
        return centerTemplateService.listByCenter(centerId, pageSize, pageIndex);
    }
}
