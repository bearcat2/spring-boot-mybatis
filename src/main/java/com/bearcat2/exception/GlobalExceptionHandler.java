package com.bearcat2.exception;

import com.bearcat2.entity.common.LayuiResult;
import com.bearcat2.exception.handler.SystemExceptionHandler;
import com.bearcat2.util.CommonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p> Description: 全局异常处理器 </p>
 * <p> Title: GlobalExceptionHandler </p>
 * <p> Create Time: 2019/7/6 22:41 </p>
 *
 * @author: zhongzhipeng
 * @version: 1.0
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    // 将容器所以实现了ExceptionHandler的实现类注入到该集合中,顺序有 order 注解指定
    @Autowired
    private List<SystemExceptionHandler> systemExceptionHandlers;

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public LayuiResult handleException(HttpServletRequest request, Exception ex, HandlerMethod handlerMethod) {
        // 1.根据当前异常对象获取指定的异常处理器
        SystemExceptionHandler exceptionHandler = this.getExceptionHandler(ex);
        // 2.处理异常
        LayuiResult layuiResult = exceptionHandler.handleException(ex);
        // 3.保存错误日志到文件
        this.saveLogToFile(request, ex, handlerMethod, layuiResult);
        return layuiResult;
    }

    /**
     * 根据当前异常类型,获取指定的系统异常处理器
     *
     * @param ex 异常类型
     * @return SystemExceptionHandler - 系统异常处理器对象
     */
    public SystemExceptionHandler getExceptionHandler(Exception ex) {
        for (SystemExceptionHandler systemExceptionHandler : systemExceptionHandlers) {
            if (systemExceptionHandler.supports(ex)) {
                return systemExceptionHandler;
            }
        }
        return null;
    }

    /**
     * 记录错误日志到文件中
     *
     * @param request        请求对象
     * @param ex             异常对象
     * @param layuiResult 通用响应结果
     */
    private void saveLogToFile(HttpServletRequest request, Exception ex, HandlerMethod handlerMethod, LayuiResult layuiResult) {
        // 获取请求参数
        String requestParameter = CommonUtil.getRequestParams(request);
        String className = handlerMethod.getBean().getClass().getSimpleName();
        String methodName = handlerMethod.getMethod().getName();
        log.error("系统发生异常了,错误码: {} ,错误消息: {} ,className: {} ,methodName: {} ,请求URI: {} ,请求参数: {}"
                , layuiResult.getCode()
                , layuiResult.getMsg()
                , className
                , methodName
                , request.getRequestURI()
                , requestParameter
                , ex
        );
    }
}
