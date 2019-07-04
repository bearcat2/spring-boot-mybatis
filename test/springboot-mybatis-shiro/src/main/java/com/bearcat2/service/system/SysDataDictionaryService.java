package com.bearcat2.service.system;

import com.bearcat2.entity.system.SysDataDictionary;
import com.bearcat2.entity.system.SysDataDictionaryExample;
import com.bearcat2.service.common.CommonService;

import java.util.List;

/**
 * <p> Description: 数据字典service 接口 </p>
 * <p> Title: SysDataDictionaryService </p>
 * <p> Create Time: 2019/5/12 11:29 </p>
 *
 * @author: zhongzhipeng
 * @version: 1.0
 */
public interface SysDataDictionaryService  extends CommonService<SysDataDictionary, SysDataDictionaryExample> {

    /** 数据字典项name 属性值 */

    /** 匿名访问 name */
    String ANONYMOUS_ACCESS_URL = "anonymous_access_url";

    /** 公共访问 name */
    String COMMON_ACCESS_URL = "common_access_url";

    /**
     * 获取父字典项下所有子字典name
     *
     * @param parentName 字典名
     * @return 子字典name数据集合
     */
    List<String> listChildrenNameByParentName(String parentName);
}
