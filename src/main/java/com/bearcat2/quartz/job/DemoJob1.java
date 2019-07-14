package com.bearcat2.quartz.job;

import lombok.extern.slf4j.Slf4j;

/**
 * <p> Description: 测试job </p>
 * <p> Title: DemoJob1 </p>
 * <p> Create Time: 2019/7/14 15:44 </p>
 *
 * @author: zhongzhipeng
 * @version: 1.0
 */
@Slf4j
public class DemoJob1 {

    public void run() {
        log.info("DemoJob1 ... run 被调用");
    }
}
