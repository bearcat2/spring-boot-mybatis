package com.bearcat2.service.impl.system;

import cn.hutool.core.util.StrUtil;
import com.bearcat2.entity.common.CustomException;
import com.bearcat2.entity.common.LayuiResult;
import com.bearcat2.entity.system.SysJob;
import com.bearcat2.enumeration.JobStatusEnum;
import com.bearcat2.mapper.system.SysJobMapper;
import com.bearcat2.quartz.QuartzJobFactory;
import com.bearcat2.service.system.SysJobService;
import com.bearcat2.util.ApplicationContextUtil;
import com.bearcat2.util.CommonUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;

/**
 * <p> Description: 系统任务service 接口实现类 </p>
 * <p> Title: SysJobServiceImpl </p>
 * <p> Create Time: 2019/7/13 22:13 </p>
 * 参见：https://juejin.im/entry/592e938e0ce4630057a868de
 * 在线corn表达式生成器：http://cron.qqe2.com/
 *
 * @author: zhongzhipeng
 * @version: 1.0
 */
@Service
@Transactional(readOnly = true)
public class SysJobServiceImpl implements SysJobService {

    @Autowired
    private SysJobMapper sysJobMapper;

    @Autowired
    private SchedulerFactoryBean schedulerFactoryBean;

    @Override
    public LayuiResult list(SysJob sysJob) {
        Example example = new Example(SysJob.class);
        // 动态条件查询
        Example.Criteria criteria = example.createCriteria();
        if (StrUtil.isNotBlank(sysJob.getSjName())) {
            criteria.andLike(SysJob.SJ_NAME, CommonUtil.buildLikeQueryParam(sysJob.getSjName()));
        }
        if (StrUtil.isNotBlank(sysJob.getSjGroup())) {
            criteria.andLike(SysJob.SJ_GROUP, CommonUtil.buildLikeQueryParam(sysJob.getSjGroup()));
        }
        if (sysJob.getSjStatus() != null) {
            criteria.andEqualTo(SysJob.SJ_STATUS, sysJob.getSjStatus());
        }
        // 以更新时间降序
        example.orderBy(SysJob.SJ_UPDATE_TIME).desc();
        PageHelper.startPage(sysJob.getPage(), sysJob.getLimit());
        List<SysJob> sysJobs = this.sysJobMapper.selectByExample(example);
        PageInfo<SysJob> pageInfo = new PageInfo<>(sysJobs);
        return LayuiResult.success(pageInfo.getList(), pageInfo.getTotal());
    }

    @Override
    public SysJob findById(Integer id) {
        return this.sysJobMapper.selectByPrimaryKey(id);
    }

    @Transactional
    @Override
    public int insert(SysJob sysJob) {
        // 像quartz中添加任务,并执行
        addQuartzJob(sysJob);

        // 向数据库添加任务记录
        sysJob.setSjCreateTime(new Date());
        sysJob.setSjUpdateTime(new Date());
        return this.sysJobMapper.insertSelective(sysJob);
    }

    @Transactional
    @Override
    public int update(SysJob sysJob) {
        // 更新任务的cron表达式
        updateCornExpressionById(sysJob.getSjId(), sysJob.getSjCronExpression());

        sysJob.setSjUpdateTime(new Date());
        return this.sysJobMapper.updateByPrimaryKeySelective(sysJob);
    }

    @Transactional
    @Override
    public int updataStatusById(Integer id, Integer status) {
        // 1. 验证前端传递的状态值是否合法
        JobStatusEnum jobStatusEnum = JobStatusEnum.findByStatus(status);
        if (jobStatusEnum == null) {
            throw new CustomException(StrUtil.format("任务状态值 {} 不合法", status));
        }

        // 2. 根据id查询出任务详情
        SysJob sysJob = this.findById(id);
        if (status.equals(sysJob.getSjStatus())) {
            // 状态没有发生变化直接返回
            return 0;
        }

        // 3. 根据不同的任务状态处理任务
        this.handleJobByStatus(jobStatusEnum, sysJob);

        // 4. 修改数据库对应的状态
        sysJob.setSjStatus(status);
        return this.update(sysJob);
    }

    @Override
    public void updateCornExpressionById(Integer id, String cornExpression) {
        // 1.校验用户传递过来的corn表达式是否正确
        verifyCornExpression(cornExpression);

        // 2. 根据id查询出任务详情
        SysJob sysJob = this.findById(id);

        if (cornExpression.equals(sysJob.getSjCronExpression())) {
            // corn 表达式没有改变直接返回
            return;
        }
        // 3. 更新quartz cron 表达式
        sysJob.setSjCronExpression(cornExpression);
        this.updateQuartzJobCronExpression(sysJob);
    }

    @Override
    public void initSystemJob() {
        // 从数据库中获取所有正在运行状态的任务,添加到系统中
        Example example = new Example(SysJob.class);
        example.createCriteria()
                .andEqualTo(SysJob.SJ_STATUS, JobStatusEnum.RUNNING_STATUS.getStatus());
        List<SysJob> sysJobs = this.sysJobMapper.selectByExample(example);
        for (SysJob sysJob : sysJobs) {
            this.addQuartzJob(sysJob);
        }
    }

    /**
     * 根据任务状态处理任务
     *
     * @param jobStatusEnum 任务状态枚举类
     * @param sysJob        系统任务对象
     */
    private void handleJobByStatus(JobStatusEnum jobStatusEnum, SysJob sysJob) {
        try {
            // 注意避免用户任务暂停时修改了任务的corn表达式,这里的暂停运行不做暂停恢复处理,暂停直接移除旧的,运行添加新的
            switch (jobStatusEnum) {
                case STOP_STATUS:
                    JobKey jobKey = JobKey.jobKey(sysJob.getSjName(), sysJob.getSjGroup());
                    this.getScheduler().deleteJob(jobKey);
                    break;

                case RUNNING_STATUS:
                    addQuartzJob(sysJob);
                    break;
            }
        } catch (Exception e) {
            throw new CustomException("quartz 任务处理失败", e);
        }
    }

    /**
     * 获取调度器对象
     *
     * @return Scheduler - 调度器对象
     */
    private Scheduler getScheduler() {
        return this.schedulerFactoryBean.getScheduler();
    }

    /**
     * 添加quartz 任务
     *
     * @param sysJob 系统任务对象
     */
    private void addQuartzJob(SysJob sysJob) {
        verifyTargetClassAndMethodIsSuccess(sysJob);
        verifyCornExpression(sysJob.getSjCronExpression());
        try {
            Scheduler scheduler = this.getScheduler();
            TriggerKey triggerKey = TriggerKey.triggerKey(sysJob.getSjName(), sysJob.getSjGroup());
            CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
            if (null == trigger) {
                // 不存在，创建一个新任务
                JobDetail jobDetail = JobBuilder.newJob(QuartzJobFactory.class)
                        .withIdentity(sysJob.getSjName(), sysJob.getSjGroup()).build();
                jobDetail.getJobDataMap().put(QuartzJobFactory.JOB_DATA_MAP_KEY, sysJob);
                CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(sysJob.getSjCronExpression());
                trigger = TriggerBuilder.newTrigger()
                        .withIdentity(sysJob.getSjName(), sysJob.getSjGroup())
                        .withSchedule(scheduleBuilder).build();
                scheduler.scheduleJob(jobDetail, trigger);
            } else {
                // Trigger已存在，那么更新相应的定时设置
                CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(sysJob.getSjCronExpression());
                // 按新的cronExpression表达式重新构建trigger
                trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();
                // 按新的trigger重新设置job执行
                scheduler.rescheduleJob(triggerKey, trigger);
            }
        } catch (Exception e) {
            throw new CustomException("quartz 添加任务失败", e);
        }
    }

    /**
     * 更新job corn 表达式
     *
     * @param sysJob 系统任务对象
     */
    private void updateQuartzJobCronExpression(SysJob sysJob) {
        try {
            Scheduler scheduler = this.getScheduler();
            TriggerKey triggerKey = TriggerKey.triggerKey(sysJob.getSjName(), sysJob.getSjGroup());
            CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(sysJob.getSjCronExpression());
            trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();
            scheduler.rescheduleJob(triggerKey, trigger);
        } catch (Exception e) {
            throw new CustomException("updateQuartzJobCronExpression 发生错误,参数 = " + sysJob.toString(), e);
        }
    }

    /**
     * 验证corn 表达式是否正确,不正确抛出自定义异常
     *
     * @param cornExpression corn表达式
     */
    private void verifyCornExpression(String cornExpression) {
        try {
            CronScheduleBuilder.cronSchedule(cornExpression);
        } catch (Exception e) {
            throw new CustomException("cron表达式有误，不能被解析");
        }
    }

    /**
     * 验证目标类或方法是否正确
     *
     * @param job
     */
    private void verifyTargetClassAndMethodIsSuccess(SysJob job) {
        Object obj = null;
        try {
            if (StrUtil.isNotBlank(job.getSjSpringBeanName())) {
                obj = ApplicationContextUtil.getBean(job.getSjSpringBeanName());
            } else {
                Class clazz = Class.forName(job.getSjBeanClass());
                obj = clazz.newInstance();
            }
        } catch (Exception e) {
            throw new CustomException("反射创建目标类发生异常", e);
        }

        if (obj == null) {
            throw new CustomException("未找到目标类");
        }
        Class clazz = obj.getClass();
        Method method = null;
        try {
            method = clazz.getMethod(job.getSjMethodName(), null);
        } catch (Exception e) {
            throw new CustomException("反射创建目标方法发生异常", e);
        }
        if (method == null) {
            throw new CustomException("未找到目标方法");
        }
    }
}
