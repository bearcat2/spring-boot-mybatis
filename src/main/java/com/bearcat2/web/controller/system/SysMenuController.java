package com.bearcat2.web.controller.system;

import com.bearcat2.entity.common.AllotButtonTransfer;
import com.bearcat2.entity.common.LayuiResult;
import com.bearcat2.entity.common.TreeSelectNode;
import com.bearcat2.entity.common.TreeTableNode;
import com.bearcat2.entity.system.SysPrivilege;
import com.bearcat2.service.system.SysPrivilegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>Description: 系统菜单 </p>
 * <p>Title: SysPrivilegeController </p>
 * <p>Create Time: 2018/8/17 19:05 </p>
 *
 * @author: zhongzhipeng
 * @version: 1.0
 */
@Controller
@RequestMapping("/sysMenu")
public class SysMenuController {

    @Autowired
    private SysPrivilegeService sysPrivilegeService;


    @GetMapping("/list")
    public String listUi() {
        return "system/menu/list";
    }

    @ResponseBody
    @PostMapping("/list")
    public List<TreeTableNode> list() {
        return this.sysPrivilegeService.getTreeTableNode();
    }

    @GetMapping("/edit")
    public String editUi(TreeTableNode treeTableNode, Model model) {
        SysPrivilege sysPrivilege = this.sysPrivilegeService.findById(treeTableNode.getId());
        model.addAttribute("menu", sysPrivilege);
        return "system/menu/edit";
    }

    @ResponseBody
    @PostMapping("/edit")
    public LayuiResult edit(SysPrivilege sysPrivilege) {
        this.sysPrivilegeService.update(sysPrivilege);
        return LayuiResult.success();
    }

    @GetMapping("/add")
    public String addUi() {
        return "system/menu/add";
    }

    @ResponseBody
    @PostMapping("/add")
    public LayuiResult add(SysPrivilege sysPrivilege) {
        this.sysPrivilegeService.insert(sysPrivilege);
        return LayuiResult.success();
    }

    @ResponseBody
    @PostMapping("/delete")
    public LayuiResult delete(TreeTableNode treeTableNode) {
        this.sysPrivilegeService.deleteById(treeTableNode.getId());
        return LayuiResult.success();
    }

    @ResponseBody
    @PostMapping("/getTreeSelectNode")
    public List<TreeSelectNode> getTreeSelectNode() {
        return this.sysPrivilegeService.getTreeSelectNode();
    }

    @ResponseBody
    @PostMapping("/getTransferData")
    public AllotButtonTransfer getTransferData(Integer menuId) {
        return this.sysPrivilegeService.getTransferData(menuId);
    }

    @ResponseBody
    @PostMapping("/allotButton")
    public LayuiResult allotButton(@RequestBody List<SysPrivilege> sysPrivileges) {
        return this.sysPrivilegeService.allotButton(sysPrivileges);
    }
}
