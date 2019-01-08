package com.yolo.service.impls;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yolo.models.ResponseMessage;
import com.yolo.utils.LogUtil;
import org.springframework.stereotype.Service;

import com.yolo.entities.SysCenter;
import com.yolo.models.base.MessageModel;
import com.yolo.service.SysCenterService;
import com.yolo.service.bizs.SysCenterBiz;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SysCenterServiceImpl implements SysCenterService {

    @Resource
    private SysCenterBiz sysCenterBiz;


    @Override
    public MessageModel add(SysCenter sysCenter,String userId) {
        ResponseMessage response = new ResponseMessage();
        try{
            sysCenterBiz.add(sysCenter,userId);
            response.setSuccess(true).setMessage("添加成功");
        }catch (Exception e){
            LogUtil.error("添加失败："+e.getMessage());
            response.setSuccess(false).setMessage("添加失败："+e.getMessage());
            e.printStackTrace();
        }
        return response;
    }

    @Override
    public MessageModel listAll() {
        ResponseMessage response = new ResponseMessage();
        try{
            List<SysCenter> sysCenters= sysCenterBiz.listAll();
            response.setSuccess(true).setMessage("查询成功").setObj(sysCenters);
        }catch (Exception e){
            LogUtil.error("查询失败："+e.getMessage());
            response.setSuccess(false).setMessage("查询失败："+e.getMessage());
            e.printStackTrace();
        }
        return response;
    }

    @Override
    public MessageModel listPage(int pageSize, int pageIndex) {
        ResponseMessage response = new ResponseMessage();
        try{
            IPage<SysCenter> sysCenters= sysCenterBiz.listPage(pageIndex,pageSize);
            response.setSuccess(true).setMessage("查询成功").setObj(sysCenters);
        }catch (Exception e){
            LogUtil.error("查询失败："+e.getMessage());
            response.setSuccess(false).setMessage("查询失败："+e.getMessage());
            e.printStackTrace();
        }
        return response;
    }
}
