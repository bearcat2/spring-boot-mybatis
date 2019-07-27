package com.bearcat2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * <p> Description: RestTemplate 配置类 </p>
 * <p> Title: RestTemplateConfig </p>
 * <p> Create Time: 2019/7/20 22:07 </p>
 *
 * @author zhongzhipeng
 * @see RestTemplate
 * @since 1.0
 */
@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate(clientHttpRequestFactory());
    }

    @Bean
    public ClientHttpRequestFactory clientHttpRequestFactory() {
        SimpleClientHttpRequestFactory clientHttpRequestFactory = new SimpleClientHttpRequestFactory();
        // 连接超时时间 10 秒
        clientHttpRequestFactory.setConnectTimeout(10000);
        // 读取数据超时时间 10 秒
        clientHttpRequestFactory.setReadTimeout(10000);
        return clientHttpRequestFactory;
    }
}
