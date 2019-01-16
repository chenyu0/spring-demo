package com.yolo.service.bizs;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yolo.entities.CenterSql;
import com.yolo.mapper.CenterSqlMapper;
import com.yolo.models.ExcuteException;
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
public class CenterSqlBiz extends AdapterBiz {

    @Resource
    private CenterSqlMapper centerSqlMapper;


    public Integer add(CenterSql centerSql, String userId) {

        centerSql.setCreateTime(new Date());
        centerSql.setCreateUser(userId);
        centerSql.setUpdateTime(new Date());
        centerSql.setUpdateUser(userId);
        centerSql.setId(IdUtil.longId());
        return centerSqlMapper.insert(centerSql);
    }

    public List<CenterSql> listAll() {
        return centerSqlMapper.selectList(null);
    }

    public IPage<CenterSql> listSQL(String templateId, Integer pageSize, Integer pageIndex) {

        if (ParamUtil.isNullOrEmpty(templateId)) {
            throw new ParamException("模板Id不可为空！");
        }

        IPage page = new Page(pageIndex, pageSize);
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("template_id", templateId);
        return centerSqlMapper.selectPage(page, null);
    }

    public List excuteSQL(Map params) {
        Object id = params.get("id");
        if (ParamUtil.isNullOrEmpty(id)) {
            throw new ParamException("id 参数不可为空");
        }
        CenterSql centerSql = centerSqlMapper.selectById(String.valueOf(id));

        String sql = FtlUtil.parse(centerSql.getSqlContent(), params);
        params.put("sql", sql);
        return centerSqlMapper.excuteSQL(params);
    }

    public List excuteSQL(String centerId, String templateIndex, String sqlCode, Map params) {

        if (ParamUtil.isNullOrEmpty(centerId) || ParamUtil.isNullOrEmpty(templateIndex) || ParamUtil.isNullOrEmpty(sqlCode)) {
            throw new ParamException("参数不可为空");
        }
        Integer index = Integer.valueOf(templateIndex);
        CenterSql centerSql = centerSqlMapper.selectSQLByKey(centerId, index, sqlCode);
        if (ParamUtil.isNullOrEmpty(centerId)) {
            throw new ExcuteException("此SQL不存在");
        }

        String sql = FtlUtil.parse(centerSql.getSqlContent(), params);
        params.put("sql", sql);
        return centerSqlMapper.excuteSQL(params);
    }

}
