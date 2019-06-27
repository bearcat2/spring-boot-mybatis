package com.bearcat2.web.controller.system;

import com.bearcat2.entity.common.LayuiResult;
import com.bearcat2.entity.common.LoginUser;
import com.bearcat2.entity.system.SysOperate;
import com.bearcat2.service.system.SysOperateService;
import com.bearcat2.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * <p> Description: 系统管理控制器 </p>
 * <p> Title: SysOperateController </p>
 * <p> Create Time: 2019/6/26 18:31 </p>
 *
 * @author: zhongzhipeng
 * @version: 1.0
 */
@Controller
@RequestMapping("/sysOperate")
public class SysOperateController {

    @Autowired
    private SysOperateService sysOperateService;

    @GetMapping("/list")
    public String listUi() {
        return "system/operate/list";
    }

    @ResponseBody
    @PostMapping("/list")
    public LayuiResult list(SysOperate sysOperate) {
        return this.sysOperateService.list(sysOperate);
    }

    @GetMapping("/add")
    public String addUi() {
        return "system/operate/add";
    }

    @ResponseBody
    @PostMapping("/add")
    public LayuiResult add(SysOperate sysOperate, HttpSession session) {
        LoginUser loginUser = CommonUtil.getLoginUser(session);
        sysOperate.setSoCreateTime(new Date());
        sysOperate.setSoCreateUser(loginUser.getRealName());
        sysOperate.setSoUpdateTime(new Date());
        sysOperate.setSoUpdateUser(loginUser.getRealName());
        this.sysOperateService.insertSelective(sysOperate);
        return LayuiResult.success();
    }

    @GetMapping("/edit")
    public String editUi(SysOperate sysOperate, Model model) {
        model.addAttribute("operate", this.sysOperateService.selectByPrimaryKey(sysOperate.getSoId()));
        return "system/operate/edit";
    }

    @ResponseBody
    @PostMapping("/edit")
    public LayuiResult edit(SysOperate sysOperate, HttpSession session) {
        LoginUser loginUser = CommonUtil.getLoginUser(session);
        sysOperate.setSoUpdateTime(new Date());
        sysOperate.setSoUpdateUser(loginUser.getRealName());
        this.sysOperateService.updateByPrimaryKeySelective(sysOperate);
        return LayuiResult.success();
    }

    @ResponseBody
    @PostMapping("/delete")
    public LayuiResult delete(SysOperate sysOperate) {
        this.sysOperateService.deleteByPrimaryKey(sysOperate.getSoId());
        return LayuiResult.success();
    }
}
