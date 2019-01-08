package com.yolo.controller;

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
        String userId = this.getParam("userId");
        return centerTemplateService.add(centerTemplate,userId);
    }

    @RequestMapping("listAll")
    public MessageModel listAll() {
        return centerTemplateService.listAll();
    }
}
