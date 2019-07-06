package com.bearcat2.exception.handler;

import com.bearcat2.entity.common.LayuiResult;
import com.bearcat2.enumeration.CodeMsgEnum;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * <p> Description: 系统未知异常处理器 </p>
 * <p> Title: UnknowSystemExceptionHandler </p>
 * <p> Create Time: 2019/7/6 23:05 </p>
 *
 * @author: zhongzhipeng
 * @version: 1.0
 */
@Order(Integer.MAX_VALUE)
@Component
public class UnknowSystemExceptionHandler implements SystemExceptionHandler {

    @Override
    public boolean supports(Exception ex) {
        return true;
    }

    @Override
    public LayuiResult handleException(Exception ex) {
        // 构建服务端错误返回,后续可自行扩展该方法
        return LayuiResult.error(CodeMsgEnum.SERVER_ERROR);
    }
}
