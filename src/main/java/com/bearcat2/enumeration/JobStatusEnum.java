package com.bearcat2.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <p> Description: 任务状态枚举类 </p>
 * <p> Title: JobStatusEnum </p>
 * <p> Create Time: 2019/7/13 21:31 </p>
 *
 * @author zhongzhipeng
 * @since 1.0
 */
@Getter
@AllArgsConstructor
public enum JobStatusEnum {

    STOP_STATUS(1, "停止状态"),
    RUNNING_STATUS(2, "运行状态");

    /** 任务状态(1:停车;2:运行) */
    private int status;

    /** 状态对应的描述 */
    private String description;

    /**
     * 根据任务状态获取对应的枚举对象
     *
     * @param status 任务状态
     * @return JobStatusEnum 任务枚举对象
     */
    public static JobStatusEnum findByStatus(Integer status) {
        if (status == null) {
            return null;
        }
        for (JobStatusEnum jobStatusEnum : JobStatusEnum.values()) {
            if (jobStatusEnum.getStatus() == status) {
                return jobStatusEnum;
            }
        }
        return null;
    }
}
