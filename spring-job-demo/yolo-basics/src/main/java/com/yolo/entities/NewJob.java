package com.yolo.entities;

import com.yolo.models.base.BaseJob;
import com.yolo.utils.LogUtil;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: wzyin
 * Date: 2018/12/13
 * Time: 15:37
 */


public class NewJob implements BaseJob {

    public NewJob() {

    }

    @Override
    public void execute(JobExecutionContext context) {
        LogUtil.error("New Job执行时间: " + new Date());

    }
}
