package com.yolo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.yolo.entities.SysAuthority;
import com.yolo.models.base.MessageModel;
import javax.annotation.Resource;

import com.yolo.service.SysAuthorityService;


@RestController
@RequestMapping("controller/SysAuthorityController")
public class SysAuthorityController extends BaseController {

    @Resource
    private SysAuthorityService sysAuthorityService;


    @RequestMapping("add")
    public MessageModel add(SysAuthority sysAuthority) {
        return sysAuthorityService.add(sysAuthority);
    }

    @RequestMapping("listAll")
    public MessageModel listAll() {
        return sysAuthorityService.listAll();
    }
}
