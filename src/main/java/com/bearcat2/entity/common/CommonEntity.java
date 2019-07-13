package com.bearcat2.entity.common;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Transient;
import java.io.Serializable;

/**
 * <p> Description: 通用实体对象 </p>
 * <p> Title: CommonEntity </p>
 * <p> Create Time: 2019/5/11 22:36 </p>
 *
 * @author: zhongzhipeng
 * @version: 1.0
 */
@Getter
@Setter
public class CommonEntity implements Serializable {

    private static final long serialVersionUID = 6667922572485781040L;

    /** 当前所在页码,默认为第一页 */
    @Transient
    private Integer page = 1;

    /** 每页显示多少条数据,默认显示10条 */
    @Transient
    private Integer limit = 10;

}
