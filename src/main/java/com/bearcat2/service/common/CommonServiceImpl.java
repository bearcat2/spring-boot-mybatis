package com.bearcat2.service.common;

import com.bearcat2.mapper.CommonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p> Description: 通用service 实现类 </p>
 * <p> Title: CommonServiceImpl </p>
 * <p> Create Time: 2019/5/12 20:42 </p>
 *
 * @author: zhongzhipeng
 * @version: 1.0
 */
@Service
public class CommonServiceImpl<Record, Example> implements CommonService<Record, Example> {

    /** 使用spring 4.x 之后泛型注入新特性,在运行时找到具体mapper注入 */
    @Autowired
    private CommonMapper<Record, Example> commonMapper;

    @Override
    public boolean countByExample(Example example) {
        return verifyUpdateIsSuccess(this.commonMapper.countByExample(example));
    }

    @Override
    public boolean deleteByExample(Example example) {
        return verifyUpdateIsSuccess(this.commonMapper.deleteByExample(example));
    }

    @Override
    public boolean deleteByPrimaryKey(Integer id) {
        return verifyUpdateIsSuccess(this.commonMapper.deleteByPrimaryKey(id));
    }

    @Override
    public boolean insert(Record record) {
        return verifyUpdateIsSuccess(this.commonMapper.insert(record));
    }

    @Override
    public boolean insertSelective(Record record) {
        return verifyUpdateIsSuccess(this.commonMapper.insertSelective(record));
    }

    @Override
    public List<Record> selectByExample(Example example) {
        return this.commonMapper.selectByExample(example);
    }

    @Override
    public Record selectByPrimaryKey(Integer id) {
        return this.commonMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean updateByExampleSelective(Record record, Example example) {
        return verifyUpdateIsSuccess(this.commonMapper.updateByExampleSelective(record,example));
    }

    @Override
    public boolean updateByExample(Record record, Example example) {
        return verifyUpdateIsSuccess(this.commonMapper.updateByExample(record,example));
    }

    @Override
    public boolean updateByPrimaryKeySelective(Record record) {
        return verifyUpdateIsSuccess(this.commonMapper.updateByPrimaryKeySelective(record));
    }

    @Override
    public boolean updateByPrimaryKey(Record record) {
        return verifyUpdateIsSuccess(this.commonMapper.updateByPrimaryKey(record));
    }

    @Override
    public boolean insertBatch(List<Record> records) {
        return verifyUpdateIsSuccess(this.commonMapper.insertBatch(records));
    }

    /**
     * 验证更新(增，删，改)数据库是否成功,注这里指的是物理意义的成功即更新了表中几行数据
     *
     * @param rows 影响表的行数
     * @return 更新成功返回 true ，失败返回 fasle
     */
    private boolean verifyUpdateIsSuccess(Integer rows) {
        return rows != null && rows > 1;
    }
}
