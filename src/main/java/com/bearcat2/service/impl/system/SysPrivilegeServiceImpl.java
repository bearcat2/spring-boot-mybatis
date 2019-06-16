package com.bearcat2.service.impl.system;

import cn.hutool.core.util.StrUtil;
import com.bearcat2.entity.common.LayuiResult;
import com.bearcat2.entity.common.TreeTableNode;
import com.bearcat2.entity.system.SysPrivilege;
import com.bearcat2.entity.system.SysPrivilegeExample;
import com.bearcat2.entity.system.SysRolePrivilege;
import com.bearcat2.entity.system.SysRolePrivilegeExample;
import com.bearcat2.mapper.system.SysPrivilegeMapper;
import com.bearcat2.mapper.system.SysRolePrivilegeMapper;
import com.bearcat2.service.common.CommonServiceImpl;
import com.bearcat2.service.system.SysPrivilegeService;
import com.bearcat2.util.BaseUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>Description: 权限管理的service接口实现类 </p>
 * <p>Title: SysPrivilegeServiceImpl </p>
 * <p>Create Time: 2018/8/16 16:20 </p>
 *
 * @author: zhongzhipeng
 * @version: 1.0
 */
@Service
public class SysPrivilegeServiceImpl extends CommonServiceImpl<SysPrivilege, SysPrivilegeExample> implements SysPrivilegeService {

    @Autowired
    private SysPrivilegeMapper sysPrivilegeMapper;

    @Autowired
    private SysRolePrivilegeMapper sysRolePrivilegeMapper;

    /**
     * 构建单表字段动态sql查询
     *
     * @param sysPrivilege 系统权限表
     * @return 权限集合
     */
    private List<SysPrivilege> dynamicSqlQuery(SysPrivilege sysPrivilege) {
        SysPrivilegeExample example = new SysPrivilegeExample();
        SysPrivilegeExample.Criteria criteria = example.createCriteria();
        if (StrUtil.isNotBlank(sysPrivilege.getSpName())) {
            criteria.andSpNameLike(BaseUtil.buildLikeQueryParam(sysPrivilege.getSpName()));
        }
        if (StrUtil.isNotBlank(sysPrivilege.getSpUri())) {
            criteria.andSpUriLike(BaseUtil.buildLikeQueryParam(sysPrivilege.getSpUri()));
        }
        if (sysPrivilege.getSpType() != null) {
            criteria.andSpTypeEqualTo(sysPrivilege.getSpType());
        }
        if (sysPrivilege.getSpParentId() != null) {
            criteria.andSpParentIdEqualTo(sysPrivilege.getSpParentId());
        }
        return super.selectByExample(example);
    }

    @Override
    public List<SysPrivilege> findMenuByUserId(Integer userId) {
        return this.sysPrivilegeMapper.findMenuByUserId(userId);
    }

    @Override
    public List<SysPrivilege> findPrivilegeByUserId(Integer userId) {
        return this.sysPrivilegeMapper.findPrivilegeByUserId(userId);
    }

    @Override
    public List<SysPrivilege> findByModuleId(Integer moduleId) {
        SysPrivilege sysPrivilege = new SysPrivilege();
        sysPrivilege.setSpParentId(moduleId);
        return this.dynamicSqlQuery(sysPrivilege);
    }

    @Override
    public LayuiResult list(SysPrivilege sysPrivilege) {
        PageHelper.startPage(sysPrivilege.getPage(), sysPrivilege.getLimit());
        List<SysPrivilege> sysPrivileges = this.dynamicSqlQuery(sysPrivilege);
        PageInfo<SysPrivilege> pageInfo = new PageInfo<>(sysPrivileges);
        return LayuiResult.success(pageInfo.getList(), pageInfo.getTotal());
    }

    @Override
    public List<SysPrivilege> findByType(Integer type) {
        SysPrivilege sysPrivilege = new SysPrivilege();
        sysPrivilege.setSpType(type);
        return this.dynamicSqlQuery(sysPrivilege);
    }

    @Override
    public List<SysPrivilege> findAll() {
        SysPrivilege sysPrivilege = new SysPrivilege();
        return this.dynamicSqlQuery(sysPrivilege);
    }

    @Override
    public List<SysRolePrivilege> findByRoleId(Integer roleId) {
        SysRolePrivilegeExample example = new SysRolePrivilegeExample();
        SysRolePrivilegeExample.Criteria criteria = example.createCriteria();
        criteria.andSrpRoleIdEqualTo(roleId);
        return this.sysRolePrivilegeMapper.selectByExample(example);
    }

    @Override
    public List<TreeTableNode> getMenu() {
        SysPrivilegeExample example = new SysPrivilegeExample();
        example.createCriteria()
                .andSpTypeIn(Arrays.asList(1, 2));
        example.setOrderByClause("sp_orderd");
        List<SysPrivilege> sysPrivileges = this.selectByExample(example);

        List<TreeTableNode> treeTableNodes = new ArrayList<>(sysPrivileges.size());
        for (SysPrivilege sysPrivilege : sysPrivileges) {
            TreeTableNode treeTableNode = new TreeTableNode();
            treeTableNode.setId(sysPrivilege.getSpId());
            treeTableNode.setPid(sysPrivilege.getSpParentId());
            treeTableNode.setTitle(sysPrivilege.getSpName());
            treeTableNode.setUrl(sysPrivilege.getSpUri());
            treeTableNode.setOrderd(sysPrivilege.getSpOrderd());
            treeTableNode.setType(sysPrivilege.getSpType());
            treeTableNodes.add(treeTableNode);
        }
        return treeTableNodes;
    }
}