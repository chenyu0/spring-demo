package com.yolo.controller;

import com.yolo.entities.SysTask;
import com.yolo.models.base.MessageModel;
import com.yolo.service.SysTaskService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;


@RestController
@RequestMapping("controller/SysTaskController")
public class SysTaskController extends BaseController {

    @Resource
    private SysTaskService sysTaskService;


    @RequestMapping("add")
    public MessageModel add(SysTask sysTask) {
        String userId = this.getParam("userId");
        return sysTaskService.add(sysTask, userId);
    }

    @RequestMapping("listAll")
    public MessageModel listAll() {
        return sysTaskService.listAll();
    }

    @RequestMapping("excute")
    public MessageModel excute() {
        Map paramsMap = this.getParamsMap();

        return sysTaskService.excuteSQL(paramsMap);
    }
}
