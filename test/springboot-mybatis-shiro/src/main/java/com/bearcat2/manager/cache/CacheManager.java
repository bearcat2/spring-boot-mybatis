package com.bearcat2.manager.cache;

/**
 * <p> Description: 缓存管理类 </p>
 * <p> Title: CacheManager </p>
 * <p> Create Time: 2019/5/12 11:48 </p>
 *
 * @author: zhongzhipeng
 * @version: 1.0
 */
public interface CacheManager {

    /**
     * 获取缓存
     * @param key 缓存key
     * @return 缓存对应的值
     */
    Object get(String key);

    /**
     * 设置缓存
     * @param key 缓存key
     * @param value 缓存对应的值
     * @return 设置缓存成功返回 true , 失败返回 false
     */
    boolean put(String key , Object value);

    /**
     * 清除缓存
     * @param key 缓存key
     * @return 清除缓存成功返回 true , 失败返回 false
     */
    boolean remove(String key);
}
