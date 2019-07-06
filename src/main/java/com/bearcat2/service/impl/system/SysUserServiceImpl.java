package com.bearcat2.service.impl.system;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import com.bearcat2.entity.common.Constant;
import com.bearcat2.entity.common.LayuiResult;
import com.bearcat2.entity.common.LoginUser;
import com.bearcat2.entity.system.*;
import com.bearcat2.enumeration.CodeMsgEnum;
import com.bearcat2.mapper.system.SysUserRoleMapper;
import com.bearcat2.service.common.CommonServiceImpl;
import com.bearcat2.service.system.SysPrivilegeService;
import com.bearcat2.service.system.SysUserService;
import com.bearcat2.util.CommonUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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
@Transactional(readOnly = true)
public class SysUserServiceImpl extends CommonServiceImpl<SysUser, SysUserExample> implements SysUserService {

    @Autowired
    private SysPrivilegeService sysPrivilegeService;

    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;

    @Value("${bearcat2.superUser.username}")
    private String superAdmin;

    @Value("${bearcat2.superUser.password}")
    private String superAdminPassword;

    @Override
    public LayuiResult login(String loginName, String password) {
        if (superAdmin.equals(loginName) && superAdminPassword.equals(password)) {
            // 处理超级用户登录,注意这里需要在前端做个处理，新增用户时不允许添加的用户名和超管一致
            SysUser sysUser = new SysUser();
            sysUser.setSuLoginName(superAdmin);
            sysUser.setSuRealName(superAdmin);
            return handleSuperUserLogin(sysUser);
        }

        // 走到这没有返回说明当前登录用户不是超级管理,接着走之前逻辑
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
        List<SysPrivilege> menus = this.sysPrivilegeService.findMenuByUserId(sysUser.getSuId());
        List<SysPrivilege> userPrivileges = this.sysPrivilegeService.findPrivilegeByUserId(sysUser.getSuId());
        LoginUser loginUser = buildLoginUserInfo(sysUser, menus, userPrivileges);
        return LayuiResult.success(loginUser);
    }

    /**
     * 处理超级用户登录
     *
     * @return
     */
    private LayuiResult handleSuperUserLogin(SysUser sysUser) {
        // 超级管理员, 注意添加用户那要做个限制,登录名不能为 admin
        List<SysPrivilege> allMenu = this.sysPrivilegeService.findAllMenu();
        List<SysPrivilege> allPrivilege = this.sysPrivilegeService.findAllPrivilege();
        LoginUser loginUser = buildLoginUserInfo(sysUser, allMenu, allPrivilege);
        return LayuiResult.success(loginUser);
    }

    /**
     * 构建登录用户信息
     *
     * @param sysUser    系统用户对象
     * @param menus      用户所拥有菜单集合
     * @param privileges 用户所拥有权限集合
     * @return LoginUser 登录用户对象
     */
    private LoginUser buildLoginUserInfo(SysUser sysUser, List<SysPrivilege> menus, List<SysPrivilege> privileges) {
        LoginUser loginUser = new LoginUser();
        loginUser.setUserId(sysUser.getSuId());
        loginUser.setLoginName(sysUser.getSuLoginName());
        loginUser.setRealName(sysUser.getSuRealName());

        loginUser.setMenus(CommonUtil.listToSet(this.handleModule(menus)));
        loginUser.setUserPrivileges(CommonUtil.listToSet(privileges));
        HashMap<String, Integer> allPrivilege = this.sysPrivilegeService.findAllPrivilegeMap();
        loginUser.setPrivilegeMap(allPrivilege);

        return loginUser;
    }

    @Override
    public LayuiResult list(SysUser sysUser) {
        SysUserExample example = new SysUserExample();
        SysUserExample.Criteria criteria = example.createCriteria();
        if (StrUtil.isNotBlank(sysUser.getSuLoginName())) {
            criteria.andSuLoginNameLike(CommonUtil.buildLikeQueryParam(sysUser.getSuLoginName()));
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

    @Transactional
    @Override
    public int insertUserRoleRelation(Integer userId, Integer roleId) {
        SysUserRole sysUserRole = new SysUserRole();
        sysUserRole.setSurUserId(userId);
        sysUserRole.setSurRoleId(roleId);
        return this.sysUserRoleMapper.insertSelective(sysUserRole);
    }

    @Transactional
    @Override
    public int updateUserRoleRelationByUserId(Integer userId, Integer roleId) {
        SysUserRoleExample example = new SysUserRoleExample();
        example.createCriteria()
                .andSurUserIdEqualTo(userId);

        SysUserRole sysUserRole = new SysUserRole();
        sysUserRole.setSurRoleId(roleId);
        return this.sysUserRoleMapper.updateByExampleSelective(sysUserRole, example);
    }

    @Transactional
    @Override
    public LayuiResult add(SysUser sysUser, Integer roleId) {
        sysUser.setSuCreateTime(new Date());
        sysUser.setSuUpdateTime(new Date());
        sysUser.setSuPassword(SecureUtil.md5(sysUser.getSuPassword()));
        // 注意这里已在mybatis里设置,插入用户数据后会将自增生成的主键插入到SysUser对象的suId属性中
        super.insertSelective(sysUser);

        // 添加用户角色表
        this.insertUserRoleRelation(sysUser.getSuId(), roleId);
        return LayuiResult.success();
    }

    @Transactional
    @Override
    public LayuiResult edit(SysUser sysUser, Integer roleId) {
        sysUser.setSuUpdateTime(new Date());
        super.updateByPrimaryKeySelective(sysUser);

        // 修改对应的用户角色关系表
        this.updateUserRoleRelationByUserId(sysUser.getSuId(), roleId);
        return LayuiResult.success();
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
            if (sysPrivilege.getSpType() == Constant.MODULE_PRIVILEGE_TYPE) {
                // 类型为模块,获取模块下的菜单
                sysPrivilege.setChildrenSysPrivilege(this.fillMenu(sysPrivileges, sysPrivilege));
                modules.add(sysPrivilege);
            }
        }
        return modules;
    }

    /**
     * 填充模块下所有菜单
     *
     * @param sysPrivileges 用户拥有的权限集合
     * @param sysPrivilege  父权限id
     * @return
     */
    private List<SysPrivilege> fillMenu(List<SysPrivilege> sysPrivileges, SysPrivilege sysPrivilege) {
        List<SysPrivilege> childrenMenus = new ArrayList<>();
        for (SysPrivilege privilege : sysPrivileges) {
            if (privilege.getSpParentId().equals(sysPrivilege.getSpId())) {
                childrenMenus.add(privilege);
            }
        }
        return childrenMenus;
    }
}
