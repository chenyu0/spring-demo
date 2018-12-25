package com.yolo.service.impls;

import com.yolo.entities.SysUser;
import com.yolo.models.ResponseMessage;
import com.yolo.models.base.MessageModel;
import com.yolo.service.SysUserService;
import com.yolo.service.bizs.SysUserBiz;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Resource
    private SysUserBiz sysUserBiz;


    @Override
    public MessageModel add(SysUser sysUser) {
        return sysUserBiz.add(sysUser);
    }

    @Override
    public MessageModel listAll() {
        return sysUserBiz.listAll();
    }

    @Override
    public MessageModel login(String username, String password, String rememberMe) {
        ResponseMessage response = new ResponseMessage();
        try {
            SysUser sysUser = sysUserBiz.login(username, password, rememberMe);
            response.setSuccess(true).setMessage("登录成功").setObj(sysUser);
        }catch (Exception e){
            response.setError(e.getMessage());
            response.setSuccess(false);
            response.setMessage("登录失败："+e.getMessage());
            e.printStackTrace();
        }

        return response;
    }

    @Override
    public MessageModel register(SysUser sysUser) {
        ResponseMessage response = new ResponseMessage();
        try {
            SysUser user = sysUserBiz.register(sysUser);
            response.setSuccess(true);
            response.setMessage("注册成功").setObj(user);
        }catch (Exception e){
            response.setError(e.getMessage());
            response.setSuccess(false);
            response.setMessage("注册失败："+e.getMessage());
            e.printStackTrace();
        }

        return response;
    }

}
