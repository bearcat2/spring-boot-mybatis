package com.bearcat2.util;


import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * <p> Description: 不依赖web模块的对象从当前请求中获取 servlet 相关的请求响应对象 </p>
 * <p> Title: RequestContextHolderUtil </p>
 * <p> Create Time: 2018/12/4 9:58 </p>
 *
 * @author: zhongzhipeng
 * @version: 1.0
 */
public class RequestContextHolderUtil {

    /**
     * 从当前请求中获取request对象,不依赖web模块传递的对象,与web模块彻底解耦
     *
     * @return 返回 - HttpServletRequest
     */
    public static HttpServletRequest getRequest() {
        return getRequestAttributes().getRequest();
    }

    /**
     * 从当前请求中获取response对象,不依赖web模块传递的对象,与web模块彻底解耦
     *
     * @return 返回 - HttpServletResponse
     */
    public static HttpServletResponse getResponse() {
        return getRequestAttributes().getResponse();
    }

    /**
     * 从当前请求中获取session对象,不依赖web模块传递的对象,与web模块彻底解耦
     *
     * @return 返回 - HttpSession
     */
    public static HttpSession getSession() {
        return getRequest().getSession(false);
    }

    /**
     * 从spring容器中获取封装了 servlet 相关容器对象(HttpSession,HttpServletRequest,HttpServletResponse)
     *
     * @return 返回 - ServletRequestAttributes
     */
    public static ServletRequestAttributes getRequestAttributes() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes());
    }

    /**
     * 从spring容器中获取servlet上下文容器
     *
     * @return 返回servlet上下文容器 - ServletContext
     */
    public static ServletContext getServletContext() {
        return ContextLoader.getCurrentWebApplicationContext().getServletContext();
    }
}