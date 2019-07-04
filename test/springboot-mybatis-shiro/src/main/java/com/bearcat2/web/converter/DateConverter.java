package com.bearcat2.web.converter;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.bearcat2.entity.common.Constant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;

import java.util.Date;

/**
 * <p> Description: 日期时间转换器，将前端传递的日期字符串转换为java.util.Date对象 </p>
 * <p> Title: DateConverter </p>
 * <p> Create Time: 2019/6/16 15:49 </p>
 *
 * @author: zhongzhipeng
 * @version: 1.0
 */
@Slf4j
public class DateConverter implements Converter<String, Date> {

    @Override
    public Date convert(String dateStr) {
        DateTime parse = null;
        try {
            parse = DateUtil.parse(dateStr, Constant.DATA_T_TIME_FORMAT);
        } catch (Exception e) {
            // 将异常作为一个条件判断的逻辑,此处记录info类型日志即可
            log.info(
                    "【DateConverter】默认格式转换异常,使用日期工具类进行转换,待转换的日期字符串为 = {},默认日期格式为 = {}"
                    , dateStr
                    , Constant.DATA_T_TIME_FORMAT
            );
            try {
                // 使用工具类，默认日期解析
                parse = DateUtil.parse(dateStr);
            } catch (Exception e1) {
                // 向上层抛异常
                throw new RuntimeException("【DateConverter】默认日期解析发生异常了",e1);
            }
        }
        return parse.toJdkDate();
    }
}
