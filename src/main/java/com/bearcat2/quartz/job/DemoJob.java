package com.bearcat2.quartz.job;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * <p> Description: 测试job </p>
 * <p> Title: DemoJob </p>
 * <p> Create Time: 2019/7/14 15:43 </p>
 *
 * @author: zhongzhipeng
 * @version: 1.0
 */
@Slf4j
@Component
public class DemoJob {

    public void run() {
        log.info("DemoJob ... run 被调用");
    }

}
