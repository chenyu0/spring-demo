package com.yolo.controller;

import com.yolo.models.ParamException;
import com.yolo.utils.ParamUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.yolo.entities.SysMenu;
import com.yolo.models.base.MessageModel;
import javax.annotation.Resource;

import com.yolo.service.SysMenuService;


@RestController
@RequestMapping("controller/SysMenuController")
public class SysMenuController extends BaseController {

    @Resource
    private SysMenuService sysMenuService;


    @RequestMapping("add")
    public MessageModel add(SysMenu sysMenu) {
        return sysMenuService.add(sysMenu);
    }

    @RequestMapping("listAll")
    public MessageModel listAll() {
        return sysMenuService.listAll();
    }

    @RequestMapping("listMenus")
    public MessageModel listMenus(){
        String userId = this.getParam("userId");
        if (ParamUtil.isNullOrEmpty(userId)){
            throw new ParamException(-1,"用户Id参数不可为空");
        }
        return sysMenuService.listMenus(userId);
    }
}
