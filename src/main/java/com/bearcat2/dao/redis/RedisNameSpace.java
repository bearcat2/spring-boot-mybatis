package com.bearcat2.dao.redis;

/**
 * <p> Description: redis key 命名空间 </p>
 * <p> Title: RedisNameSpace </p>
 * <p> Create Time: 2019/7/5 21:19 </p>
 *
 * @author zhongzhipeng
 * @since 1.0
 */
public interface RedisNameSpace {

    /** 权限刷新标记 */
    String PRIVILEGE_REFRESH_FLAG = "privilege_refresh_flag:%d";
}
