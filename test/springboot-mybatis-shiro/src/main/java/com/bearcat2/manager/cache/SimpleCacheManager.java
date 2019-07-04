package com.bearcat2.manager.cache;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <p> Description: 简单缓存实现类,使用 ConcurrentHashMap 容器存储 </p>
 * <p> Title: SimpleCacheManager </p>
 * <p> Create Time: 2019/5/12 11:53 </p>
 *
 * @author: zhongzhipeng
 * @version: 1.0
 */
@Component
public class SimpleCacheManager implements CacheManager {

    /** 缓存容器 */
    private Map<String, Object> cacheMap = new ConcurrentHashMap<>();

    @Override
    public Object get(String key) {
        return this.cacheMap.get(key);
    }

    @Override
    public boolean put(String key, Object value) {
        this.cacheMap.put(key, value);
        return true;
    }

    @Override
    public boolean remove(String key) {
        this.cacheMap.remove(key);
        return true;
    }
}
