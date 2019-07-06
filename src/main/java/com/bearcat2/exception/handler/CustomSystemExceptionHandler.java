package com.bearcat2.exception.handler;

import com.bearcat2.entity.common.CustomException;
import com.bearcat2.entity.common.LayuiResult;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * <p> Description: 自定义异常处理器 </p>
 * <p> Title: CustomSystemExceptionHandler </p>
 * <p> Create Time: 2019/7/6 23:00 </p>
 *
 * @author: zhongzhipeng
 * @version: 1.0
 */
@Order(1)
@Component
public class CustomSystemExceptionHandler implements SystemExceptionHandler {

    @Override
    public boolean supports(Exception ex) {
        return ex instanceof CustomException;
    }

    @Override
    public LayuiResult handleException(Exception ex) {
        // 自定义异常目前只返回错误码及对应提示消息,后续可自行扩展
        CustomException customException = (CustomException) ex;
        return LayuiResult.error(customException.getCodeMsgEnum());
    }
}
