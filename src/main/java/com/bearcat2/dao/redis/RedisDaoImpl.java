package com.bearcat2.dao.redis;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

/**
 * <p> Description: redis 数据访问对象实现类 </p>
 * <p> Title: RedisDaoImpl </p>
 * <p> Create Time: 2019/7/4 23:32 </p>
 *
 * @author zhongzhipeng
 * @since 1.0
 */
@Slf4j
@Repository
public class RedisDaoImpl implements RedisDao {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public boolean set(String key, Object value) {
        if (value == null || StrUtil.isBlank(key)) {
            return false;
        }
        try {
            this.stringRedisTemplate.opsForValue().set(key, JSON.toJSONString(value));
        } catch (Exception e) {
            log.error(StrUtil.format("set操作失败,key = {} , value = {}", key, value), e);
            return false;
        }
        return true;
    }

    @Override
    public boolean setEx(String key, Object value, int expireTime) {
        if (value == null || StrUtil.isBlank(key)) {
            return false;
        }
        try {
            this.stringRedisTemplate.opsForValue().set(key, JSON.toJSONString(value), expireTime, TimeUnit.SECONDS);
        } catch (Exception e) {
            log.error(StrUtil.format("set操作失败,key = {} , value = {}", key, value), e);
            return false;
        }
        return true;
    }

    @Override
    public <T> T get(String key, Class<T> returnClass) {
        if (StrUtil.isBlank(key) || returnClass == null) {
            return null;
        }
        try {
            String jsonValue = this.stringRedisTemplate.opsForValue().get(key);
            if (StrUtil.isBlank(jsonValue)) {
                return null;
            }
            return JSON.parseObject(jsonValue, returnClass);
        } catch (Exception e) {
            log.error(StrUtil.format("get操作失败,key = {} ", key), e);
            return null;
        }
    }

    @Override
    public <T> T get(String key, TypeReference<T> typeReference) {
        if (StrUtil.isBlank(key) || typeReference == null) {
            return null;
        }
        try {
            String jsonValue = this.stringRedisTemplate.opsForValue().get(key);
            if (StrUtil.isBlank(jsonValue)) {
                return null;
            }
            return JSON.parseObject(jsonValue, typeReference);
        } catch (Exception e) {
            log.error(StrUtil.format("get操作失败,key = {} ", key), e);
            return null;
        }
    }

    @Override
    public boolean exists(String key) {
        if (StrUtil.isBlank(key)) {
            return false;
        }
        try {
            return this.stringRedisTemplate.hasKey(key);
        } catch (Exception e) {
            log.error(StrUtil.format("exists操作失败,key = {} ", key), e);
            return false;
        }
    }

    @Override
    public boolean del(String key) {
        if (StrUtil.isBlank(key)) {
            return false;
        }
        try {
            return this.stringRedisTemplate.delete(key);
        } catch (Exception e) {
            log.error(StrUtil.format("del操作失败,key = {} ", key), e);
            return false;
        }
    }
}
