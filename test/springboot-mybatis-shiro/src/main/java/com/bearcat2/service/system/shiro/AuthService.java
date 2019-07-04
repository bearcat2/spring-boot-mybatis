package com.bearcat2.service.system.shiro;

import com.bearcat2.entity.system.SysPrivilege;
import com.bearcat2.entity.system.SysRole;

import java.util.List;

public interface AuthService {




    /**
     * 根据用户id获取权限数据
     * @param id
     * @return
     */
    List<SysPrivilege> getUserPerms(Integer id);
}
