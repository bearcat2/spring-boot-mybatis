package com.bearcat2.service.impl.system;

import cn.hutool.core.util.StrUtil;
import com.bearcat2.entity.common.LayuiResult;
import com.bearcat2.entity.common.PagingSupport;
import com.bearcat2.entity.system.SysOperate;
import com.bearcat2.mapper.system.SysOperateMapper;
import com.bearcat2.service.system.SysOperateService;
import com.bearcat2.util.CommonUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

/**
 * <p> Description: 操作管理实现类 </p>
 * <p> Title: SysOperateServiceImpl </p>
 * <p> Create Time: 2019/6/26 18:23 </p>
 *
 * @author zhongzhipeng
 * @see SysOperateService
 * @since 1.0
 */
@Service
@Transactional(readOnly = true)
public class SysOperateServiceImpl implements SysOperateService {

    @Autowired
    private SysOperateMapper sysOperateMapper;

    @Override
    public LayuiResult pageList(SysOperate sysOperate, PagingSupport pagingSupport) {
        Example example = new Example(SysOperate.class);
        example.setOrderByClause("so_orderd");
        Example.Criteria criteria = example.createCriteria();
        if (StrUtil.isNotBlank(sysOperate.getSoName())) {
            criteria.andLike(SysOperate.SO_NAME, CommonUtil.buildLikeQueryParam(sysOperate.getSoName()));
        }
        if (StrUtil.isNotBlank(sysOperate.getSoShowName())) {
            criteria.andLike(SysOperate.SO_SHOW_NAME, CommonUtil.buildLikeQueryParam(sysOperate.getSoShowName()));
        }
        PageHelper.startPage(pagingSupport.getPage(), pagingSupport.getLimit());
        List<SysOperate> sysOperates = this.sysOperateMapper.selectByExample(example);
        PageInfo<SysOperate> pageInfo = new PageInfo<>(sysOperates);
        return LayuiResult.success(pageInfo.getList(), pageInfo.getTotal());
    }

    @Transactional
    @Override
    public int insert(SysOperate sysOperate) {
        sysOperate.setSoUpdateTime(new Date());
        sysOperate.setSoCreateTime(new Date());
        return this.sysOperateMapper.insertSelective(sysOperate);
    }

    @Override
    public SysOperate findById(Integer id) {
        return this.sysOperateMapper.selectByPrimaryKey(id);
    }

    @Transactional
    @Override
    public int update(SysOperate sysOperate) {
        sysOperate.setSoUpdateTime(new Date());
        return this.sysOperateMapper.updateByPrimaryKeySelective(sysOperate);
    }

    @Transactional
    @Override
    public int deleteById(Integer id) {
        return this.sysOperateMapper.deleteByPrimaryKey(id);
    }

}
