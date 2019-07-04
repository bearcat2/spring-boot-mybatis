package com.bearcat2.entity.common;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * <p> Description: 前端分配按钮穿梭框数据 </p>
 * <p> Title: AllotButtonTransfer </p>
 * <p> Create Time: 2019/6/26 18:26 </p>
 *
 * @author: zhongzhipeng
 * @version: 1.0
 */
@Data
public class AllotButtonTransfer {

    /** 穿梭框数据 */
    private List<Transfer> data = new ArrayList<>();

    /** 选中数据,右侧列表展示数据 */
    private List<String> rightSelectData = new ArrayList<>();

    @Data
    public static class Transfer {

        /** 数据值 */
        private String value;

        /** 数据标题 */
        private String title;

        /** 是否禁用 */
        private boolean disabled;

        /** 是否选中 */
        private boolean checked;
    }
}
