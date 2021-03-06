package com.bearcat2.service.system;

import com.bearcat2.entity.common.*;
import com.bearcat2.entity.system.SysPrivilege;
import com.bearcat2.entity.system.SysRolePrivilege;

import java.util.HashMap;
import java.util.List;

/**
 * <p> Description: 权限管理的service接口 </p>
 * <p> Title: SysPrivilegeService </p>
 * <p> Create Time: 2019/5/11 23:07 </p>
 *
 * @author zhongzhipeng
 * @since 1.0
 */
public interface SysPrivilegeService {

    /**
     * 查找用户下拥有的所有菜单
     *
     * @param userId 用户id
     * @return 系统权限集合
     */
    List<SysPrivilege> findMenuByUserId(Integer userId);

    /**
     * 查找用户下拥有的所有权限
     *
     * @param userId 用户id
     * @return 用户下拥有的所有权限
     */
    List<SysPrivilege> findPrivilegeByUserId(Integer userId);

    /**
     * 获取系统所有菜单
     *
     * @return 系统所有菜单
     */
    List<SysPrivilege> findAllMenu();

    /**
     * 获取系统所有权限
     *
     * @return 系统所有权限
     */
    List<SysPrivilege> findAllPrivilege();

    /**
     * 查找系统配置的所有权限
     *
     * @return 系统配置的所有权限
     */
    HashMap<String, Integer> findAllPrivilegeMap();

    /**
     * 获取前端treeTable插件所需内容
     *
     * @return TreeTableNode - 前端treetable插件所需格式
     */
    List<TreeTableNode> getTreeTableNode();

    /**
     * 获取前端 treeSelect 插件所需内容
     *
     * @return TreeSelectNode - 前端 treeSelect 插件所需格式
     */
    List<TreeSelectNode> getTreeSelectNode();

    /**
     * 获取角色拥有的权限
     *
     * @param roleId 角色id
     * @return LayuiTreeNode - layui tree模块所需格式
     */
    List<LayuiTreeNode> getLayuiTreeNode(Integer roleId);

    /**
     * 给当前角色分配权限
     *
     * @param sysRolePrivileges 角色权限集合
     * @return LayuiResult - 控制层通用响应对象
     */
    LayuiResult allotPrivilege(List<SysRolePrivilege> sysRolePrivileges);

    /**
     * 获取按钮管理穿梭框数据
     *
     * @param menuId 菜单id
     * @return AllotButtonTransfer - 前端分配按钮穿梭框数据
     */
    AllotButtonTransfer getTransferData(Integer menuId);

    /**
     * 分配按钮
     * 注意：前端传递过来的权限数据做了处理,如果没有选择权限会将父菜单id传递过来但是不会有 operateName
     * 所以判断空的条件是有且仅有一条数据且operateName为空
     *
     * @param sysPrivileges 权限对象
     * @return LayuiResult - 控制层通用响应对象
     */
    LayuiResult allotButton(List<SysPrivilege> sysPrivileges);

    /**
     * 根据id查询系统权限对象
     *
     * @param id 权限id
     * @return SysPrivilege - 系统权限对象
     */
    SysPrivilege findById(Integer id);

    /**
     * 修改系统权限对象
     *
     * @param sysPrivilege 系统权限对象,必须包含id属性
     * @return int - 影响数据表行数
     */
    int update(SysPrivilege sysPrivilege);

    /**
     * 插入系统权限对象
     *
     * @param sysPrivilege 系统权限对象,必须包含id属性
     * @return int - 影响数据表行数
     */
    int insert(SysPrivilege sysPrivilege);

    /**
     * 根据id删除系统权限对象
     *
     * @param id 权限id
     * @return int - 影响数据表行数
     */
    int deleteById(Integer id);

}
