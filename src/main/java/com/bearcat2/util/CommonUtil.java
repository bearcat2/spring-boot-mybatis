package com.bearcat2.util;

import cn.hutool.core.util.StrUtil;
import cn.hutool.setting.dialect.Props;
import com.bearcat2.entity.common.Constant;
import com.bearcat2.entity.common.LoginUser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * <p> Description: 系统通用工具类 </p>
 * <p> Title: CommonUtil </p>
 * <p> Create Time: 2019/5/11 22:43 </p>
 *
 * @author: zhongzhipeng
 * @version: 1.0
 */
public class CommonUtil {

    /**
     * 构建数据库 like 查询参数
     *
     * @param like 需要生成参数
     * @return 返回like 查询参数 - %like%
     */
    public static String buildLikeQueryParam(String like) {
        return StrUtil.format("%{}%", like);
    }

    /**
     * 将 list 转成 set
     *
     * @param dataList list集合数据
     * @return set 集合
     */
    public static <T> Set<T> listToSet(List<T> dataList) {
        return new HashSet<>(dataList);
    }

    /**
     * 获取属性文件中所有key集合
     *
     * @param path 属性文件路径
     * @return 属性文件key集合
     */
    public static List<String> getPropertyNames(String path) {
        List<String> propertyNames = new ArrayList<>();
        Props props = new Props(path);
        Enumeration<?> enumeration = props.propertyNames();
        while (enumeration.hasMoreElements()) {
            String key = (String) enumeration.nextElement();
            propertyNames.add(key);
        }
        return propertyNames;
    }

    /**
     * 从 request 中获取当前登录的用户
     *
     * @param request 当前请求对象
     * @return LoginUser - 当前登录的用户
     */
    public static LoginUser getLoginUser(HttpServletRequest request) {
        return getLoginUser(request.getSession());
    }

    /**
     * 从 session 中获取当前登录的用户
     *
     * @param session session会话
     * @return LoginUser - 当前登录的用户
     */
    public static LoginUser getLoginUser(HttpSession session) {
        return (LoginUser) session.getAttribute(Constant.LOGIN_USER_SESSION_ATTR);
    }

    /**
     * 控制浏览器不缓存响应内容
     *
     * @param response 响应对象
     */
    public static void noCache(HttpServletResponse response) {
        response.setDateHeader("expries", -1);
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
    }
}
