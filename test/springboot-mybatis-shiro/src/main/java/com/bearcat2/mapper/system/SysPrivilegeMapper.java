package com.bearcat2.mapper.system;

import com.bearcat2.entity.system.SysPrivilege;
import com.bearcat2.entity.system.SysPrivilegeExample;
import com.bearcat2.mapper.CommonMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysPrivilegeMapper extends CommonMapper<SysPrivilege, SysPrivilegeExample> {
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
     * 根据角色id获取当下的全部权限
     * @param srId
     * @return
     */
    List<SysPrivilege> findPermsByRoleId(Integer srId);


    /**
     * 获取当前用户的全部权限
     * @param id
     * @return
     */
    List<SysPrivilege> getUserPerms(@Param("su_id") Integer id);
}