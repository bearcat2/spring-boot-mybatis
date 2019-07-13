package com.bearcat2.mapper;

import tk.mybatis.mapper.annotation.RegisterMapper;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * <p> Description: 通用mapper </p>
 * <p> Title: CommonMapper </p>
 * <p> Create Time: 2019/5/12 20:33 </p>
 *
 * @author: zhongzhipeng
 * @version: 1.0
 */
@RegisterMapper
public interface CommonMapper<T> extends Mapper<T>, MySqlMapper<T>, IdsMapper<T> {
}
