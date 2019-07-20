package com.bearcat2.service.impl.system;

import cn.hutool.core.util.StrUtil;
import com.bearcat2.entity.common.LayuiResult;
import com.bearcat2.entity.common.PagingSupport;
import com.bearcat2.entity.system.SysRole;
import com.bearcat2.entity.system.SysUserRole;
import com.bearcat2.mapper.system.SysRoleMapper;
import com.bearcat2.mapper.system.SysUserRoleMapper;
import com.bearcat2.service.system.SysRoleService;
import com.bearcat2.util.CommonUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>Description: 系统角色service接口实现类 </p>
 * <p>Title: SysRoleServiceImpl </p>
 * <p>Create Time: 2018/8/17 18:57 </p>
 *
 * @author: zhongzhipeng
 * @version: 1.0
 */
@Service
@Transactional(readOnly = true)
public class SysRoleServiceImpl implements SysRoleService {

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;

    @Override
    public LayuiResult pageList(SysRole sysRole, PagingSupport pagingSupport) {
        Example example = new Example(SysRole.class);
        Example.Criteria criteria = example.createCriteria();
        if (StrUtil.isNotBlank(sysRole.getSrName())) {
            criteria.andLike(
                    SysRole.SR_NAME
                    , CommonUtil.buildLikeQueryParam(sysRole.getSrName())
            );
        }
        PageHelper.startPage(pagingSupport.getPage(), pagingSupport.getLimit());
        List<SysRole> sysRoles = this.sysRoleMapper.selectByExample(example);
        PageInfo<SysRole> pageInfo = new PageInfo<>(sysRoles);
        return LayuiResult.success(pageInfo.getList(), pageInfo.getTotal());
    }

    @Override
    public List<SysRole> findAll() {
        Example example = new Example(SysRole.class);
        return this.sysRoleMapper.selectByExample(example);
    }

    @Override
    public List<SysUserRole> findByUserId(Integer userId) {
        Example sysUserRoleExample = new Example(SysUserRole.class);
        sysUserRoleExample.createCriteria()
                .andEqualTo(SysUserRole.SUR_USER_ID, userId);
        return this.sysUserRoleMapper.selectByExample(sysUserRoleExample);
    }

    @Transactional
    @Override
    public void allotSysRole(Integer userId, String roleIds) {
        Example sysUserRoleExample = new Example(SysUserRole.class);
        sysUserRoleExample.createCriteria()
                .andEqualTo(SysUserRole.SUR_USER_ID, userId);
        this.sysUserRoleMapper.deleteByExample(sysUserRoleExample);
        if (StrUtil.isBlank(roleIds)) {
            return;
        }
        List<SysUserRole> sysUserRoles = new ArrayList<>();
        for (String roleId : roleIds.split(",")) {
            SysUserRole sysUserRole = new SysUserRole();
            sysUserRole.setSurRoleId(Integer.parseInt(roleId));
            sysUserRole.setSurUserId(userId);
            sysUserRoles.add(sysUserRole);
        }

        if (!CollectionUtils.isEmpty(sysUserRoles)) {
            this.sysUserRoleMapper.insertList(sysUserRoles);
        }
    }

    @Override
    public SysRole findById(Integer id) {
        return this.sysRoleMapper.selectByPrimaryKey(id);
    }

    @Transactional
    @Override
    public int update(SysRole sysRole) {
        sysRole.setSrUpdateTime(new Date());
        return this.sysRoleMapper.updateByPrimaryKeySelective(sysRole);
    }

    @Transactional
    @Override
    public int insert(SysRole sysRole) {
        sysRole.setSrCreateTime(new Date());
        sysRole.setSrUpdateTime(new Date());
        return this.sysRoleMapper.insertSelective(sysRole);
    }

    @Transactional
    @Override
    public int deleteById(Integer id) {
        return this.sysRoleMapper.deleteByPrimaryKey(id);
    }
}
