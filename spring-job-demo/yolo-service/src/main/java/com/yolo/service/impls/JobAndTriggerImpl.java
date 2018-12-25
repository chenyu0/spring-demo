package com.yolo.service.impls;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yolo.entities.JobAndTrigger;
import com.yolo.mapper.JobAndTriggerMapper;
import com.yolo.service.IJobAndTriggerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: wzyin
 * Date: 2018/12/13
 * Time: 15:41
 */


@Service
public class JobAndTriggerImpl implements IJobAndTriggerService {

    @Resource
    private JobAndTriggerMapper jobAndTriggerMapper;

    public PageInfo<JobAndTrigger> getJobAndTriggerDetails(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<JobAndTrigger> list = jobAndTriggerMapper.getJobAndTriggerDetails();
        PageInfo<JobAndTrigger> page = new PageInfo<>(list);
        return page;
    }

}
