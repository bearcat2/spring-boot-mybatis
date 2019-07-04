package com.bearcat2.service.common;

import java.util.List;

/**
 * <p> Description: 通用service </p>
 * <p> Title: CommonService </p>
 * <p> Create Time: 2019/5/12 20:40 </p>
 *
 * @author: zhongzhipeng
 * @version: 1.0
 */
public interface CommonService<Record, Example> {

    boolean countByExample(Example example);

    boolean deleteByExample(Example example);

    boolean deleteByPrimaryKey(Integer id);

    boolean insert(Record record);

    boolean insertSelective(Record record);

    List<Record> selectByExample(Example example);

    Record selectByPrimaryKey(Integer id);

    boolean updateByExampleSelective( Record record, Example example);

    boolean updateByExample( Record record,  Example example);

    boolean updateByPrimaryKeySelective(Record record);

    boolean updateByPrimaryKey(Record record);

    /*===================批量操作==================== */
    boolean insertBatch(List<Record> records);
}
