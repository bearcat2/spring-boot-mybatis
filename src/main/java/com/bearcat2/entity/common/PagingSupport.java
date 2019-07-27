package com.bearcat2.entity.common;

import lombok.Getter;
import lombok.Setter;

/**
 * <p> Description: 分页支持类 </p>
 * <p> Title: PagingSupport </p>
 * <p> Create Time: 2019/7/20 22:31 </p>
 *
 * @author zhongzhipeng
 * @since 1.0
 */
@Getter
@Setter
public class PagingSupport {

    /** 当前所在页码,默认为第一页 */
    private Integer page = 1;

    /** 每页显示多少条数据,默认显示15条 */
    private Integer limit = 15;
}
