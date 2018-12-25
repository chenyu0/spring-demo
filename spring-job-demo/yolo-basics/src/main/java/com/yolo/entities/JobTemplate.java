package com.yolo.entities;

import com.yolo.models.base.BaseJob;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * Created by IntelliJ IDEA.
 * User: wzyin
 * Date: 2018/12/24
 * Time: 15:29
 */


public class JobTemplate implements BaseJob {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {

    }
}
