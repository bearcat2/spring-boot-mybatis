package com.bearcat2.web.controller.system;

import com.bearcat2.entity.common.LayuiResult;
import com.bearcat2.entity.system.SysRole;
import com.bearcat2.entity.system.SysUserRole;
import com.bearcat2.service.system.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>Description: 系统角色的控制器 </p>
 * <p>Title: SysRoleController </p>
 * <p>Create Time: 2018/8/17 19:06 </p>
 *
 * @author: zhongzhipeng
 * @version: 1.0
 */
@Controller
@RequestMapping("/sysRole")
public class SysRoleController {

    @Autowired
    private SysRoleService sysRoleService;

    @GetMapping("/list")
    public String listUi() {
        return "system/role/list";
    }

    @ResponseBody
    @PostMapping("/list")
    public LayuiResult list(SysRole sysRole) {
        return this.sysRoleService.list(sysRole);
    }

    @GetMapping("/edit_ui")
    public String editUi(SysRole sysRole, Model model) {
        model.addAttribute("role", this.sysRoleService.selectByPrimaryKey(sysRole.getSrId()));
        return "system/role/edit";
    }

    @ResponseBody
    @PostMapping("/edit")
    public LayuiResult edit(SysRole sysRole) {
        sysRole.setSrUpdateTime(new Date());
        this.sysRoleService.updateByPrimaryKey(sysRole);
        return LayuiResult.success();
    }

    @GetMapping("/add_ui")
    public String addUi() {
        return "system/role/add";
    }

    @ResponseBody
    @PostMapping("/add")
    public LayuiResult add(SysRole sysRole) {
        sysRole.setSrCreateTime(new Date());
        sysRole.setSrUpdateTime(new Date());
        this.sysRoleService.insertSelective(sysRole);
        return LayuiResult.success();
    }

    @ResponseBody
    @PostMapping("/delete")
    public LayuiResult delete(SysRole sysRole) {
        this.sysRoleService.deleteByPrimaryKey(sysRole.getSrId());
        return LayuiResult.success();
    }

    @GetMapping("/allotSysRole_ui")
    public String allotSysRoleUi(Integer userId, Model model) {
        model.addAttribute("all_role", this.sysRoleService.findAll());
        List<Integer> integers = new ArrayList<>();
        for (SysUserRole sysUserRole : this.sysRoleService.findByUserId(userId)) {
            integers.add(sysUserRole.getSurRoleId());
        }
        model.addAttribute("userId", userId);
        //model.addAttribute("have_role", StringUtils.join(integers, ','));
        return "system/role/allotSysRole";
    }

    @ResponseBody
    @PostMapping("/allotSysRole")
    public LayuiResult allotSysRole(Integer userId, String roleIds) {
        this.sysRoleService.allotSysRole(userId, roleIds);
        return LayuiResult.success();
    }
}
