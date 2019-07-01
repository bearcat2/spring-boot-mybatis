package com.bearcat2.service.impl.system;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.bearcat2.entity.common.*;
import com.bearcat2.entity.system.*;
import com.bearcat2.enumeration.CodeMsgEnum;
import com.bearcat2.mapper.system.SysPrivilegeMapper;
import com.bearcat2.mapper.system.SysRolePrivilegeMapper;
import com.bearcat2.service.common.CommonServiceImpl;
import com.bearcat2.service.system.SysOperateService;
import com.bearcat2.service.system.SysPrivilegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

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

    @Autowired
    private SysOperateService sysOperateService;

    @Value("${bearcat2.systemName}")
    private String systemName;

    @Override
    public List<SysPrivilege> findMenuByUserId(Integer userId) {
        return this.sysPrivilegeMapper.findMenuByUserId(userId);
    }

    @Override
    public List<SysPrivilege> findPrivilegeByUserId(Integer userId) {
        return this.sysPrivilegeMapper.findPrivilegeByUserId(userId);
    }

    @Override
    public List<TreeTableNode> getTreeTableNode() {
        List<SysPrivilege> sysPrivileges = this.getSysMenu();

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

    @Override
    public HashMap<String, Integer> findAllPrivilege() {
        SysPrivilegeExample example = new SysPrivilegeExample();
        example.createCriteria()
                .andSpTypeEqualTo(Constant.BUTTON_PRIVILEGE_TYPE);
        List<SysPrivilege> sysPrivileges = super.selectByExample(example);

        HashMap<String, Integer> privilegeMap = new HashMap<>(sysPrivileges.size());
        for (SysPrivilege sysPrivilege : sysPrivileges) {
            privilegeMap.put(sysPrivilege.getSpUri(), sysPrivilege.getSpId());
        }
        return privilegeMap;
    }

    @Override
    public List<TreeSelectNode> getTreeSelectNode() {
        List<TreeSelectNode> treeSelectNodes = new ArrayList<>();
        List<SysPrivilege> sysPrivileges = this.getSysMenu();
        for (SysPrivilege sysPrivilege : sysPrivileges) {
            if (sysPrivilege.getSpType() == Constant.MODULE_PRIVILEGE_TYPE) {
                // 权限为模块
                TreeSelectNode treeSelectNode = new TreeSelectNode();
                treeSelectNode.setId(sysPrivilege.getSpId());
                treeSelectNode.setName(sysPrivilege.getSpName());

                // 设置子节点内容,即找出该模块下所有子菜单设置到子节点中
                setChildren(sysPrivileges, treeSelectNode);
                treeSelectNodes.add(treeSelectNode);
            }
        }

        // 添加顶级树节点
        List<TreeSelectNode> parentTreeSelectNodes = new ArrayList<>();
        TreeSelectNode parentTreeSelectNode = new TreeSelectNode();
        parentTreeSelectNode.setId(0);
        parentTreeSelectNode.setName(systemName);
        parentTreeSelectNode.setChecked(false);
        parentTreeSelectNode.setOpen(true);
        parentTreeSelectNode.setChildren(treeSelectNodes);
        parentTreeSelectNodes.add(parentTreeSelectNode);
        return parentTreeSelectNodes;
    }

    @Override
    public List<LayuiTreeNode> getLayuiTreeNode(Integer roleId) {
        // 获取角色下拥有的权限
        Map<Integer, Integer> privilegers = getPrivilegerByRoleId(roleId);
        List<LayuiTreeNode> layuiTreeNodes = new ArrayList<>();

        SysPrivilegeExample example = new SysPrivilegeExample();
        example.setOrderByClause("sp_orderd");
        List<SysPrivilege> sysPrivileges = this.selectByExample(example);
        for (SysPrivilege sysPrivilege : sysPrivileges) {
            if (Constant.MODULE_PRIVILEGE_TYPE == sysPrivilege.getSpType()) {
                LayuiTreeNode layuiTreeNode = new LayuiTreeNode();
                layuiTreeNode.setId(sysPrivilege.getSpId());
                layuiTreeNode.setTitle(sysPrivilege.getSpName());
                layuiTreeNode.setSpread(true);
                setChildren(sysPrivileges, layuiTreeNode, privilegers);
                layuiTreeNodes.add(layuiTreeNode);
            }
        }
        return layuiTreeNodes;
    }

    /**
     * 获取角色下的权限,key 为 权限id,value为角色id
     *
     * @param roleId 角色id
     * @return
     */
    private Map<Integer, Integer> getPrivilegerByRoleId(Integer roleId) {
        SysRolePrivilegeExample example = new SysRolePrivilegeExample();
        example.createCriteria()
                .andSrpRoleIdEqualTo(roleId);
        List<SysRolePrivilege> sysRolePrivileges = this.sysRolePrivilegeMapper.selectByExample(example);
        Map<Integer, Integer> dataMap = new HashMap<>(sysRolePrivileges.size());
        for (SysRolePrivilege sysRolePrivilege : sysRolePrivileges) {
            dataMap.put(sysRolePrivilege.getSrpPrivilegeId(), sysRolePrivilege.getSrpRoleId());
        }
        return dataMap;
    }

    /**
     * 设置模块下菜单
     *
     * @param sysPrivileges
     * @param layuiTreeNode
     * @param privilegers
     */
    private void setChildren(List<SysPrivilege> sysPrivileges, LayuiTreeNode layuiTreeNode,
                             Map<Integer, Integer> privilegers) {
        List<LayuiTreeNode> childrens = new ArrayList<>();
        for (SysPrivilege sysPrivilege : sysPrivileges) {
            if (sysPrivilege.getSpParentId().equals(layuiTreeNode.getId())) {
                LayuiTreeNode children = new LayuiTreeNode();
                children.setId(sysPrivilege.getSpId());
                children.setTitle(sysPrivilege.getSpName());
                children.setSpread(true);
                setChildren(sysPrivileges, children, privilegers);

                if (CollUtil.isEmpty(children.getChildren())) {
                    // 没有子节点,将当前角色拥有的权限选中,layui tree 要求最后一级字节点设置checked才会显示选中
                    // 如果父节点，子节点都设置会没有效果
                    if (privilegers.containsKey(sysPrivilege.getSpId())) {
                        children.setChecked(true);
                    }
                }
                childrens.add(children);
            }
        }

        if (CollUtil.isNotEmpty(childrens)) {
            layuiTreeNode.setChildren(childrens);
        }
    }

    /**
     * 设置子节点内容
     *
     * @param sysPrivileges  系统权限集合
     * @param treeSelectNode 前端treeSelect插件所需格式对象
     */
    private void setChildren(List<SysPrivilege> sysPrivileges, TreeSelectNode treeSelectNode) {
        List<TreeSelectNode> childrens = new ArrayList<>();
        for (SysPrivilege sysPrivilege : sysPrivileges) {
            if (sysPrivilege.getSpType() == Constant.MENU_PRIVILEGE_TYPE &&
                    sysPrivilege.getSpParentId().equals(treeSelectNode.getId())) {
                TreeSelectNode childrenTreeSelectNode = new TreeSelectNode();
                childrenTreeSelectNode.setId(sysPrivilege.getSpId());
                childrenTreeSelectNode.setName(sysPrivilege.getSpName());

                // 递归设置子节点内容
                setChildren(sysPrivileges, childrenTreeSelectNode);

                childrens.add(childrenTreeSelectNode);
            }
        }

        if (CollUtil.isNotEmpty(childrens)) {
            treeSelectNode.setChildren(childrens);
        }
    }

    /**
     * 获取系统菜单
     *
     * @return 系统菜单集合
     */
    private List<SysPrivilege> getSysMenu() {
        SysPrivilegeExample example = new SysPrivilegeExample();
        example.createCriteria()
                .andSpTypeIn(Arrays.asList(Constant.MODULE_PRIVILEGE_TYPE, Constant.MENU_PRIVILEGE_TYPE));
        example.setOrderByClause("sp_orderd");
        return this.selectByExample(example);
    }

    @Override
    public LayuiResult allotPrivilege(List<SysRolePrivilege> sysRolePrivileges) {
        // 为了简便,不修改对应权限,直接先删除该角色原先拥有的权限再添加现在重新分配的
        if (CollUtil.isEmpty(sysRolePrivileges)) {
            // 前端已处理,不能提交非空权限,为了程序的更加严谨,在后台再做一次处理
            return LayuiResult.error(CodeMsgEnum.PRIVILEGE_IS_NULL);
        }
        SysRolePrivilege sysRolePrivilege = sysRolePrivileges.get(0);
        Integer roleId = sysRolePrivilege.getSrpRoleId();
        SysRolePrivilegeExample example = new SysRolePrivilegeExample();
        example.createCriteria()
                .andSrpRoleIdEqualTo(roleId);
        this.sysRolePrivilegeMapper.deleteByExample(example);

        this.sysRolePrivilegeMapper.insertBatch(sysRolePrivileges);
        return LayuiResult.success();
    }

    @Override
    public AllotButtonTransfer getTransferData(Integer menuId) {
        // 获得该菜单下所拥有的按钮权限,并处理url取出按钮名称
        SysPrivilegeExample example = new SysPrivilegeExample();
        example.setOrderByClause("sp_orderd");
        example.createCriteria()
                .andSpParentIdEqualTo(menuId)
                .andSpTypeEqualTo(Constant.BUTTON_PRIVILEGE_TYPE);
        List<SysPrivilege> sysPrivileges = super.selectByExample(example);

        // 取出菜单下所有操作名
        List<String> buttonNames = sysPrivileges.stream()
                .map(SysPrivilege::getSpOperateName)
                .collect(Collectors.toList());

        // 获取系统所有的按钮
        SysOperateExample sysOperateExample = new SysOperateExample();
        sysOperateExample.setOrderByClause("so_orderd");
        List<SysOperate> sysOperates = this.sysOperateService.selectByExample(sysOperateExample);

        AllotButtonTransfer allotButtonTransfer = new AllotButtonTransfer();
        List<AllotButtonTransfer.Transfer> data = allotButtonTransfer.getData();
        List<String> rightSelectData = allotButtonTransfer.getRightSelectData();
        for (SysOperate sysOperate : sysOperates) {
            AllotButtonTransfer.Transfer transfer = new AllotButtonTransfer.Transfer();
            transfer.setValue(sysOperate.getSoName());
            transfer.setTitle(sysOperate.getSoShowName());
            data.add(transfer);
            if (buttonNames.contains(sysOperate.getSoName())) {
                // 该菜单下有该按钮，初始化右侧选中数据
                rightSelectData.add(sysOperate.getSoName());
            }
        }
        return allotButtonTransfer;
    }

    @Override
    public LayuiResult allotButton(List<SysPrivilege> newSysPrivileges) {
        // 说明下这里为啥不简单处理，直接删除原先的权限再把选择的新权限添加进去,主要是权限关联着角色权限表
        // 如果简单删除那么假设用户选择的新权限和原有一致会导致吧原有的权限给删除掉

        // 这里的按钮权限不可能为空,前端做了控制所以可以放心的取第一条数据
        SysPrivilege sysPrivilege = newSysPrivileges.get(0);
        SysPrivilegeExample example = new SysPrivilegeExample();
        example.createCriteria()
                .andSpParentIdEqualTo(sysPrivilege.getSpId())
                .andSpTypeEqualTo(Constant.BUTTON_PRIVILEGE_TYPE);
        List<SysPrivilege> oldSysPrivileges = super.selectByExample(example);
        if (CollUtil.isEmpty(oldSysPrivileges)) {
            // 该菜单原来没有分配按钮,那么用户选择的新权限都添加权限表中
            for (SysPrivilege newSysPrivilege : newSysPrivileges) {
                if (StrUtil.isBlank(newSysPrivilege.getSpOperateName())) {
                    // 操作名为空，跳出本次循环
                    continue;
                }

                this.addSysPrivilege(newSysPrivilege);
            }
            return LayuiResult.success();
        }

        // 该菜单原先已有权限,对比现在用户新选择的权限判断是删除,还是需要新增
        // 获取菜单下对应按钮权限id
        List<Integer> buttonPrivilegeIds = oldSysPrivileges.stream()
                .map(SysPrivilege::getSpId)
                .collect(Collectors.toList());
        if (newSysPrivileges.size() == 1 && StrUtil.isBlank(newSysPrivileges.get(0).getSpOperateName())) {
            // 用户没有选择新的权限过来,说明用户想要删除原先所有的权限
            SysPrivilegeExample sysPrivilegeExample = new SysPrivilegeExample();
            sysPrivilegeExample.createCriteria()
                    .andSpParentIdEqualTo(newSysPrivileges.get(0).getSpId())
                    .andSpTypeEqualTo(Constant.BUTTON_PRIVILEGE_TYPE);
            super.deleteByExample(sysPrivilegeExample);

            // 权限都删除了,权限角色关系表也就没有存在的必要,同步删除角色权限关系表
            SysRolePrivilegeExample sysRolePrivilegeExample = new SysRolePrivilegeExample();
            sysRolePrivilegeExample.createCriteria()
                    .andSrpPrivilegeIdIn(buttonPrivilegeIds);
            this.sysRolePrivilegeMapper.deleteByExample(sysRolePrivilegeExample);
            return LayuiResult.success();
        }

        // 用户选择的选择了新的权限,对比是需要新增,还是删除 add delete   add edit
        List<SysPrivilege> addPrivileges = new ArrayList<>();
        List<SysPrivilege> deletePrivileges = new ArrayList<>();
        boolean same = false;
        for (SysPrivilege newSysPrivilege : newSysPrivileges) {
            for (SysPrivilege oldSysPrivilege : oldSysPrivileges) {
                // 这个循环是找出删除或新增集合的主要的核心逻辑,需多理解
                if (newSysPrivilege.getSpOperateName().equals(oldSysPrivilege.getSpOperateName())) {
                    // 选择的权限与原先一致,没有改变无需处理
                    deletePrivileges.add(oldSysPrivilege);
                    same = true;
                    break;
                }
            }

            if (same) {
                same = false;
                continue;
            }
            addPrivileges.add(newSysPrivilege);
        }

        // 删除原有的而现在用户已取消的权限
        oldSysPrivileges.removeAll(deletePrivileges);
        for (SysPrivilege oldSysPrivilege : oldSysPrivileges) {
            super.deleteByPrimaryKey(oldSysPrivilege.getSpId());

            // 权限都删除了,权限角色关系表也就没有存在的必要,同步删除角色权限关系表
            SysRolePrivilegeExample sysRolePrivilegeExample = new SysRolePrivilegeExample();
            sysRolePrivilegeExample.createCriteria()
                    .andSrpPrivilegeIdEqualTo(oldSysPrivilege.getSpId());
            this.sysRolePrivilegeMapper.deleteByExample(sysRolePrivilegeExample);
        }

        // 添加用户新增的权限
        for (SysPrivilege privilege : addPrivileges) {
            addSysPrivilege(privilege);
        }
        return LayuiResult.success();
    }

    /**
     * 添加系统权限
     *
     * @param sysPrivilege
     * @return
     */
    private void addSysPrivilege(SysPrivilege sysPrivilege) {
        SysPrivilege privilege = new SysPrivilege();
        privilege.setSpName(sysPrivilege.getSpName());

        // eg : /sysUser/list => /sysUser/add
        String buttonUrl = StrUtil.format("{}/{}"
                , StrUtil.subBefore(sysPrivilege.getSpUri(), StrUtil.SLASH, true)
                , sysPrivilege.getSpOperateName()
        );

        privilege.setSpUri(buttonUrl);
        privilege.setSpType(Constant.BUTTON_PRIVILEGE_TYPE);
        privilege.setSpOperateName(sysPrivilege.getSpOperateName());
        privilege.setSpParentId(sysPrivilege.getSpId());
        privilege.setSpCreateTime(new Date());
        privilege.setSpUpdateTime(new Date());
        super.insertSelective(privilege);
    }


}
