package com.bearcat2.web;

import com.bearcat2.SpringBootMybatisApplicationTests;
import com.bearcat2.entity.test.Demo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
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
    private static final String TEST_ADDRESS_PREFIX = "http://localhost:8080/testRestTemplate/";

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
        // 传递对象,RestTemplate 内部默认会将对象序列化成 json串, 服务端接收时需用 @RequestBody 注解标记请求参数
        Demo demo = new Demo(5, "徐七");
        Boolean result = this.restTemplate.postForObject(TEST_ADDRESS_PREFIX + "add", demo, Boolean.class);
        log.info("testAdd method 请求结果 = {}", result);
    }

    @Test
    public void testAdd1() throws Exception {
        // 传递Map集合,RestTemplate 内部默认会将Map集合序列化成 json串, 服务端接收时需用 @RequestBody 注解标记请求参数
        Map<String, Object> params = new HashMap<>();
        params.put("id", 9);
        params.put("name", "你懂得");
        Boolean result = this.restTemplate.postForObject(TEST_ADDRESS_PREFIX + "add", params, Boolean.class);
        log.info("testAdd1 method 请求结果 = {}", result);
    }

    @Test
    public void testAdd2() throws Exception {
        // 传递 MultiValueMap 集合,RestTemplate 内部默认会将Map集合序列化成 key-value键值对
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<>();
        params.add("id", 10);
        params.add("name", "你懂得1");
        Boolean result = this.restTemplate.postForObject(TEST_ADDRESS_PREFIX + "add1", params, Boolean.class);
        log.info("testAdd2 method 请求结果 = {}", result);
    }

    @Test
    public void testAdd3() throws Exception {
        // 带请求头的 key - value 类型 post 请求
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("customHeader", "bearcat2");

        MultiValueMap<String, Object> params = new LinkedMultiValueMap<>();
        params.add("id", 10);
        params.add("name", "你懂得1");

        HttpEntity<MultiValueMap> httpEntity = new HttpEntity<>(params, httpHeaders);
        Boolean result = this.restTemplate.postForObject(TEST_ADDRESS_PREFIX + "add1", httpEntity, Boolean.class);
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
