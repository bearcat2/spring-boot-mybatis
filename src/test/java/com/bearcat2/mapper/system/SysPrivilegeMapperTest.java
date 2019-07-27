package com.bearcat2.mapper.system;

import com.bearcat2.SpringBootMybatisApplicationTests;
import com.bearcat2.entity.system.SysPrivilege;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * <p> Description: 系统权限mapper测试对象 </p>
 * <p> Title: SysPrivilegeMapperTest </p>
 * <p> Create Time: 2019/7/13 16:43 </p>
 *
 * @author zhongzhipeng
 * @since 1.0
 */
public class SysPrivilegeMapperTest extends SpringBootMybatisApplicationTests {

    @Autowired
    private SysPrivilegeMapper sysPrivilegeMapper;

    @Test
    public void testFindMenuByUserId() throws Exception {
        List<SysPrivilege> menuByUserId = this.sysPrivilegeMapper.findMenuByUserId(1);
        System.out.println(menuByUserId);

    }


}