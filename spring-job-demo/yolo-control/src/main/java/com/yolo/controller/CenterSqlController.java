package com.yolo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.yolo.entities.CenterSql;
import com.yolo.models.base.MessageModel;
import javax.annotation.Resource;

import com.yolo.service.CenterSqlService;


@RestController
@RequestMapping("controller/CenterSqlController")
public class CenterSqlController extends BaseController {

    @Resource
    private CenterSqlService centerSqlService;


    @RequestMapping("add")
    public MessageModel add(CenterSql centerSql) {
        String userId = this.getParam("userId");
        return centerSqlService.add(centerSql,userId);
    }

    @RequestMapping("listAll")
    public MessageModel listAll() {
        return centerSqlService.listAll();
    }
}
