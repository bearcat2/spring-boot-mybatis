package com.bearcat2.web.controller.test;

import com.bearcat2.entity.test.Demo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p> Description: RestTeamplate 测试控制器 </p>
 * <p> Title: TestRestTemplateController </p>
 * <p> Create Time: 2019/7/20 22:12 </p>
 *
 * @author zhongzhipeng
 * @since 1.0
 */
@Slf4j
@RestController
@RequestMapping("/testRestTemplate")
public class TestRestTemplateController {

    /**
     * 测试数据
     */
    private List<Demo> demos = new ArrayList<>();

    // 构造代码块
    {
        demos.add(new Demo(1, "张三"));
        demos.add(new Demo(2, "李四"));
        demos.add(new Demo(3, "王五"));
        demos.add(new Demo(4, "赵六"));
    }

    @GetMapping("/get/{id}")
    public Demo get(@PathVariable Integer id) {
        for (Demo demo : demos) {
            if (demo.getId().equals(id)) {
                return demo;
            }
        }
        return null;
    }

    @GetMapping("/list")
    public List<Demo> list() {
        return demos;
    }

    @PostMapping("/add")
    public Boolean add(@RequestBody Demo demo) {
        log.info("原始集合元素内容 = {}", demos);
        demos.add(demo);
        log.info("添加元素,集合元素内容 = {}", demos);
        return true;
    }

    @PostMapping("/add1")
    public Boolean add1(Demo demo, @RequestHeader Map<String, Object> requestHeader) {
        log.info("请求头 = {}", requestHeader);
        log.info("原始集合元素内容 = {}", demos);
        demos.add(demo);
        log.info("添加元素,集合元素内容 = {}", demos);
        return true;
    }

    @PutMapping("/update")
    public void update(@RequestBody Demo demo) {
        log.info("原始集合元素内容 = {}", demos);
        // 移除旧的添加新的
        demos.remove(demo);
        demos.add(demo);
        log.info("修改元素,集合元素内容 = {}", demos);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        log.info("原始集合元素内容 = {}", demos);
        int index = -1;
        for (int i = 0; i < demos.size(); i++) {
            if (demos.get(i).getId().equals(id)) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            demos.remove(index);
        }
        log.info("删除元素,集合元素内容 = {}", demos);
    }

}
