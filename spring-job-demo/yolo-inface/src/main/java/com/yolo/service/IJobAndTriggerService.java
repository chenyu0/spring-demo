package com.yolo.service;

import com.github.pagehelper.PageInfo;
import com.yolo.entities.JobAndTrigger;

/**
 * Created by IntelliJ IDEA.
 * User: wzyin
 * Date: 2018/12/13
 * Time: 15:40
 */


public interface IJobAndTriggerService {
    PageInfo<JobAndTrigger> getJobAndTriggerDetails(int pageNum, int pageSize);
}
