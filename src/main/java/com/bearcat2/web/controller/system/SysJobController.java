package com.bearcat2.web.controller.system;

import com.bearcat2.entity.common.LayuiResult;
import com.bearcat2.entity.system.SysJob;
import com.bearcat2.service.system.SysJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p> Description: 系统任务控制器 </p>
 * <p> Title: SysJobController </p>
 * <p> Create Time: 2019/7/14 15:46 </p>
 *
 * @author: zhongzhipeng
 * @version: 1.0
 */
@Controller
@RequestMapping("/sysJob")
public class SysJobController {

    @Autowired
    private SysJobService sysJobService;

    @GetMapping("/list")
    public String listUi() {
        return "system/job/list";
    }

    @ResponseBody
    @PostMapping("/list")
    public LayuiResult list(SysJob sysJob) {
        return this.sysJobService.list(sysJob);
    }

    @GetMapping("/add")
    public String addUi() {
        return "system/job/add";
    }

    @ResponseBody
    @PostMapping("/add")
    public LayuiResult add(SysJob sysJob) {
        this.sysJobService.insert(sysJob);
        return LayuiResult.success();
    }

    @ResponseBody
    @PostMapping("/updataStatus")
    public LayuiResult updataStatus(Integer id, Integer status) {
        this.sysJobService.updataStatusById(id,status);
        return LayuiResult.success();
    }

    @GetMapping("/edit")
    public String editUi(SysJob sysJob, Model model) {
        model.addAttribute("sysJob",this.sysJobService.findById(sysJob.getSjId()));
        return "system/job/edit";
    }

    @ResponseBody
    @PostMapping("/edit")
    public LayuiResult edit(SysJob sysJob) {
        this.sysJobService.update(sysJob);
        return LayuiResult.success();
    }
}
