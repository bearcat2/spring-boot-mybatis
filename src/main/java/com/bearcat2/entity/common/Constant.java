package com.bearcat2.entity.common;

/**
 * <p> Description: 系统常量类 </p>
 * <p> Title: Constant </p>
 * <p> Create Time: 2019/6/14 22:49 </p>
 *
 * @author zhongzhipeng
 * @since 1.0
 */
public class Constant {

    /** 验证码 session属性 */
    public static final String CAPTCHA_SESSION_ATTR = "captcha";

    /** 登录用户 session属性 */
    public static final String LOGIN_USER_SESSION_ATTR = "loginUser";

    /** yyyy-MM-dd'T'HH:mm:ss 日期格式 */
    public static final String DATA_T_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss";

    /** 权限类型为模块 */
    public static final int MODULE_PRIVILEGE_TYPE = 1;

    /** 权限类型为菜单 */
    public static final int MENU_PRIVILEGE_TYPE = 2;

    /** 权限类型为按钮 */
    public static final int BUTTON_PRIVILEGE_TYPE = 3;
}
