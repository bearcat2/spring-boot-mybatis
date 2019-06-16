package com.bearcat2.web.controller.system;

import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import com.bearcat2.entity.common.Constant;
import com.bearcat2.entity.common.LayuiResult;
import com.bearcat2.entity.system.SysUser;
import com.bearcat2.enumeration.CodeMsgEnum;
import com.bearcat2.service.system.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;

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
        session.removeAttribute("loginUser");
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

    @GetMapping(value = "/edit_ui")
    public String editUi(SysUser sysUser, Model model) {
        model.addAttribute("sysUser", this.sysUserService.selectByPrimaryKey(sysUser.getSuId()));
        return "system/user/edit";
    }

    @ResponseBody
    @PostMapping("/edit")
    public LayuiResult edit(SysUser sysUser) {
        sysUser.setSuUpdateTime(new Date());
        this.sysUserService.updateByPrimaryKeySelective(sysUser);
        return LayuiResult.success();
    }

    @GetMapping(value = "/detail")
    public String detailUi(SysUser sysUser, Model model) {
        model.addAttribute("sysUser", this.sysUserService.selectByPrimaryKey(sysUser.getSuId()));
        return "system/user/detail";
    }

    @GetMapping("/add_ui")
    public String addUi() {
        return "system/user/add";
    }

    @ResponseBody
    @PostMapping("/add")
    public LayuiResult add(SysUser sysUser) {
        sysUser.setSuCreateTime(new Date());
        sysUser.setSuUpdateTime(new Date());
        sysUser.setSuPassword(SecureUtil.md5(sysUser.getSuPassword()));
        this.sysUserService.insertSelective(sysUser);
        return LayuiResult.success();
    }

    @ResponseBody
    @PostMapping("/delete")
    public LayuiResult delete(SysUser sysUser) {
        this.sysUserService.deleteByPrimaryKey(sysUser.getSuId());
        return LayuiResult.success();
    }
}