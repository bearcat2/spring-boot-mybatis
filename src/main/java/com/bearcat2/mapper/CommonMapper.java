package com.bearcat2.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p> Description: 定义所有mapper 通用的方法 </p>
 * <p> Title: CommonMapper </p>
 * <p> Create Time: 2019/5/12 20:33 </p>
 *
 * @author: zhongzhipeng
 * @version: 1.0
 */
public interface CommonMapper<Record, Example> {

    int countByExample(Example example);

    int deleteByExample(Example example);

    int deleteByPrimaryKey(Integer id);

    int insert(Record record);

    int insertSelective(Record record);

    List<Record> selectByExample(Example example);

    Record selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Record record, @Param("example") Example example);

    int updateByExample(@Param("record") Record record, @Param("example") Example example);

    int updateByPrimaryKeySelective(Record record);

    int updateByPrimaryKey(Record record);

    /*===================批量操作==================== */
    int insertBatch(List<Record> records);
}
