package com.bearcat2.service.system;

import com.bearcat2.entity.common.LayuiResult;
import com.bearcat2.entity.system.SysUser;
import com.bearcat2.entity.system.SysUserExample;
import com.bearcat2.service.common.CommonService;

/**
 * <p> Description: 用户管理的service接口 </p>
 * <p> Title: SysUserService </p>
 * <p> Create Time: 2019/5/11 23:07 </p>
 *
 * @author: zhongzhipeng
 * @version: 1.0
 */
public interface SysUserService extends CommonService<SysUser, SysUserExample> {

    /**
     * 用户登录
     *
     * @param loginName 登录名
     * @param password  密码
     * @return
     */
    LayuiResult login(String loginName, String password);

    /**
     * 分页查询
     *
     * @param sysUser
     * @return
     */
    LayuiResult list(SysUser sysUser);
}
