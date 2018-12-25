package com.yolo.service.impls;

import com.yolo.models.ResponseMessage;
import com.yolo.utils.LogUtil;
import org.springframework.stereotype.Service;

import com.yolo.entities.SysAuthority;
import com.yolo.models.base.MessageModel;
import com.yolo.service.SysAuthorityService;
import com.yolo.service.bizs.SysAuthorityBiz;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SysAuthorityServiceImpl implements SysAuthorityService {

    @Resource
    private SysAuthorityBiz sysAuthorityBiz;


    @Override
    public MessageModel add(SysAuthority sysAuthority) {
        ResponseMessage response = new ResponseMessage();
        try{
            sysAuthorityBiz.add(sysAuthority);
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
        try{
            List<SysAuthority> sysAuthoritys= sysAuthorityBiz.listAll();
            response.setSuccess(true).setMessage("查询成功").setObj(sysAuthoritys);
        }catch (Exception e){
            LogUtil.error("查询失败："+e.getMessage());
            response.setSuccess(false).setMessage("查询失败："+e.getMessage());
        }
        return response;
    }
}
