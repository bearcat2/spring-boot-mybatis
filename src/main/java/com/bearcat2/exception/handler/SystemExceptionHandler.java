package com.bearcat2.exception.handler;

import com.bearcat2.entity.common.LayuiResult;

/**
 * <p> Description: 系统异常处理器,使用策略模式处理异常 <p>
 * 策略模式参见：https://blog.csdn.net/u012124438/article/details/70039943/
 *
 * <p> Title: SystemExceptionHandler </p>
 * <p> Create Time: 2019/7/6 22:49 </p>
 *
 * @author: zhongzhipeng
 * @version: 1.0
 */
public interface SystemExceptionHandler {
    /**
     * 判断当前异常类型
     *
     * @param ex 异常类型
     * @return ex instanceof xxxException
     */
    boolean supports(Exception ex);

    /**
     * 处理异常
     *
     * @param ex 异常类型
     * @return web层通用响应对象
     */
    LayuiResult handleException(Exception ex);
}
