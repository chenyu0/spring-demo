package com.yolo.controller;

import com.yolo.entities.SysUser;
import com.yolo.models.ResponseMessage;
import com.yolo.models.base.MessageModel;
import com.yolo.service.SysUserService;
import com.yolo.utils.LogUtil;
import com.yolo.utils.ParamUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("controller/SysUserController")
public class SysUserController extends BaseController {

    @Resource
    private SysUserService sysUserService;


    @ResponseBody
    @RequestMapping("add")
    public MessageModel add(SysUser sysUser) {
        return sysUserService.add(sysUser);
    }

    @ResponseBody
    @RequestMapping("listAll")
    public MessageModel listAll() {
        return sysUserService.listAll();
    }

    @RequestMapping("login")
    public String login(RedirectAttributes model){
        String username = this.getParam("username");
        String password = this.getParam("password");
        String rememberMe = this.getParam("rememberMe");

        MessageModel login = sysUserService.login(username, password, rememberMe);
        if (ParamUtil.isNullOrEmpty(login.getObj())){
            model.addFlashAttribute("message",((ResponseMessage)login).toMessage());
            return "redirect:/login";
        }else{
            Subject subject = SecurityUtils.getSubject();
            SysUser sysUser = (SysUser) subject.getPrincipal();

            this.getSession().setAttribute("user",sysUser);
            this.getSession().setAttribute("userId",sysUser.getId());
            return "redirect:/";
        }


    }

    @ResponseBody
    @RequestMapping("register")
    public MessageModel register(SysUser sysUser){

        return sysUserService.register(sysUser);
    }

}
