package com.bearcat2.listener;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.crypto.SecureUtil;
import com.bearcat2.entity.system.SysUser;
import com.bearcat2.mapper.system.SysUserMapper;
import com.bearcat2.service.system.SysJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

/**
 * <p> Description: ioc容器初始化完毕回调该监听器,做一些初始化操作 </p>
 * <p> Title: ApplicationStartListener </p>
 * <p> Create Time: 2019/7/7 12:01 </p>
 *
 * @author: zhongzhipeng
 * @version: 1.0
 */
@Component
public class ApplicationStartListener implements ApplicationRunner {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private SysJobService sysJobService;

    @Value("${bearcat2.superUser.username}")
    private String superAdmin;

    @Value("${bearcat2.superUser.password}")
    private String superAdminPassword;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // 像用户表中插入超级管理员
        insertSuperAdmin();

        // 初始化系统任务
        this.sysJobService.initSystemJob();
    }

    /**
     * 像用户表中插入超级管理员
     */
    private void insertSuperAdmin() {
        // 1.判断数据库中是否存在超级原理员
        Example example = new Example(SysUser.class);
        example.createCriteria()
                .andEqualTo(SysUser.SU_LOGIN_NAME, superAdmin);
        List<SysUser> sysUsers = this.sysUserMapper.selectByExample(example);
        // 2. 存在直接返回
        if (CollUtil.isNotEmpty(sysUsers)) {
            return;
        }
        // 3. 不存在插入超管信息
        SysUser sysUser = new SysUser();
        sysUser.setSuLoginName(superAdmin);
        sysUser.setSuRealName(superAdmin);
        sysUser.setSuPassword(SecureUtil.md5(superAdminPassword));
        sysUser.setSuCreateTime(new Date());
        sysUser.setSuUpdateTime(new Date());
        this.sysUserMapper.insertSelective(sysUser);
    }
}
