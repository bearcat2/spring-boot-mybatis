package com.bearcat2.service.system;

import com.bearcat2.entity.common.LayuiResult;
import com.bearcat2.entity.system.SysRole;
import com.bearcat2.entity.system.SysUserRole;

import java.util.List;

/**
 * <p>Description: 系统角色service接口</p>
 * <p>Title: SysRoleService </p>
 * <p>Create Time: 2018/8/17 18:56 </p>
 *
 * @author: zhongzhipeng
 * @version: 1.0
 */
public interface SysRoleService {

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

    /**
     * 根据id查询系统角色对象
     *
     * @param id 角色id
     * @return SysRole - 系统角色对象
     */
    SysRole findById(Integer id);

    /**
     * 修改系统角色对象
     *
     * @param sysRole 系统角色对象,必须包含id属性
     * @return int - 影响数据表行数
     */
    int update(SysRole sysRole);

    /**
     * 插入系统角色对象
     *
     * @param sysRole 系统角色对象
     * @return int - 影响数据表行数
     */
    int insert(SysRole sysRole);

    /**
     * 根据id删除系统角色对象
     *
     * @param id 角色id
     * @return int - 影响数据表行数
     */
    int deleteById(Integer id);
}
