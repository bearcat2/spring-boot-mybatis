package com.bearcat2.listener;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.crypto.SecureUtil;
import com.bearcat2.entity.system.SysUser;
import com.bearcat2.entity.system.SysUserExample;
import com.bearcat2.service.system.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

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
    private SysUserService sysUserService;

    @Value("${bearcat2.superUser.username}")
    private String superAdmin;

    @Value("${bearcat2.superUser.password}")
    private String superAdminPassword;

    //private

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // 像用户表中插入超级管理员
        insertSuperAdmin();
    }

    /**
     * 像用户表中插入超级管理员
     */
    private void insertSuperAdmin() {
        // 1.判断数据库中是否存在超级原理员
        SysUserExample example = new SysUserExample();
        example.createCriteria()
                .andSuLoginNameEqualTo(superAdmin);
        List<SysUser> sysUsers = this.sysUserService.selectByExample(example);
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
        this.sysUserService.insertSelective(sysUser);
    }
}
