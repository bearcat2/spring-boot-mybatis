package com.bearcat2.entity.common;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <p> Description: 通用实体对象 </p>
 * <p> Title: BaseEntity </p>
 * <p> Create Time: 2019/5/11 22:36 </p>
 *
 * @author: zhongzhipeng
 * @version: 1.0
 */
@Getter
@Setter
public class BaseEntity implements Serializable {

    /** 当前所在页码,默认为第一页 */
    private Integer page = 1;

    /** 每页显示多少条数据,默认显示10条 */
    private Integer limit = 10;

}
