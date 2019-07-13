package com.bearcat2.mapper.system;

import com.bearcat2.entity.system.SysPrivilege;
import com.bearcat2.mapper.CommonMapper;

import java.util.List;

public interface SysPrivilegeMapper extends CommonMapper<SysPrivilege> {

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
}