package com.bearcat2.web.interceptor;

import cn.hutool.json.JSONUtil;
import com.bearcat2.entity.common.LayuiResult;
import com.bearcat2.entity.common.LoginUser;
import com.bearcat2.entity.system.SysPrivilege;
import com.bearcat2.enumeration.CodeMsgEnum;
import com.bearcat2.util.CommonUtil;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.Set;

/**
 * <p>Description: 权限校验拦截器</p>
 * <p>Title: PrivilegeVerifyInterceptor </p>
 * <p>Create Time: 2018/8/16 20:07 </p>
 *
 * @author: zhongzhipeng
 * @version: 1.0
 */
@Component
public class PrivilegeVerifyInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 注意权限拦截器需配置在登录拦截器后, 程序走到这儿说明用户已登录

        // 从当前请求中取出当前请求url资源,这里要注意因为权限表里配置的都是控制器访问路径,即不带项目名所以取出 servletPath当前访问的serlvet路径
        String requestUri = request.getServletPath();

        // 注意这里有个小细节,当前请求的url在权限表中没有配置,说明该url不受控制直接放行
        LoginUser loginUser = CommonUtil.getLoginUser(request);
        Map<String, Integer> privilegeMap = loginUser.getPrivilegeMap();
        if (!privilegeMap.containsKey(requestUri)) {
            // 当前访问路径在权限表中没有配置,即该路径不受控制，直接放行
            return true;
        }

        // 取出当前登录用户所拥有的权限,判断当前访问url是否有权访问,如果有权限则放行,否则拦截下来提示用户无权访问
        Set<SysPrivilege> userPrivileges = loginUser.getUserPrivileges();
        for (SysPrivilege userPrivilege : userPrivileges) {
            if (requestUri.equals(userPrivilege.getSpUri())) {
                // 当前登录用户具有访问该资源的权限,直接放行
                return true;
            }
        }

        //  当前登录用户没有访问该资源的权限,拦截跳转到无权访问界面,这里判断下用户访问的url是返回的界面,还是json串
        if (!(handler instanceof HandlerMethod)) {
            // 其实第三个参数就是HandlerMethod 处理器方法,为了程序严谨性还是做下判断
            request.getRequestDispatcher("/refuse").forward(request, response);
            return false;
        }

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Class<?> handlerClass = handlerMethod.getBean().getClass();
        if (handlerClass.isAnnotationPresent(RestController.class) ||
                handlerClass.isAnnotationPresent(ResponseBody.class) ||
                handlerMethod.getMethod().isAnnotationPresent(ResponseBody.class)) {
            // 控制器类上标有 RestController或ResponseBody注解或 控制器方法上标有ResponseBody说明需要访问json格式数据
            LayuiResult error = LayuiResult.error(CodeMsgEnum.NO_ACCESS_PRIVILEGE);
            response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
            response.getWriter().write(JSONUtil.toJsonStr(error));
            return false;
        }

        // 走到这儿,说明请求路径需要返回一个界面
        request.getRequestDispatcher("/refuse").forward(request, response);
        return false;
    }


}
