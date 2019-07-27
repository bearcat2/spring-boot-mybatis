package com.bearcat2.config;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p> Description: 模拟web项目中的web.xml文件,配置系统中所需的listener,filter,servlet等组件</p>
 * <p> Title: WebXmlConfig </p>
 * <p> Create Time: 2019/7/21 13:14 </p>
 *
 * @author zhongzhipeng
 * @since 1.0
 */
@Configuration
public class WebXmlConfig {

    @Value("${bearcat2.superUser.username}")
    private String superAdmin;

    @Value("${bearcat2.superUser.password}")
    private String superPassword;

    /**
     * druid web监控页 servlet
     * druid web监控页地址：http://localhost:8080/druid/index.html
     *
     * @return servlet registration bean
     */
    @Bean
    @SuppressWarnings("unchecked")
    public ServletRegistrationBean druidStatViewServlet() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(
                new StatViewServlet()
                , "/druid/*"
        );
        // 登录用户名
        servletRegistrationBean.addInitParameter("loginUsername", superAdmin);
        // 登录密码
        servletRegistrationBean.addInitParameter("loginPassword", superPassword);
        servletRegistrationBean.addInitParameter("resetEnable", "false");
        return servletRegistrationBean;
    }

    /**
     * druid web监控页 filter
     *
     * @return filter registration bean
     */
    @Bean
    @SuppressWarnings("unchecked")
    public FilterRegistrationBean druidStatFilter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
        // 添加过滤规则.
        filterRegistrationBean.addUrlPatterns("/*");
        // 添加不需要忽略的格式信息.
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return filterRegistrationBean;
    }

}
