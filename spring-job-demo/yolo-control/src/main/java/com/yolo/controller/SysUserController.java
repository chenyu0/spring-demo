package com.yolo.controller;

import com.yolo.entities.SysUser;
import com.yolo.models.base.MessageModel;
import com.yolo.service.SysUserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
@RequestMapping("controller/SysUserController")
public class SysUserController extends BaseController {

    @Resource
    private SysUserService sysUserService;


    @RequestMapping("add")
    public MessageModel add(SysUser sysUser) {
        return sysUserService.add(sysUser);
    }

    @RequestMapping("listAll")
    public MessageModel listAll() {
        return sysUserService.listAll();
    }

    @RequestMapping("login")
    public MessageModel login(){
        String username = this.getParam("userName");
        String password = this.getParam("password");
        String rememberMe = this.getParam("rememberMe");

        return sysUserService.login(username, password, rememberMe);
    }

    @RequestMapping("register")
    public MessageModel register(SysUser sysUser){

        return sysUserService.register(sysUser);
    }

}
