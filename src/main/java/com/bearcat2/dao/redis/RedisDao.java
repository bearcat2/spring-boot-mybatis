package com.bearcat2.dao.redis;

import com.alibaba.fastjson.TypeReference;

/**
 * <p> Description: redis 数据访问对象</p>
 * <a href="https://www.redis.net.cn/order">redis命令手册参见</a>
 *
 * <p> Title: RedisDao </p>
 * <p> Create Time: 2019/7/4 23:30 </p>
 *
 * @author zhongzhipeng
 * @since 1.0
 */
public interface RedisDao {

    /**
     * 添加字符串，value会转成json格式
     *
     * @param key   键
     * @param value 值
     * @return 操作成功返回true, 失败返回false
     */
    boolean set(String key, Object value);

    /**
     * 添加字符串带过期时间，value会转成json格式
     *
     * @param key        键
     * @param value      值
     * @param expireTime 过期时间,单位秒
     * @return 操作成功返回true, 失败返回false
     */
    boolean setEx(String key, Object value, int expireTime);

    /**
     * 获取字符串,处理返回值不带泛型的对象
     *
     * @param key         键
     * @param returnClass 返回值类型
     * @return 键对应的值, 键为空或返回值类型或发生异常将返回 null
     */
    <T> T get(String key, Class<T> returnClass);

    /**
     * 获取字符串,处理返回值带泛型的对象
     *
     * @param key           键
     * @param typeReference 返回值类型引用
     * @return 键对应的值, 键为空或返回值类型或发生异常将返回 null
     */
    <T> T get(String key, TypeReference<T> typeReference);

    /**
     * 判断key是否存在
     *
     * @param key 键
     * @return 存在返回 true 不存在返回false
     */
    boolean exists(String key);

    /**
     * 删除key
     *
     * @param key 键
     * @return 删除成功返回 true 失败返回false
     */
    boolean del(String key);
}
