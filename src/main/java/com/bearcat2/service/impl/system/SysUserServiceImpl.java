package com.bearcat2.service.impl.system;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import com.bearcat2.entity.common.LayuiResult;
import com.bearcat2.entity.common.LoginUser;
import com.bearcat2.entity.system.*;
import com.bearcat2.enumeration.CodeMsgEnum;
import com.bearcat2.mapper.system.SysUserRoleMapper;
import com.bearcat2.service.common.CommonServiceImpl;
import com.bearcat2.service.system.SysPrivilegeService;
import com.bearcat2.service.system.SysUserService;
import com.bearcat2.util.BaseUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <p> Description: 用户管理的service接口实现类 </p>
 * <p> Title: SysUserServiceImpl </p>
 * <p> Create Time: 2019/5/11 23:08 </p>
 *
 * @author: zhongzhipeng
 * @version: 1.0
 */
@Service
public class SysUserServiceImpl extends CommonServiceImpl<SysUser, SysUserExample> implements SysUserService {

    @Autowired
    private SysPrivilegeService sysPrivilegeService;

    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;

    @Override
    public LayuiResult login(String loginName, String password) {
        SysUserExample example = new SysUserExample();
        example.createCriteria()
                .andSuLoginNameEqualTo(loginName);
        List<SysUser> sysUsers = super.selectByExample(example);
        if (CollUtil.isEmpty(sysUsers)) {
            return LayuiResult.error(CodeMsgEnum.LOGIN_ERROR);
        }
        SysUser sysUser = sysUsers.get(0);
        if (!sysUser.getSuPassword().equalsIgnoreCase(SecureUtil.md5(password))) {
            return LayuiResult.error(CodeMsgEnum.LOGIN_ERROR);
        }

        // 用户登录成功将用户信息(用户id、登录名、真实姓名、菜单、权限)放入LoginUser中
        LoginUser loginUser = new LoginUser();
        loginUser.setUserId(sysUser.getSuId());
        loginUser.setLoginName(sysUser.getSuLoginName());
        loginUser.setRealName(sysUser.getSuRealName());

        List<SysPrivilege> sysPrivileges = this.sysPrivilegeService.findMenuByUserId(loginUser.getUserId());
        Set<SysPrivilege> meuns = BaseUtil.listToSet(this.handleModule(sysPrivileges));
        loginUser.setMenus(meuns);

        List<SysPrivilege> privileges = this.sysPrivilegeService.findPrivilegeByUserId(loginUser.getUserId());
        loginUser.setPrivileges(BaseUtil.listToSet(privileges));
        return LayuiResult.success(loginUser);
    }

    @Override
    public LayuiResult list(SysUser sysUser) {
        SysUserExample example = new SysUserExample();
        SysUserExample.Criteria criteria = example.createCriteria();
        if (StrUtil.isNotBlank(sysUser.getSuLoginName())) {
            criteria.andSuLoginNameLike(BaseUtil.buildLikeQueryParam(sysUser.getSuLoginName()));
        }
        example.setOrderByClause("su_create_time desc");
        PageHelper.startPage(sysUser.getPage(), sysUser.getLimit());
        List<SysUser> sysUsers = super.selectByExample(example);
        PageInfo<SysUser> pageInfo = new PageInfo<>(sysUsers);
        return LayuiResult.success(pageInfo.getList(), pageInfo.getTotal());
    }

    @Override
    public List<Integer> findByUserId(Integer userId) {
        SysUserRoleExample example = new SysUserRoleExample();
        example.createCriteria()
                .andSurUserIdEqualTo(userId);
        List<SysUserRole> sysUserRoles = this.sysUserRoleMapper.selectByExample(example);
        List<Integer> roleIds = sysUserRoles.stream()
                .map(SysUserRole::getSurRoleId)
                .collect(Collectors.toList());
        return roleIds;
    }

    @Override
    public int insertUserRoleRelation(Integer userId, Integer roleId) {
        SysUserRole sysUserRole = new SysUserRole();
        sysUserRole.setSurUserId(userId);
        sysUserRole.setSurRoleId(roleId);
        return this.sysUserRoleMapper.insertSelective(sysUserRole);
    }

    @Override
    public int updateUserRoleRelationByUserId(Integer userId, Integer roleId) {
        SysUserRoleExample example = new SysUserRoleExample();
        example.createCriteria()
                .andSurUserIdEqualTo(userId);

        SysUserRole sysUserRole = new SysUserRole();
        sysUserRole.setSurRoleId(roleId);
        return this.sysUserRoleMapper.updateByExampleSelective(sysUserRole, example);
    }

    /**
     * 处理模块
     *
     * @param sysPrivileges 用户拥有的权限集合
     * @return
     */
    private List<SysPrivilege> handleModule(List<SysPrivilege> sysPrivileges) {
        List<SysPrivilege> modules = new ArrayList<>();
        for (SysPrivilege sysPrivilege : sysPrivileges) {
            if (sysPrivilege.getSpType() == 1) {
                // 类型为模块,获取模块下的菜单
                sysPrivilege.setChildrenSysPrivilege(this.handleMenu(sysPrivileges, sysPrivilege));
                modules.add(sysPrivilege);
            }
        }
        return modules;
    }

    /**
     * 处理菜单
     *
     * @param sysPrivileges 用户拥有的权限集合
     * @param sysPrivilege  父权限id
     * @return
     */
    private List<SysPrivilege> handleMenu(List<SysPrivilege> sysPrivileges, SysPrivilege sysPrivilege) {
        List<SysPrivilege> childrenMenus = new ArrayList<>();
        for (SysPrivilege privilege : sysPrivileges) {
            if (privilege.getSpParentId().equals(sysPrivilege.getSpId())) {
                childrenMenus.add(privilege);
            }
        }
        return childrenMenus;
    }
}
