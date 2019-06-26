package com.bearcat2.service.system;

import com.bearcat2.entity.common.LayuiResult;
import com.bearcat2.entity.system.SysOperate;
import com.bearcat2.entity.system.SysOperateExample;
import com.bearcat2.service.common.CommonService;

/**
 * <p> Description: 操作管理service </p>
 * <p> Title: SysOperateService </p>
 * <p> Create Time: 2019/6/26 18:20 </p>
 *
 * @author: zhongzhipeng
 * @version: 1.0
 */
public interface SysOperateService extends CommonService<SysOperate, SysOperateExample> {

    /**
     * 分页查询
     * @param sysOperate 操作对象
     * @return 通用layui
     */
    LayuiResult list(SysOperate sysOperate);

}
