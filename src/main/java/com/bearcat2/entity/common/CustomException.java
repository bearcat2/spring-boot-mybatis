package com.bearcat2.entity.common;

import com.bearcat2.enumeration.CodeMsgEnum;
import lombok.Getter;

/**
 * <p> Description: 系统自定义异常 </p>
 * <p> Title: CustomException </p>
 * <p> Create Time: 2019/7/6 22:59 </p>
 *
 * @author zhongzhipeng
 * @see CodeMsgEnum
 * @since 1.0
 */
@SuppressWarnings("serial")
public class CustomException extends RuntimeException {

    @Getter
    private CodeMsgEnum codeMsgEnum;

    public CustomException(CodeMsgEnum codeMsgEnum) {
        super(codeMsgEnum.getMsg());
        this.codeMsgEnum = codeMsgEnum;
    }

    public CustomException(String message) {
        super(message);
    }

    public CustomException(Throwable cause) {
        super(cause);
    }

    public CustomException(String message, Throwable cause) {
        super(message, cause);
    }
}