package com.bearcat2.web.controller.system;

import cn.hutool.core.util.StrUtil;
import com.bearcat2.entity.common.Constant;
import com.bearcat2.entity.common.LayuiResult;
import com.bearcat2.entity.system.SysUser;
import com.bearcat2.enumeration.CodeMsgEnum;
import com.bearcat2.service.system.SysRoleService;
import com.bearcat2.service.system.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * <p>Description: 系统用户控制器</p>
 * <p>Title: SysUserController </p>
 * <p>Create Time: 2018/8/16 15:12 </p>
 *
 * @author: zhongzhipeng
 * @version: 1.0
 */
@Controller
@RequestMapping("/sysUser")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysRoleService sysRoleService;

    @GetMapping("/doLogin")
    public String doLogin() {
        return "login";
    }

    @ResponseBody
    @PostMapping("/login")
    public LayuiResult login(String username, String password, String clientCaptcha, HttpSession session) {
        String serverCaptcha = (String) session.getAttribute(Constant.CAPTCHA_SESSION_ATTR);
        if (StrUtil.hasBlank(serverCaptcha, clientCaptcha) || !serverCaptcha.equalsIgnoreCase(clientCaptcha)) {
            return LayuiResult.error(CodeMsgEnum.CAPTCHA_ERROR);
        }
        LayuiResult LayuiResult = this.sysUserService.login(username, password);
        if (LayuiResult.getCode() == CodeMsgEnum.SUCCESS.getCode()) {
            // 往session存入用户登录标记
            session.setAttribute(Constant.LOGIN_USER_SESSION_ATTR, LayuiResult.getData());
        }
        return LayuiResult;
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        // 移除session标记
        session.removeAttribute(Constant.LOGIN_USER_SESSION_ATTR);
        return "redirect:/sysUser/doLogin";
    }

    @GetMapping("/list")
    public String listUi() {
        return "system/user/list";
    }

    @ResponseBody
    @PostMapping("/list")
    public LayuiResult list(SysUser sysUser) {
        return this.sysUserService.list(sysUser);
    }

    @GetMapping(value = {"/edit", "/basicInfo"})
    public String editUi(SysUser sysUser, Model model) {
        model.addAttribute("sysUser", this.sysUserService.selectByPrimaryKey(sysUser.getSuId()));
        model.addAttribute("roles", this.sysRoleService.findAll());
        model.addAttribute("sysUserRoles", this.sysUserService.findByUserId(sysUser.getSuId()));
        return "system/user/edit";
    }

    @ResponseBody
    @PostMapping("/edit")
    public LayuiResult edit(SysUser sysUser, Integer roleId) {
        return this.sysUserService.edit(sysUser, roleId);
    }

    @GetMapping(value = "/detail")
    public String detailUi(SysUser sysUser, Model model) {
        model.addAttribute("sysUser", this.sysUserService.selectByPrimaryKey(sysUser.getSuId()));
        return "system/user/detail";
    }

    @GetMapping("/add")
    public String addUi(Model model) {
        model.addAttribute("roles", this.sysRoleService.findAll());
        return "system/user/add";
    }

    @ResponseBody
    @PostMapping("/add")
    public LayuiResult add(SysUser sysUser, Integer roleId) {
        return this.sysUserService.add(sysUser, roleId);
    }

    @ResponseBody
    @PostMapping("/delete")
    public LayuiResult delete(SysUser sysUser) {
        this.sysUserService.deleteByPrimaryKey(sysUser.getSuId());
        return LayuiResult.success();
    }

    @GetMapping("/updatePassword")
    public String updatePasswordUi(Integer suId, Model model) {
        model.addAttribute("sysUser", this.sysUserService.selectByPrimaryKey(suId));
        return "system/user/updatePassword";
    }

    @ResponseBody
    @PostMapping("/updatePassword")
    public LayuiResult updatePassword(SysUser sysUser, String newPassword,HttpSession session) {
        LayuiResult layuiResult = this.sysUserService.updatePassword(sysUser, newPassword);
        if(layuiResult.getCode() == CodeMsgEnum.SUCCESS.getCode()){
            // 修改密码成功移除登录标记重新登录
            session.removeAttribute(Constant.LOGIN_USER_SESSION_ATTR);
        }
        return layuiResult;
    }
}
