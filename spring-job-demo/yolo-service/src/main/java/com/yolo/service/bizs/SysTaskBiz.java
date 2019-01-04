package com.yolo.service.bizs;

import com.yolo.entities.SysTask;
import com.yolo.mapper.SysTaskMapper;
import com.yolo.models.ParamException;
import com.yolo.models.adapters.AdapterBiz;
import com.yolo.utils.FtlUtil;
import com.yolo.utils.IdUtil;
import com.yolo.utils.ParamUtil;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository
public class SysTaskBiz extends AdapterBiz {

    @Resource
    private SysTaskMapper sysTaskMapper;


    public Integer add(SysTask sysTask,String userId) {
        sysTask.setId(IdUtil.uuid());
        sysTask.setTaskCode(IdUtil.longId());
        sysTask.setCreateUser(userId);
        sysTask.setCreateTime(new Date());
        sysTask.setUpdateUser(userId);
        sysTask.setUpdateTime(new Date());
        return sysTaskMapper.insert(sysTask);
    }

    public List<SysTask> listAll() {
        return sysTaskMapper.selectList(null);

    }
    public List excuteSql(Map params){
        Object id = params.get("id");
        if (ParamUtil.isNullOrEmpty(id)){
            throw new ParamException("id 参数不可为空");
        }
        SysTask task = sysTaskMapper.selectById(String.valueOf(id));

        String sql = FtlUtil.parse(task.getTaskSql(), params);
        params.put("sql",sql);
        return sysTaskMapper.excuteSQL(params);
    }
}
