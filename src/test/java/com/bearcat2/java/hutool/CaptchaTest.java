package com.bearcat2.java.hutool;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.setting.dialect.Props;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Date;
import java.util.Enumeration;

/**
 * <p> Description: 验证码测试类 </p>
 * <p> Title: CaptchaTest </p>
 * <p> Create Time: 2019/6/14 22:32 </p>
 *
 * @author: zhongzhipeng
 * @version: 1.0
 */
@Slf4j
public class CaptchaTest {

    @Test
    public void test() throws Exception {
        LineCaptcha captcha = CaptchaUtil.createLineCaptcha(80, 38, 4, 120);
        captcha.write("D:/captcha.png");
        log.info("图片验证码={}", captcha.getCode());
    }

    @Test
    public void test1() throws Exception {
        Props props = new Props("config/anonymousUrls.properties");
        Enumeration<?> enumeration = props.propertyNames();
        while (enumeration.hasMoreElements()) {
            String o = (String) enumeration.nextElement();
            System.out.println(o);
        }
    }

    @Test
    public void test2() throws Exception {
        String format = DateUtil.format(new Date(), DatePattern.UTC_FORMAT);
        System.out.println(format);
    }
    
    @Test
    public void test3() throws Exception{
        System.out.println(StrUtil.subAfter("/sysUser/add", StrUtil.SLASH, true));
    }
}
