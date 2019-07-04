package com.bearcat2.entity.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

/**
 * <p> Description: 前端treeSelect插件所需格式 </p>
 * <p> Title: TreeSelectNode </p>
 * <p> Create Time: 2019/6/17 20:18 </p>
 *
 * @author: zhongzhipeng
 * @version: 1.0
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TreeSelectNode {

    /** id元素 */
    private Integer id;

    /** name元素 */
    private String name;

    /** 是否默认选中 */
    private boolean checked;

    /** 是否默认展开树节点 */
    private boolean open;

    /** 子节点元素 */
    private List<TreeSelectNode> children;
}
