package com.yolo.service.impls;

import com.yolo.models.ResponseMessage;
import com.yolo.utils.LogUtil;
import org.springframework.stereotype.Service;

import com.yolo.entities.SysMenu;
import com.yolo.models.base.MessageModel;
import com.yolo.service.SysMenuService;
import com.yolo.service.bizs.SysMenuBiz;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SysMenuServiceImpl implements SysMenuService {

    @Resource
    private SysMenuBiz sysMenuBiz;


    @Override
    public MessageModel add(SysMenu sysMenu) {
        ResponseMessage response = new ResponseMessage();
        try {
            sysMenuBiz.add(sysMenu);
            response.setSuccess(true).setMessage("添加成功");
        }catch (Exception e){
            LogUtil.error("添加失败："+e.getMessage());
            response.setSuccess(false).setMessage("添加失败："+e.getMessage());
        }

        return response;
    }

    @Override
    public MessageModel listAll() {
        ResponseMessage response = new ResponseMessage();
        try {
            List<SysMenu> sysMenus = sysMenuBiz.listAll();
            response.setSuccess(true).setMessage("查询成功").setObj(sysMenus);
        }catch (Exception e){
            LogUtil.error("查询失败："+e.getMessage());
            response.setSuccess(false).setMessage("查询失败："+e.getMessage());
        }
        return response;
    }

    @Override
    public MessageModel listMenus(String userId) {
        ResponseMessage response = new ResponseMessage<>();
        try {
            List<SysMenu> menus =  sysMenuBiz.listMenus(userId);
            response.setSuccess(true).setObj(menus);

        }catch (Exception e){
            response.setSuccess(false).setMessage("查询失败："+e.getMessage());
            e.printStackTrace();
        }
        return response;
    }
}
