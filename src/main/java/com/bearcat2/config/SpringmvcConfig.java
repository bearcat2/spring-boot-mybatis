package com.bearcat2.config;

import com.bearcat2.util.CommonUtil;
import com.bearcat2.web.converter.DateConverter;
import com.bearcat2.web.interceptor.LoginInterceptor;
import com.bearcat2.web.interceptor.PrivilegeInterceptor;
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
        // 增加登录及权限验证的拦截器
        List<String> anonymousUrls = CommonUtil.getPropertyNames("config/anonymousUrls.properties");
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns(anonymousUrls);

        registry.addInterceptor(new PrivilegeInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns(anonymousUrls);
    }

}
