package com.bearcat2.web.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import com.bearcat2.entity.common.Constant;
import com.bearcat2.util.CommonUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * <p> Description: 系统首页控制器 </p>
 * <p> Title: IndexController </p>
 * <p> Create Time: 2019/5/12 21:21 </p>
 *
 * @author: zhongzhipeng
 * @version: 1.0
 */
@Controller
public class IndexController {

    @Value("${bearcat2.systemName}")
    private String systemName;

    @GetMapping(value = {"/", "/index"})
    public String index(Model model) {
        model.addAttribute("systemName", systemName);
        return "index";
    }

    @GetMapping(value = "/refuse")
    public String refuse() {
        return "refuse";
    }

    @GetMapping("/getCaptcha")
    public void getCaptcha(HttpServletResponse response, HttpSession session) throws Exception {
        // 创建验证码,并写入session中
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(80, 38, 4, 120);
        session.setAttribute(Constant.CAPTCHA_SESSION_ATTR, lineCaptcha.getCode());

        // 控制浏览器不缓存验证码,并将验证码写入浏览器
        CommonUtil.noCache(response);
        lineCaptcha.write(response.getOutputStream());
    }

}
