package com.bearcat2.mapper.system;

import com.bearcat2.entity.system.SysRole;
import com.bearcat2.entity.system.SysRoleExample;
import com.bearcat2.mapper.CommonMapper;

import java.util.List;

public interface SysRoleMapper extends CommonMapper<SysRole, SysRoleExample> {

    /**
     * 根据用户id查询出对应所有的权限
     * @param userId
     * @return
     */
    List<SysRole> getRoleByUser(Integer userId);
}