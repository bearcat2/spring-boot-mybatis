package com.bearcat2.web;

import com.bearcat2.SpringBootMybatisApplicationTests;
import com.bearcat2.entity.test.Demo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * <p> Description: RestTemplate 测试类 </p>
 * <p> Title: RestTemplateTest </p>
 * <p> Create Time: 2019/7/20 23:16 </p>
 *
 * @author: zhongzhipeng
 * @version: 1.0
 */
@Slf4j
public class RestTemplateTest extends SpringBootMybatisApplicationTests {

    /** 测试地址前缀 */
    public static final String TEST_ADDRESS_PREFIX = "http://localhost:8080/testRestTemplate/";

    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void testGet() throws Exception {
        Demo demo = this.restTemplate.getForObject(
                TEST_ADDRESS_PREFIX + "get/{id}"
                , Demo.class
                , 1
        );
        log.info("testGet method request data = {}", demo);
    }

    @Test
    public void testGet1() throws Exception {
        // 传递map参数形式,注意map key 要和路径变量一致
        Map<String, Object> params = new HashMap<>();
        params.put("id", 1);
        Demo demo = this.restTemplate.getForObject(
                TEST_ADDRESS_PREFIX + "get/{id}"
                , Demo.class
                , params
        );
        log.info("testGet1 method request data = {}", demo);
    }

    @Test
    public void testGet2() throws Exception {
        // 传递map参数形式,注意map key 要和路径变量一致
        Map<String, Object> params = new HashMap<>();
        params.put("id", 1);
        ResponseEntity<Demo> responseEntity = this.restTemplate.getForEntity(
                TEST_ADDRESS_PREFIX + "get/{id}"
                , Demo.class
                , params
        );
        int statusCodeValue = responseEntity.getStatusCodeValue();
        Demo body = responseEntity.getBody();
        HttpHeaders headers = responseEntity.getHeaders();
        log.info("testGet2 method  状态码 = {},请求数据 = {} , 请求头",
                statusCodeValue
                , body
                , headers
        );
    }

    @Test
    public void testAdd() throws Exception {
        Demo demo = new Demo(5, "徐七");
        Boolean result = this.restTemplate.postForObject(TEST_ADDRESS_PREFIX + "add", demo, Boolean.class);
        log.info("testAdd method 请求结果 = {}", result);
    }

    @Test
    public void testUpdate() throws Exception {
        Demo demo = new Demo(5, "徐九");
        this.restTemplate.put(TEST_ADDRESS_PREFIX + "update", demo, Boolean.class);
    }

    @Test
    public void testDelete() throws Exception {
        this.restTemplate.delete(TEST_ADDRESS_PREFIX + "delete/{id}", 1);
    }
}
