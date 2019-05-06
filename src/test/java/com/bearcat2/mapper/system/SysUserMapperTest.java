package com.bearcat2.mapper.system;

import cn.hutool.core.util.StrUtil;
import com.bearcat2.SpringBootMybatisApplicationTests;
import com.bearcat2.entity.system.SysUser;
import com.bearcat2.entity.system.SysUserExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * <p> Description: 系统用户测试 </p>
 * <p> Title: SysUserMapperTest </p>
 * <p> Create Time: 2019/5/6 22:36 </p>
 *
 * @author: zhongzhipeng
 * @version: 1.0
 * @see SysUserMapper
 */
@Slf4j
public class SysUserMapperTest extends SpringBootMybatisApplicationTests {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Test
    public void testInsertSelective() throws Exception {
        SysUser sysUser = new SysUser();
        sysUser.setSuLoginName("wangwu");
        sysUser.setSuRealName("王五");
        sysUser.setSuPassword("123456");
        sysUser.setSuCreateTime(new Date());
        sysUser.setSuUpdateTime(new Date());
        int rows = this.sysUserMapper.insertSelective(sysUser);
        Assert.assertTrue(rows == 1);
    }

    // 测试根据 example 动态条件查询
    @Test
    public void testSelectByExample() throws Exception {
        // 模拟前端页面传值,封装到实体中
        SysUser sysUser = new SysUser();
        sysUser.setSuLoginName("wangwu");
        sysUser.setSuRealName("王五");

        // 模拟动态查询
        SysUserExample sysUserExample = new SysUserExample();
        SysUserExample.Criteria criteria = sysUserExample.createCriteria();
        if (StrUtil.isNotBlank(sysUser.getSuLoginName())) {
            criteria.andSuLoginNameLike(StrUtil.format("%{}%", sysUser.getSuLoginName()));
        }

        if (StrUtil.isNotBlank(sysUser.getSuRealName())) {
            criteria.andSuRealNameLike(StrUtil.format("%{}%", sysUser.getSuRealName()));
        }

        List<SysUser> sysUsers = this.sysUserMapper.selectByExample(sysUserExample);
        log.info("查询结果 = {}", sysUsers.toString());
    }

    // 测试分页查询
    @Test
    public void testPagingQuery() throws Exception {
        // 模拟前端页面传值，当前在第一页，每一页显示2条
        int pageNum = 1;
        int pageSize = 2;
        // 开启分页,注只有在startPage后面的第一个查询语句会拼接上limit字句进行分页操作
        PageHelper.startPage(pageNum, pageSize);
        SysUserExample sysUserExample = new SysUserExample();
        // 下面可自由设置查询条件
        List<SysUser> sysUsers = this.sysUserMapper.selectByExample(sysUserExample);
        PageInfo<SysUser> pageInfo = new PageInfo<>(sysUsers);

        // 现在各种前端插件分页，需要后台返回当前页显示的数据和总记录数
        log.info("总记录数 = {} , 当前页显示的数据 = {}"
                , pageInfo.getTotal()
                , pageInfo.getList()
        );
    }


}