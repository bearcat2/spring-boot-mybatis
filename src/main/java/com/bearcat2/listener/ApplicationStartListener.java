package com.bearcat2.listener;

import com.bearcat2.service.system.SysJobService;
import com.bearcat2.service.system.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * <p> Description: ioc容器初始化完毕回调该监听器,做一些初始化操作 </p>
 * <p> Title: ApplicationStartListener </p>
 * <p> Create Time: 2019/7/7 12:01 </p>
 *
 * @author zhongzhipeng
 * @see org.springframework.boot.ApplicationRunner
 * @since 1.0
 */
@Component
public class ApplicationStartListener implements ApplicationRunner {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysJobService sysJobService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // 像用户表中插入超级管理员
        this.sysUserService.insertSuperAdmin();

        // 初始化系统任务
        this.sysJobService.initSystemJob();
    }
}
