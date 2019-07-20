package com.bearcat2.entity.system;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Accessors(chain = true)
@Table(name = "sys_job")
public class SysJob {
    /**
     * 系统任务id
     */
    @Id
    @Column(name = "sj_id")
    private Integer sjId;

    /**
     * 任务名称
     */
    @Column(name = "sj_name")
    private String sjName;

    /**
     * 任务分组
     */
    @Column(name = "sj_group")
    private String sjGroup;

    /**
     * 任务状态(1:停止;2:运行)
     */
    @Column(name = "sj_status")
    private Integer sjStatus;

    /**
     * cron表达式
     */
    @Column(name = "sj_cron_expression")
    private String sjCronExpression;

    /**
     * 描述
     */
    @Column(name = "sj_description")
    private String sjDescription;

    /**
     * 调用类名称(包名+类名)
     */
    @Column(name = "sj_bean_class")
    private String sjBeanClass;

    /**
     * spring bean名称(IOC容器中bean名称)
     */
    @Column(name = "sj_spring_bean_name")
    private String sjSpringBeanName;

    /**
     * 任务调用方法名
     */
    @Column(name = "sj_method_name")
    private String sjMethodName;

    /**
     * 任务创建时间
     */
    @Column(name = "sj_create_time")
    private Date sjCreateTime;

    /**
     * 任务修改时间
     */
    @Column(name = "sj_update_time")
    private Date sjUpdateTime;

    public static final String SJ_ID = "sjId";

    public static final String DB_SJ_ID = "sj_id";

    public static final String SJ_NAME = "sjName";

    public static final String DB_SJ_NAME = "sj_name";

    public static final String SJ_GROUP = "sjGroup";

    public static final String DB_SJ_GROUP = "sj_group";

    public static final String SJ_STATUS = "sjStatus";

    public static final String DB_SJ_STATUS = "sj_status";

    public static final String SJ_CRON_EXPRESSION = "sjCronExpression";

    public static final String DB_SJ_CRON_EXPRESSION = "sj_cron_expression";

    public static final String SJ_DESCRIPTION = "sjDescription";

    public static final String DB_SJ_DESCRIPTION = "sj_description";

    public static final String SJ_BEAN_CLASS = "sjBeanClass";

    public static final String DB_SJ_BEAN_CLASS = "sj_bean_class";

    public static final String SJ_SPRING_BEAN_NAME = "sjSpringBeanName";

    public static final String DB_SJ_SPRING_BEAN_NAME = "sj_spring_bean_name";

    public static final String SJ_METHOD_NAME = "sjMethodName";

    public static final String DB_SJ_METHOD_NAME = "sj_method_name";

    public static final String SJ_CREATE_TIME = "sjCreateTime";

    public static final String DB_SJ_CREATE_TIME = "sj_create_time";

    public static final String SJ_UPDATE_TIME = "sjUpdateTime";

    public static final String DB_SJ_UPDATE_TIME = "sj_update_time";
}