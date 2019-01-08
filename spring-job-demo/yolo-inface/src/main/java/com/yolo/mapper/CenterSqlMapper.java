package com.yolo.mapper;

import com.yolo.entities.CenterSql;
import com.yolo.entities.examples.CenterSqlExample;
import java.util.List;

public interface CenterSqlMapper extends BasicMapper<CenterSql> {
    List<CenterSql> selectByExampleWithBLOBs(CenterSqlExample example);

    List<CenterSql> selectByExample(CenterSqlExample example);
}