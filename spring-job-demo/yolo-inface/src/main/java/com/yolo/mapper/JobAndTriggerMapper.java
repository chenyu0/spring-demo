package com.yolo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yolo.entities.JobAndTrigger;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface JobAndTriggerMapper extends BaseMapper<JobAndTrigger> {
    List<JobAndTrigger> getJobAndTriggerDetails();

}
