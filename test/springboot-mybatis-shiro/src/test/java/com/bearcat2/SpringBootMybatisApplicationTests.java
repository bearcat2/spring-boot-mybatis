package com.bearcat2;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootMybatisApplicationTests {

    @Autowired
    private DataSource dataSource;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testDataSourceIsConfigSuccess() throws Exception{
        Connection connection = this.dataSource.getConnection();
        if(connection != null){
            log.info("druid 数据源配置成功");
        }
    }

}
