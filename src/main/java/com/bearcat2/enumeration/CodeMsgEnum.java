package com.bearcat2.enumeration;

/**
 * <p> Description: 统一定义系统响应码及对应响应信息的枚举类 </p>
 * <p> Title: CodeMsgEnum </p>
 * <p> Create Time: 2019/5/11 22:19 </p>
 *
 * @author zhongzhipeng
 * @since 1.0
 */
public enum CodeMsgEnum {

    SUCCESS(0, "响应成功"),
    SERVER_ERROR(500, "服务端错误,请联系管理员"),
    CUSTOM_EXCEPTION(999, "自定义异常"),
    NO_ACCESS_PRIVILEGE(401, "权限不足操作拒绝,请联系管理员"),

    // 用户相关错误吗
    LOGIN_ERROR(100, "用户名或密码错误"),
    CAPTCHA_ERROR(101, "验证码错误"),
    PRIVILEGE_IS_NULL(102, "您没有选中任何权限,无法提交"),
    OLD_PASSWORD_ERROR(103, "原始密码错误"),
    REPEAT_PASSWORD_ERROR(103, "新密码不能与原密码一致");

    CodeMsgEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /** 响应码 */
    private int code;

    /** 响应消息 */
    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }}
