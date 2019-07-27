package com.bearcat2.service.system;

import com.bearcat2.entity.common.LayuiResult;
import com.bearcat2.entity.common.PagingSupport;
import com.bearcat2.entity.system.SysUser;

import java.util.List;

/**
 * <p> Description: 用户管理的service接口 </p>
 * <p> Title: SysUserService </p>
 * <p> Create Time: 2019/5/11 23:07 </p>
 *
 * @author: zhongzhipeng
 * @version: 1.0
 */
public interface SysUserService {

    /**
     * 用户登录
     *
     * @param loginName 登录名
     * @param password  密码
     * @return LayuiResult 控制层通用响应对象 {@link LayuiResult}
     */
    LayuiResult login(String loginName, String password);

    /**
     * 分页查询
     *
     * @param sysUser       系统用户对象
     * @param pagingSupport 分支支持对象
     * @return LayuiResult - 控制层通用返回结果 {@link LayuiResult}
     */
    LayuiResult pageList(SysUser sysUser, PagingSupport pagingSupport);

    /**
     * 根据用户id查询对应的用户角色关系
     *
     * @param userId 用户id
     * @return 改用户用户的角色id集合
     */
    List<Integer> findRoleIdsById(Integer userId);

    /**
     * 添加用户角色关系表
     *
     * @param userId 用户id
     * @param roleId 角色id
     * @return 影响数据库表行数
     */
    int insertUserRoleRelation(Integer userId, Integer roleId);

    /**
     * 修改用户角色关系表
     *
     * @param userId 用户id
     * @param roleId 角色id
     * @return 影响数据库表行数
     */
    int updateUserRoleRelationByUserId(Integer userId, Integer roleId);

    /**
     * 修改密码
     *
     * @param sysUser     系统用户对象
     * @param newPassword 新密码
     * @return LayuiResult 控制层通用响应对象 {@link LayuiResult}
     */
    LayuiResult updatePassword(SysUser sysUser, String newPassword);

    /**
     * 根据id查询系统用户对象
     *
     * @param id 用户id
     * @return SysUser - 系统用户对象
     */
    SysUser findById(Integer id);

    /**
     * 根据id删除系统用户对象
     *
     * @param id 用户id
     * @return int - 影响数据表行数
     */
    int deleteById(Integer id);

    /**
     * 添加用户
     *
     * @param sysUser 系统用户对象
     * @param roleId  角色id
     * @return LayuiResult 控制层通用响应对象 {@link LayuiResult}
     */
    LayuiResult add(SysUser sysUser, Integer roleId);

    /**
     * 编辑用户
     *
     * @param sysUser 系统用户对象
     * @param roleId  角色id
     * @return LayuiResult 控制层通用响应对象 {@link LayuiResult}
     */
    LayuiResult edit(SysUser sysUser, Integer roleId);

    /**
     * 获取系统所用用户集合
     *
     * @return List<SysUser> - 系统用户集合
     */
    List<SysUser> listAll();

    /**
     * 插入超级管理员
     */
    void insertSuperAdmin();
}
