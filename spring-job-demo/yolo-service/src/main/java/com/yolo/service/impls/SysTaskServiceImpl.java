package com.yolo.service.impls;

import com.yolo.models.ResponseMessage;
import com.yolo.utils.LogUtil;
import org.springframework.stereotype.Service;

import com.yolo.entities.SysTask;
import com.yolo.models.base.MessageModel;
import com.yolo.service.SysTaskService;
import com.yolo.service.bizs.SysTaskBiz;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class SysTaskServiceImpl implements SysTaskService {

    @Resource
    private SysTaskBiz sysTaskBiz;


    @Override
    public MessageModel add(SysTask sysTask,String userId) {
        ResponseMessage response = new ResponseMessage();
        try{
            sysTaskBiz.add(sysTask,userId);
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
            List<SysTask> sysTasks= sysTaskBiz.listAll();
            response.setSuccess(true).setMessage("查询成功").setObj(sysTasks);
        }catch (Exception e){
            LogUtil.error("查询失败："+e.getMessage());
            response.setSuccess(false).setMessage("查询失败："+e.getMessage());
        }
        return response;
    }

    @Override
    public MessageModel excuteSQL(Map map) {
        ResponseMessage response = new ResponseMessage();
        try{
            response.setSuccess(true).setMessage("查询成功").setObj(sysTaskBiz.excuteSql(map));
        }catch (Exception e){
            LogUtil.error("查询失败："+e.getMessage());
            response.setSuccess(false).setMessage("查询失败："+e.getMessage());
        }
        return response;
    }
}
