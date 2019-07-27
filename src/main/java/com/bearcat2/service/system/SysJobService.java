package com.bearcat2.service.system;

import com.bearcat2.entity.common.LayuiResult;
import com.bearcat2.entity.common.PagingSupport;
import com.bearcat2.entity.system.SysJob;

/**
 * <p> Description: 系统任务service接口 </p>
 * <p> Title: SysJobService </p>
 * <p> Create Time: 2019/7/13 22:12 </p>
 *
 * @author zhongzhipeng
 * @since 1.0
 */
public interface SysJobService {

    /**
     * 分页查询
     *
     * @param sysJob        系统任务对象
     * @param pagingSupport 分支支持对象
     * @return LayuiResult - 控制层通用返回结果 {@link LayuiResult}
     */
    LayuiResult pageList(SysJob sysJob, PagingSupport pagingSupport);

    /**
     * 根据任务id 查找系统任务对象
     *
     * @param id 任务id
     * @return SysJob - 系统任务对象
     */
    SysJob findById(Integer id);

    /**
     * 插入系统任务对象
     *
     * @param sysJob 系统任务对象
     * @return int - 影响数据表行数
     */
    int insert(SysJob sysJob);

    /**
     * 修改系统任务对象
     *
     * @param sysJob 系统任务对象
     * @return int - 影响数据表行数
     */
    int update(SysJob sysJob);

    /**
     * 根据任务id更新任务状态
     *
     * @param id     任务id
     * @param status 任务状态(1:停止;2:运行)
     * @return int - 影响数据表行数
     */
    int updataStatusById(Integer id, Integer status);

    /**
     * 根据任务id更新任务 cron 表达式
     *
     * @param id             任务id
     * @param cornExpression cron 表达式
     */
    void updateCornExpressionById(Integer id, String cornExpression);

    /**
     * 初始化系统所有任务
     */
    void initSystemJob();

}
