package com.bearcat2.service.system;

import com.bearcat2.entity.common.LayuiResult;
import com.bearcat2.entity.system.SysRole;
import com.bearcat2.entity.system.SysRoleExample;
import com.bearcat2.entity.system.SysUserRole;
import com.bearcat2.service.common.CommonService;

import java.util.List;

/**
 * <p>Description: 系统角色service接口</p>
 * <p>Title: SysRoleService </p>
 * <p>Create Time: 2018/8/17 18:56 </p>
 *
 * @author: zhongzhipeng
 * @version: 1.0
 */
public interface SysRoleService extends CommonService< SysRole, SysRoleExample> {

    /**
     * 分页查询
     *
     * @param sysRole
     * @return
     */
    LayuiResult list(SysRole sysRole);

    /**
     * 查找系统所有角色
     *
     * @return
     */
    List<SysRole> findAll();

    /**
     * 根据用户下拥有的角色
     *
     * @param userId 用户id
     * @return
     */
    List<SysUserRole> findByUserId(Integer userId);

    /**
     * 分配系统角色
     *
     * @param userId  用户id
     * @param roleIds 角色id集合
     */
    void allotSysRole(Integer userId, String roleIds);

    public List<SysRole> findByCondition(SysRole sysRole);
}
