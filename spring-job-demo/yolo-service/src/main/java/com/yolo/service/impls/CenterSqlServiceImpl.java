package com.yolo.service.impls;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yolo.models.ResponseMessage;
import com.yolo.utils.LogUtil;
import org.springframework.stereotype.Service;

import com.yolo.entities.CenterSql;
import com.yolo.models.base.MessageModel;
import com.yolo.service.CenterSqlService;
import com.yolo.service.bizs.CenterSqlBiz;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class CenterSqlServiceImpl implements CenterSqlService {

    @Resource
    private CenterSqlBiz centerSqlBiz;


    @Override
    public MessageModel add(CenterSql centerSql, String userId) {
        ResponseMessage response = new ResponseMessage();
        try {
            centerSqlBiz.add(centerSql, userId);
            response.setSuccess(true).setMessage("添加成功");
        } catch (Exception e) {
            response.setSuccess(false).setMessage("添加失败：" + e.getMessage());
            LogUtil.error("添加失败：" + e.getMessage());
            e.printStackTrace();
        }
        return response;
    }

    @Override
    public MessageModel listAll() {
        ResponseMessage response = new ResponseMessage();
        try {
            List<CenterSql> centerSqls = centerSqlBiz.listAll();
            response.setSuccess(true).setMessage("查询成功").setObj(centerSqls);
        } catch (Exception e) {
            response.setSuccess(false).setMessage("查询失败：" + e.getMessage());
            LogUtil.error("查询失败：" + e.getMessage());
            e.printStackTrace();
        }
        return response;
    }

    @Override
    public MessageModel listSQL(String templateId, Integer pageSize, Integer pageIndex) {
        ResponseMessage response = new ResponseMessage();
        try {
            IPage<CenterSql> centerSqls = centerSqlBiz.listSQL(templateId, pageSize, pageIndex);
            response.setSuccess(true).setMessage("查询成功").setObj(centerSqls);
        } catch (Exception e) {
            response.setSuccess(false).setMessage("查询失败：" + e.getMessage());
            LogUtil.error("查询失败：" + e.getMessage());
            e.printStackTrace();
        }
        return response;
    }

    @Override
    public MessageModel excuteSQL(Map paramsMap) {
        ResponseMessage response = new ResponseMessage();
        try {
            response.setSuccess(true).setMessage("执行成功").setObj(centerSqlBiz.excuteSQL(paramsMap));
        } catch (Exception e) {
            response.setSuccess(false).setMessage("执行失败：" + e.getMessage());
            LogUtil.error("执行失败：" + e.getMessage());
            e.printStackTrace();
        }
        return response;
    }
}
