package com.bearcat2.service.system;

import com.bearcat2.entity.common.LayuiResult;
import com.bearcat2.entity.system.SysOperate;

/**
 * <p> Description: 操作管理service </p>
 * <p> Title: SysOperateService </p>
 * <p> Create Time: 2019/6/26 18:20 </p>
 *
 * @author: zhongzhipeng
 * @version: 1.0
 */
public interface SysOperateService {

    /**
     * 分页查询
     *
     * @param sysOperate 系统操作对象
     * @return 通用layui
     */
    LayuiResult list(SysOperate sysOperate);

    /**
     * 插入系统操作数据
     *
     * @param sysOperate 系统操作对象
     * @return int - 影响数据表行数
     */
    int insert(SysOperate sysOperate);

    /**
     * 根据id查询系统操作对象
     *
     * @param id 操作id
     * @return SysOperate - 系统操作对象
     */
    SysOperate findById(Integer id);

    /**
     * 修改系统操作对象
     *
     * @param sysOperate 系统操作对象,必须包含id属性
     * @return int - 影响数据表行数
     */
    int update(SysOperate sysOperate);

    /**
     * 根据id删除系统操作对象
     *
     * @param id 操作id
     * @return int - 影响数据表行数
     */
    int deleteById(Integer id);
}
