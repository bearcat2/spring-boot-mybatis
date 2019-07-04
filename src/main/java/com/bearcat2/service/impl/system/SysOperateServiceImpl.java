package com.bearcat2.service.impl.system;

import cn.hutool.core.util.StrUtil;
import com.bearcat2.entity.common.LayuiResult;
import com.bearcat2.entity.system.SysOperate;
import com.bearcat2.entity.system.SysOperateExample;
import com.bearcat2.service.common.CommonServiceImpl;
import com.bearcat2.service.system.SysOperateService;
import com.bearcat2.util.CommonUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p> Description: 操作管理实现类 </p>
 * <p> Title: SysOperateServiceImpl </p>
 * <p> Create Time: 2019/6/26 18:23 </p>
 *
 * @author: zhongzhipeng
 * @version: 1.0
 */
@Service
@Transactional(readOnly = true)
public class SysOperateServiceImpl extends CommonServiceImpl<SysOperate, SysOperateExample> implements SysOperateService {

    @Override
    public LayuiResult list(SysOperate sysOperate) {
        SysOperateExample example = new SysOperateExample();
        example.setOrderByClause("so_orderd");
        SysOperateExample.Criteria criteria = example.createCriteria();
        if (StrUtil.isNotBlank(sysOperate.getSoName())) {
            criteria.andSoNameLike(CommonUtil.buildLikeQueryParam(sysOperate.getSoName()));
        }
        if (StrUtil.isNotBlank(sysOperate.getSoShowName())) {
            criteria.andSoShowNameLike(CommonUtil.buildLikeQueryParam(sysOperate.getSoShowName()));
        }
        PageHelper.startPage(sysOperate.getPage(), sysOperate.getLimit());
        List<SysOperate> sysOperates = this.selectByExample(example);
        PageInfo<SysOperate> pageInfo = new PageInfo<>(sysOperates);
        return LayuiResult.success(pageInfo.getList(), pageInfo.getTotal());
    }
}
