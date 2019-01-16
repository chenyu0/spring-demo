package com.yolo.controller;

import com.yolo.entities.SysCenter;
import com.yolo.entities.SysUser;
import com.yolo.models.base.MessageModel;
import com.yolo.service.SysCenterService;
import com.yolo.utils.ParamUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
@RequestMapping("controller/SysCenterController")
public class SysCenterController extends BaseController {

    @Resource
    private SysCenterService sysCenterService;


    @RequestMapping("add")
    public MessageModel add(SysCenter sysCenter) {
        SysUser sysUser = this.currentLoginUser();
        String userId = sysUser.getId();

        return sysCenterService.add(sysCenter,userId);
    }

    @RequestMapping("listAll")
    public MessageModel listAll() {
        return sysCenterService.listAll();
    }

    @ResponseBody
    @RequestMapping("listPage")
    public MessageModel listPage() {
        int pageSize = Integer.parseInt(this.getParam("rows"));
        int pageIndex = Integer.parseInt(this.getParam("page"));
        return sysCenterService.listPage(pageSize,pageIndex);
    }
}
