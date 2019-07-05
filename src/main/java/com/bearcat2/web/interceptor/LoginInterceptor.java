package com.bearcat2.web.interceptor;

import com.bearcat2.entity.common.LoginUser;
import com.bearcat2.util.CommonUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>Description: 登录的拦截器 </p>
 * <p>Title: LoginInterceptor </p>
 * <p>Create Time: 2018/8/16 15:36 </p>
 *
 * @author: zhongzhipeng
 * @version: 1.0
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        LoginUser loginUser = CommonUtil.getLoginUser(request);
        if (loginUser != null) {
            return true;
        }
        // 没有登录,返回到登录页去登录(返回脚本形式有个好处可以跳到顶层窗口,否则会内嵌在窗口内)
        String loginUrl = request.getContextPath() + "/sysUser/doLogin";
        String res = "<script>window.top.location.href='" + loginUrl + "';</script>";
        response.getWriter().write(res);
        return false;
    }
}
