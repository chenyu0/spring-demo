package com.yolo.controller;

import com.yolo.entities.SysMenu;
import com.yolo.models.base.MessageModel;
import com.yolo.service.SysMenuService;
import com.yolo.utils.LogUtil;
import com.yolo.utils.ParamUtil;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.rmi.runtime.Log;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: wzyin
 * Date: 2018/12/24
 * Time: 10:34
 */


@Controller
public class LoginController extends BaseController{

    @Resource
    private SysMenuService sysMenuService;

    @RequestMapping("/signin")
    public String login(){
        this.getRequest().setAttribute("message",this.getParam("message"));
        return "login";
    }
    @RequestMapping("/")
    public String index(){
        if (!SecurityUtils.getSubject().isAuthenticated()){
            LogUtil.error("用户尚未登录，转向登录页面");
            return "redirect:/signin";
        }
        String userId = this.currentLoginUser().getId();
        MessageModel messageModel = sysMenuService.listMenus(userId);
        List<SysMenu> menus  = (List<SysMenu>) messageModel.getObj();
        if (ParamUtil.isNullOrEmpty(menus)){
            LogUtil.error("当前用户:"+userId+"没有可展示菜单的权限");
        }
        Map<String,Object> result = new HashMap<>();
        result.put("menus",menus);
        result.put("user",this.currentLoginUser());
        this.getRequest().setAttribute("response",result);
        LogUtil.info(result.toString());
        return "index";
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
