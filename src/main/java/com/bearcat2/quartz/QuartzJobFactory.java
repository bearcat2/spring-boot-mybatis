package com.bearcat2.quartz;

import com.bearcat2.entity.system.SysJob;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * <p> Description: quartz 任务创建工厂 </p>
 * <p> Title: QuartzJobFactory </p>
 * <p> Create Time: 2019/7/13 21:40 </p>
 *
 * @author zhongzhipeng
 * @see org.quartz.Job
 * @see QuartzUtil
 * @since 1.0
 */
public class QuartzJobFactory implements Job {

    /** 任务key */
    public static final String JOB_DATA_MAP_KEY = "JOB_DATA_MAP_KEY";

    public void execute(JobExecutionContext context) throws JobExecutionException {
        SysJob scheduleJob = (SysJob) context.getMergedJobDataMap().get(JOB_DATA_MAP_KEY);
        QuartzUtil.invokMethod(scheduleJob);
    }
}