package com.bearcat2.mapper.system;

import com.bearcat2.entity.system.SysDataDictionary;
import com.bearcat2.entity.system.SysDataDictionaryExample;
import com.bearcat2.mapper.CommonMapper;

import java.util.List;

public interface SysDataDictionaryMapper extends CommonMapper<SysDataDictionary, SysDataDictionaryExample> {

    /**
     * 获取指定父字典 name 下的所有 子 字典数据
     *
     * @param parentName 父字典项 name
     * @return 所有 子 字典数据
     */
    List<SysDataDictionary> listByParentName(String parentName);
}