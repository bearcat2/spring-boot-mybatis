package com.bearcat2.service.system;

import com.bearcat2.entity.common.*;
import com.bearcat2.entity.system.SysPrivilege;
import com.bearcat2.entity.system.SysPrivilegeExample;
import com.bearcat2.entity.system.SysRolePrivilege;
import com.bearcat2.service.common.CommonService;

import java.util.HashMap;
import java.util.List;

/**
 * <p> Description: 权限管理的service接口 </p>
 * <p> Title: SysPrivilegeService </p>
 * <p> Create Time: 2019/5/11 23:07 </p>
 *
 * @author: zhongzhipeng
 * @version: 1.0
 */
public interface SysPrivilegeService extends CommonService<SysPrivilege, SysPrivilegeExample> {

    /**
     * 查找用户下拥有的所有菜单
     *
     * @param userId 用户id
     * @return
     */
    List<SysPrivilege> findMenuByUserId(Integer userId);

    /**
     * 查找用户下拥有的所有权限
     *
     * @param userId 用户id
     * @return
     */
    List<SysPrivilege> findPrivilegeByUserId(Integer userId);

    /**
     * 查找系统配置的所有权限
     *
     * @return
     */
    HashMap<String, Integer> findAllPrivilege();

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
     * @return
     */
    LayuiResult allotPrivilege(List<SysRolePrivilege> sysRolePrivileges);

    /**
     * 给当前菜单分配按钮
     *
     * @param menuId 菜单id
     * @return
     */
    AllotButtonTransfer allotButton(Integer menuId);
}
