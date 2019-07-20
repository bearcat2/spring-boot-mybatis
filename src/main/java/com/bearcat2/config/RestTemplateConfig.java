package com.bearcat2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * <p> Description: resttemplate 配置类 </p>
 * <p> Title: RestTemplateConfig </p>
 * <p> Create Time: 2019/7/20 22:07 </p>
 *
 * @author: zhongzhipeng
 * @version: 1.0
 */
@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
