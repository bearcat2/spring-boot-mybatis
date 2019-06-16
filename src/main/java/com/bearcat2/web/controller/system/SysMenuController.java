package com.bearcat2.web.controller.system;

import com.bearcat2.entity.common.LayuiResult;
import com.bearcat2.entity.common.TreeTableNode;
import com.bearcat2.entity.system.SysPrivilege;
import com.bearcat2.service.system.SysPrivilegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
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
        return this.sysPrivilegeService.getMenu();
    }

    @GetMapping("/edit_ui")
    public String editUi(TreeTableNode treeTableNode, Model model) {
        model.addAttribute("menu", this.sysPrivilegeService.selectByPrimaryKey(treeTableNode.getId()));
        return "system/menu/edit";
    }

    @ResponseBody
    @PostMapping("/edit")
    public LayuiResult edit(SysPrivilege sysPrivilege) {
        sysPrivilege.setSpUpdateTime(new Date());
        this.sysPrivilegeService.updateByPrimaryKeySelective(sysPrivilege);
        return LayuiResult.success();
    }

    @GetMapping("/add_ui")
    public String addUi() {
        return "system/menu/add";
    }

    @ResponseBody
    @PostMapping("/add")
    public LayuiResult add(SysPrivilege sysPrivilege) {
        sysPrivilege.setSpCreateTime(new Date());
        sysPrivilege.setSpUpdateTime(new Date());
        this.sysPrivilegeService.insertSelective(sysPrivilege);
        return LayuiResult.success();
    }

    @ResponseBody
    @PostMapping("/delete")
    public LayuiResult delete(TreeTableNode treeTableNode) {
        this.sysPrivilegeService.deleteByPrimaryKey(treeTableNode.getId());
        return LayuiResult.success();
    }
}
