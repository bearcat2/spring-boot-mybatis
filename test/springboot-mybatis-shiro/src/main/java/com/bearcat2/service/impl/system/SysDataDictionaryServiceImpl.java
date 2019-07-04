package com.bearcat2.service.impl.system;

import com.bearcat2.entity.system.SysDataDictionary;
import com.bearcat2.entity.system.SysDataDictionaryExample;
import com.bearcat2.mapper.system.SysDataDictionaryMapper;
import com.bearcat2.service.common.CommonServiceImpl;
import com.bearcat2.service.system.SysDataDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p> Description: 数据字典service 接口实现类 </p>
 * <p> Title: SysDataDictionaryServiceImpl </p>
 * <p> Create Time: 2019/5/12 11:35 </p>
 *
 * @author: zhongzhipeng
 * @version: 1.0
 */
@Service
public class SysDataDictionaryServiceImpl extends CommonServiceImpl<SysDataDictionary, SysDataDictionaryExample> implements SysDataDictionaryService {

    @Autowired
    private SysDataDictionaryMapper sysDataDictionaryMapper;

    @Override
    public List<String> listChildrenNameByParentName(String parentName) {
        List<SysDataDictionary> dataDictionaries = this.sysDataDictionaryMapper.listByParentName(parentName);
        List<String> dataList = new ArrayList<>(dataDictionaries.size());
        for (SysDataDictionary dataDictionary : dataDictionaries) {
            dataList.add(dataDictionary.getSdrName());
        }
        return dataList;
    }
}
