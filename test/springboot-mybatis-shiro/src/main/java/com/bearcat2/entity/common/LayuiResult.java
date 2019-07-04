package com.bearcat2.entity.common;

import com.bearcat2.enumeration.CodeMsgEnum;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

/**
 * <p> Description: 封装前端Layui所需响应参数,避免从外面破坏对象内部结构,将构造方法私有并隐藏 setter 方法</p>
 * <p> Title: LayuiResult </p>
 * <p> Create Time: 2019/5/11 22:02 </p>
 *
 * @author: zhongzhipeng
 * @version: 1.0
 */
@Getter
// jackson 序列化忽略掉值为 null 的属性
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LayuiResult {
    /** 响应码 0 响应成功,非0失败 */
    private String code;

    /** 响应消息,系统发生错误时为对应的错误消息 */
    private String msg;

    /** 响应数据 */
    private Object data;

    /** 数据总数 */
    private Long count;

    public LayuiResult() {
    }

    private LayuiResult(CodeMsgEnum codeMsgEnum, Object data) {
        this.code = codeMsgEnum.getCode();
        this.msg = codeMsgEnum.getMsg();
        this.data = data;
    }

    private LayuiResult(CodeMsgEnum codeMsgEnum, Object data, Long count) {
        this(codeMsgEnum, data);
        this.count = count;
    }

    /**
     * 带响应数据和数据总数的成功回调方法
     *
     * @param data  响应数据
     * @param count 数据总数
     * @return LayuiResult - layui响应数据
     */
    public static LayuiResult success(Object data, Long count) {
        return new LayuiResult(CodeMsgEnum.SUCCESS, data, count);
    }

    /**
     * 带响应数据的成功回调方法
     *
     * @param data 响应数据
     * @return LayuiResult - layui响应数据
     */
    public static LayuiResult success(Object data) {
        return success(data, null);
    }

    /**
     * 不带参数的成功回调方法
     *
     * @return LayuiResult - layui响应数据
     */
    public static LayuiResult success() {
        return success("");
    }

    /**
     * 带响应码及消息枚举类和响应数据的失败回调方法
     *
     * @param codeMsgEnum 系统响应码及对应响应信息的枚举类
     * @param data        响应数据
     * @return LayuiResult - layui响应数据
     */
    public static LayuiResult error(CodeMsgEnum codeMsgEnum, Object data) {
        return new LayuiResult(codeMsgEnum, data);
    }

    /**
     * 带响应码及消息枚举类的失败回调方法
     *
     * @param codeMsgEnum 系统响应码及对应响应信息的枚举类
     * @return LayuiResult - layui响应数据
     */
    public static LayuiResult error(CodeMsgEnum codeMsgEnum) {
        return error(codeMsgEnum, "");
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "LayuiResult{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                ", count=" + count +
                '}';
    }
}
