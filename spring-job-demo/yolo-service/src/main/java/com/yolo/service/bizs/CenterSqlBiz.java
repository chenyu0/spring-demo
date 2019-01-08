package com.yolo.service.bizs;

import org.springframework.stereotype.Repository;

import com.yolo.models.adapters.AdapterBiz;
import com.yolo.utils.IdUtil;
import com.yolo.entities.CenterSql;
import com.yolo.mapper.CenterSqlMapper;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class CenterSqlBiz extends AdapterBiz {

    @Resource
    private CenterSqlMapper centerSqlMapper;


    public Integer add(CenterSql centerSql,String userId) {
        centerSql.setId(IdUtil.longId());
        return centerSqlMapper.insert(centerSql);
    }

    public List<CenterSql> listAll() {
        return centerSqlMapper.selectList(null);
    }
}
