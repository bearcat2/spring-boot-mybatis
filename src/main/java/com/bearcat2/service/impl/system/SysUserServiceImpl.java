package com.bearcat2.service.impl.system;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import com.bearcat2.entity.common.Constant;
import com.bearcat2.entity.common.LayuiResult;
import com.bearcat2.entity.common.LoginUser;
import com.bearcat2.entity.common.PagingSupport;
import com.bearcat2.entity.system.SysPrivilege;
import com.bearcat2.entity.system.SysUser;
import com.bearcat2.entity.system.SysUserRole;
import com.bearcat2.enumeration.CodeMsgEnum;
import com.bearcat2.mapper.system.SysUserMapper;
import com.bearcat2.mapper.system.SysUserRoleMapper;
import com.bearcat2.service.system.SysPrivilegeService;
import com.bearcat2.service.system.SysUserService;
import com.bearcat2.util.CommonUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

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
 * @author zhongzhipeng
 * @see SysUserService
 * @since 1.0
 */
@Service
@Transactional(readOnly = true)
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysPrivilegeService sysPrivilegeService;

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;

    @Value("${bearcat2.superUser.username}")
    private String superAdmin;

    @Value("${bearcat2.superUser.password}")
    private String superAdminPassword;

    @Override
    public LayuiResult login(String loginName, String password) {
        // 验证用户信息
        Example example = new Example(SysUser.class);
        example.createCriteria()
                .andEqualTo(SysUser.SU_LOGIN_NAME, loginName);
        List<SysUser> sysUsers = this.sysUserMapper.selectByExample(example);
        if (CollUtil.isEmpty(sysUsers)) {
            return LayuiResult.error(CodeMsgEnum.LOGIN_ERROR);
        }
        SysUser sysUser = sysUsers.get(0);
        if (!sysUser.getSuPassword().equalsIgnoreCase(SecureUtil.md5(password))) {
            return LayuiResult.error(CodeMsgEnum.LOGIN_ERROR);
        }

        if (superAdmin.equals(sysUser.getSuLoginName())) {
            // 处理超级管理员登录
            return this.handleSuperUserLogin(sysUser);
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
     * @return LayuiResult - 控制层通用响应对象
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
    public LayuiResult pageList(SysUser sysUser, PagingSupport pagingSupport) {
        // 获取用户列表,排除超级管理员
        Example example = new Example(SysUser.class);
        Example.Criteria criteria = example.createCriteria()
                .andNotEqualTo(SysUser.SU_LOGIN_NAME, superAdmin);
        if (StrUtil.isNotBlank(sysUser.getSuLoginName())) {
            criteria.andLike(
                    SysUser.SU_LOGIN_NAME
                    , CommonUtil.buildLikeQueryParam(sysUser.getSuLoginName())
            );
        }
        example.setOrderByClause("su_create_time desc");
        PageHelper.startPage(pagingSupport.getPage(), pagingSupport.getLimit());
        List<SysUser> sysUsers = this.sysUserMapper.selectByExample(example);
        PageInfo<SysUser> pageInfo = new PageInfo<>(sysUsers);
        return LayuiResult.success(pageInfo.getList(), pageInfo.getTotal());
    }

    @Override
    public List<Integer> findRoleIdsById(Integer userId) {
        Example example = new Example(SysUserRole.class);
        example.createCriteria()
                .andEqualTo(SysUserRole.SUR_USER_ID, userId);
        List<SysUserRole> sysUserRoles = this.sysUserRoleMapper.selectByExample(example);
        return sysUserRoles.stream()
                .map(SysUserRole::getSurRoleId)
                .collect(Collectors.toList());
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
        Example example = new Example(SysUserRole.class);
        example.createCriteria()
                .andEqualTo(SysUserRole.SUR_USER_ID, userId);

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
        this.sysUserMapper.insertUseGeneratedKeys(sysUser);

        // 添加用户角色表
        this.insertUserRoleRelation(sysUser.getSuId(), roleId);
        return LayuiResult.success();
    }

    @Transactional
    @Override
    public LayuiResult edit(SysUser sysUser, Integer roleId) {
        sysUser.setSuUpdateTime(new Date());
        this.sysUserMapper.updateByPrimaryKeySelective(sysUser);

        // 修改对应的用户角色关系表
        this.updateUserRoleRelationByUserId(sysUser.getSuId(), roleId);
        return LayuiResult.success();
    }

    @Override
    public List<SysUser> listAll() {
        return this.sysUserMapper.selectAll();
    }

    @Override
    public void insertSuperAdmin() {
        // 1.判断数据库中是否存在超级原理员
        Example example = new Example(SysUser.class);
        example.createCriteria()
                .andEqualTo(SysUser.SU_LOGIN_NAME, superAdmin);
        List<SysUser> sysUsers = this.sysUserMapper.selectByExample(example);

        // 2. 不存在插入超管信息
        if (CollUtil.isEmpty(sysUsers)) {
            SysUser sysUser = new SysUser();
            sysUser.setSuLoginName(superAdmin);
            sysUser.setSuRealName(superAdmin);
            sysUser.setSuPassword(SecureUtil.md5(superAdminPassword));
            sysUser.setSuCreateTime(new Date());
            sysUser.setSuUpdateTime(new Date());
            this.sysUserMapper.insertSelective(sysUser);
            return;
        }

        // 3. 存在判断密码是否和配置文件中一致,一致直接返回,否则更新密码
        SysUser sysUser = sysUsers.get(0);
        if (sysUser.getSuPassword().equalsIgnoreCase(SecureUtil.md5(superAdminPassword))) {
            // 密码一致,直接返回
            return;
        }

        // 走到这程序没有返回,说明密码不一致,更新密码
        sysUser.setSuPassword(SecureUtil.md5(superAdminPassword));
        this.sysUserMapper.updateByPrimaryKeySelective(sysUser);
    }

    @Transactional
    @Override
    public LayuiResult updatePassword(SysUser sysUser, String newPassword) {
        if (sysUser.getSuPassword().equalsIgnoreCase(newPassword)) {
            return LayuiResult.error(CodeMsgEnum.REPEAT_PASSWORD_ERROR);
        }
        SysUser user = this.sysUserMapper.selectByPrimaryKey(sysUser.getSuId());
        if (!user.getSuPassword().equalsIgnoreCase(SecureUtil.md5(sysUser.getSuPassword()))) {
            return LayuiResult.error(CodeMsgEnum.OLD_PASSWORD_ERROR);
        }
        sysUser.setSuPassword(SecureUtil.md5(newPassword));
        this.sysUserMapper.updateByPrimaryKeySelective(sysUser);
        return LayuiResult.success();
    }

    @Override
    public SysUser findById(Integer id) {
        return this.sysUserMapper.selectByPrimaryKey(id);
    }

    @Transactional
    @Override
    public int deleteById(Integer id) {
        return this.sysUserMapper.deleteByPrimaryKey(id);
    }

    /**
     * 处理模块
     *
     * @param sysPrivileges 用户拥有的权限集合
     * @return 用户拥有的权限集合
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
     * @return 模块下所有菜单
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
