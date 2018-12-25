package com.yolo.controller;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by IntelliJ IDEA.
 * User: wzyin
 * Date: 2018/12/24
 * Time: 10:34
 */


@Controller
public class LoginController extends BaseController{

    @RequestMapping("/login")
    public String login(){
        //return "forward:/controller/SysUserController/login";
        return "login";
    }
    @RequestMapping("/unauthority")
    public String unauthority(){
        //return "forward:/controller/SysUserController/login";
        return "403";
    }

    @RequestMapping("/register")
    public String register(){
        return "register";
    }

    @RequestMapping("/logout")
    @ResponseBody
    public String logout(){
        SecurityUtils.getSubject().logout();
        return "登出成功";
    }
}
