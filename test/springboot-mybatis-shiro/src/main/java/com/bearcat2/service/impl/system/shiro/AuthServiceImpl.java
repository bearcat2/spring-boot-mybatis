package com.bearcat2.service.impl.system.shiro;

import com.bearcat2.entity.system.SysPrivilege;
import com.bearcat2.mapper.system.SysPrivilegeMapper;
import com.bearcat2.service.system.shiro.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthServiceImpl implements AuthService {


    @Autowired
    SysPrivilegeMapper privilegeMapper;

    @Override
    public List<SysPrivilege> getUserPerms(Integer id) {

        return privilegeMapper.getUserPerms(id);
    }
}
