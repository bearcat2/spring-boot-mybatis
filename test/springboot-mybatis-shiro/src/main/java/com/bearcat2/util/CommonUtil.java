package com.bearcat2.util;

import cn.hutool.core.util.StrUtil;
import cn.hutool.setting.dialect.Props;

import java.util.*;

/**
 * <p> Description: 系统通用工具类 </p>
 * <p> Title: CommonUtil </p>
 * <p> Create Time: 2019/5/11 22:43 </p>
 *
 * @author: zhongzhipeng
 * @version: 1.0
 */
public class CommonUtil {

    /**
     * 构建数据库 like 查询参数
     *
     * @param like 需要生成参数
     * @return 返回like 查询参数 - %like%
     */
    public static String buildLikeQueryParam(String like) {
        return StrUtil.format("%{}%", like);
    }

    /**
     * 将 list 转成 set
     *
     * @param dataList list集合数据
     * @return set 集合
     */
    public static <T> Set<T> listToSet(List<T> dataList) {
        return new HashSet<>(dataList);
    }

    /**
     * 获取属性文件中所有key集合
     *
     * @param path 属性文件路径
     * @return 属性文件key集合
     */
    public static List<String> getPropertyNames(String path) {
        List<String> propertyNames = new ArrayList<>();
        Props props = new Props("config/anonymousUrls.properties");
        Enumeration<?> enumeration = props.propertyNames();
        while (enumeration.hasMoreElements()) {
            String key = (String) enumeration.nextElement();
            propertyNames.add(key);
        }
        return propertyNames;
    }


    public static void main(String[] args) {
        List<String> list = Arrays.asList("张三", "李四", "张三");
        Set<String> datas = listToSet(list);
        System.out.println(datas);
    }
}
