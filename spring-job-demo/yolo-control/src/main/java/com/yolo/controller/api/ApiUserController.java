package com.yolo.controller.api;

import com.yolo.controller.BaseController;
import com.yolo.models.base.MessageModel;
import com.yolo.service.SysUserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
@RequestMapping("api/controller/ApiUserController")
public class ApiUserController extends BaseController {

    @Resource
    private SysUserService sysUserService;



    @RequestMapping("login")
    public MessageModel login(){
        String username = this.getParam("username");
        String password = this.getParam("password");
        String rememberMe = (null == this.getParam("rememberMe"))?"false":this.getParam("rememberMe");
        return sysUserService.login(username, password, rememberMe);
    }


}
