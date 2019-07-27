package com.bearcat2.entity.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

/**
 * <p> Description: layui tree 模块数据源 ,目前tree功能还不完善
 * 所以需引入 treeTable和treeSelect插件,后期看官方更新,逐步统一
 * </p>
 * <p> Title: LayuiTreeNode </p>
 * <p> Create Time: 2019/6/19 22:24 </p>
 *
 * @author zhongzhipeng
 * @since 1.0
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LayuiTreeNode {

    /** 节点唯一索引，用于对指定节点进行各类操作 */
    private Integer id;

    /** 节点标题 */
    private String title;

    /** 节点是否初始展开，默认 false */
    private boolean spread;

    /** 节点是否初始为选中状态（如果开启复选框的话），默认 false */
    private boolean checked;

    /** 节点是否为禁用状态。默认 false */
    private boolean disabled;

    /** 子节点 */
    private List<LayuiTreeNode> children;

    /** 点击节点弹出新窗口对应的 url。需开启 isJump 参数 */
    private String href;
}
