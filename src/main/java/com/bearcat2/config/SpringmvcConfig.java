package com.bearcat2.config;

import com.bearcat2.util.CommonUtil;
import com.bearcat2.web.converter.DateConverter;
import com.bearcat2.web.interceptor.LoginInterceptor;
import com.bearcat2.web.interceptor.PrivilegeRefreshInterceptor;
import com.bearcat2.web.interceptor.PrivilegeVerifyInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * <p> Description: springmvc 配置类 </p>
 * <p> Title: SpringmvcConfig </p>
 * <p> Create Time: 2019/5/12 19:29 </p>
 *
 * @author: zhongzhipeng
 * @version: 1.0
 */
@Configuration
public class SpringmvcConfig implements WebMvcConfigurer {

    @Autowired
    private LoginInterceptor loginInterceptor;

    @Autowired
    private PrivilegeRefreshInterceptor privilegeRefreshInterceptor;

    @Autowired
    private PrivilegeVerifyInterceptor privilegeVerifyInterceptor;

    /**
     * 增加格式化转换器
     *
     * @param registry 格式化注册器
     */
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new DateConverter());
    }

    /**
     * 增加拦截器
     *
     * @param registry 拦截器注册器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 获取允许匿名访问路径
        List<String> anonymousUrls = CommonUtil.getPropertyNames("config/anonymousUrls.properties");

        // 注册登录拦截器
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns(anonymousUrls);
        // 注册权限刷新拦截器
        registry.addInterceptor(privilegeRefreshInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns(anonymousUrls);
        // 注册权限校验拦截器
        registry.addInterceptor(privilegeVerifyInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns(anonymousUrls);
    }

}
