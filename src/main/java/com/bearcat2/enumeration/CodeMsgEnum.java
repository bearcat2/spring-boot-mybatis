package com.bearcat2.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <p> Description: 统一定义系统响应码及对应响应信息的枚举类 </p>
 * <p> Title: CodeMsgEnum </p>
 * <p> Create Time: 2019/5/11 22:19 </p>
 *
 * @author: zhongzhipeng
 * @version: 1.0
 */
@Getter
@AllArgsConstructor
public enum CodeMsgEnum {

    SUCCESS(0, "响应成功"),
    SERVER_ERROR(500, "服务端错误"),

    // 用户相关错误吗
    LOGIN_ERROR(100, "用户名或密码错误"),
    CAPTCHA_ERROR(101, "验证码错误"),
    PRIVILEGE_IS_NULL(102, "您没有选中任何权限,无法提交"),
    NO_ACCESS_PRIVILEGE(401, "无权限访问,请联系管理员");

    /** 响应码 */
    private int code;

    /** 响应消息 */
    private String msg;

}
