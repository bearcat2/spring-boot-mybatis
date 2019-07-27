package com.bearcat2.quartz;


import cn.hutool.core.util.StrUtil;
import com.bearcat2.entity.system.SysJob;
import com.bearcat2.util.ApplicationContextUtil;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Method;

/**
 * <p> Description: Quqrtz工具类 </p>
 * <p> Title: QuartzUtil </p>
 * <p> Create Time: 2019/7/28 7:01 </p>
 *
 * @author zhongzhipeng
 * @since 1.0
 */
@Slf4j
public class QuartzUtil {

    /**
     * 通过反射调用scheduleJob中定义的方法
     *
     * @param sysJob 系统任务对象
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public static void invokMethod(SysJob sysJob) {
        Object object = null;
        Class clazz = null;
        //判断是springbean还是Java类
        if (StrUtil.isNotBlank(sysJob.getSjSpringBeanName())) {
            object = ApplicationContextUtil.getBean(sysJob.getSjSpringBeanName());
        } else if (StrUtil.isNotBlank(sysJob.getSjBeanClass())) {
            try {
                clazz = Class.forName(sysJob.getSjBeanClass());
                object = clazz.newInstance();
            } catch (Exception e) {
                log.error("反射创建类错生错误,beanclass = {}", sysJob.getSjBeanClass(), e);
            }
        }
        if (object == null) {
            log.error("未启动成功，请检查是否配置正确！任务名称 = [" + sysJob.getSjName() + "]");
            return;
        }

        clazz = object.getClass();
        Method method = null;
        try {
            method = clazz.getDeclaredMethod(sysJob.getSjMethodName());
        } catch (Exception e) {
            log.error(
                    "任务启动失败，方法名设置错误！方法名 = {} , 任务名称 = {}"
                    , sysJob.getSjMethodName()
                    , sysJob.getSjName()
            );
            return;
        }
        if (method != null) {
            try {
                method.invoke(object);
            } catch (Exception e) {
                log.error("反射调用方法失败,方法名 = {}", sysJob.getSjMethodName(), e);
                return;
            }
        }
        log.info("任务启动成功，名称 = {}", sysJob.getSjName());
    }
}