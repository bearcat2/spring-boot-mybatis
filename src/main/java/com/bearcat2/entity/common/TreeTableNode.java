package com.bearcat2.entity.common;

import lombok.Data;

/**
 * <p> Description: 前端treeTabel插件所需节点数据 </p>
 * <p> Title: TreeTableNode </p>
 * <p> Create Time: 2019/6/16 18:58 </p>
 *
 * @author zhongzhipeng
 * @since 1.0
 */
@Data
public class TreeTableNode {

    /** 节点id */
    private Integer id;

    /** 节点父id */
    private Integer pid;

    /** 节点显示标题 */
    private String title;

    /** 资源url */
    private String url;

    /** 序号 */
    private Integer orderd;

    /** 类型 (1:模块;2:菜单) */
    private Integer type;
}
