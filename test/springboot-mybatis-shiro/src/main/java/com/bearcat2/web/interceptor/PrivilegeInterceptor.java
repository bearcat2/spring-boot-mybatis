package com.bearcat2.web.interceptor;

import com.bearcat2.entity.common.Constant;
import com.bearcat2.entity.common.LoginUser;
import com.bearcat2.entity.system.SysPrivilege;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Set;

/**
 * <p>Description: 权限拦截器</p>
 * <p>Title: PrivilegeInterceptor </p>
 * <p>Create Time: 2018/8/16 20:07 </p>
 *
 * @author: zhongzhipeng
 * @version: 1.0
 */
public class PrivilegeInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String requestURI = httpServletRequest.getServletPath();

        // 从当前登录的用户中取出权限集合,判断当前访问的uri是否允许访问
        // 如果不允许则跳到无权访问页面,如果允许则直接放行
        LoginUser loginUser = (LoginUser) httpServletRequest.getSession().getAttribute(Constant.LOGIN_USER_SESSION_ATTR);
        Set<SysPrivilege> privileges = loginUser.getPrivileges();
        for (SysPrivilege privilege : privileges) {
            //add_ui   add
            if (requestURI.contains("_") && "ui".equalsIgnoreCase(requestURI.split("_")[1])) {
                requestURI = requestURI.split("_")[0];
            }

            if (requestURI.equals(privilege.getSpUri())) {
                // 有权限访问,直接放行 shiro  spring security
                return true;
            }
        }
        // 走到这说明用户访问的路径无权访问跳转到无权访问页面
        httpServletRequest.getRequestDispatcher("/refuse.html").forward(httpServletRequest, httpServletResponse);
        return false;
    }


}
