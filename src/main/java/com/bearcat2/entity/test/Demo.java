package com.bearcat2.entity.test;

import lombok.*;

/**
 * <p> Description: 测试类 </p>
 * <p> Title: Demo </p>
 * <p> Create Time: 2019/7/20 23:38 </p>
 *
 * @author zhongzhipeng
 * @since 1.0
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
public class Demo {
    private Integer id;

    private String name;
}