package com.bearcat2.entity.system;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Accessors(chain = true)
@Table(name = "sys_role")
public class SysRole  {
    /**
     * 角色id,自增
     */
    @Id
    @Column(name = "sr_id")
    private Integer srId;

    /**
     * 角色名
     */
    @Column(name = "sr_name")
    private String srName;

    /**
     * 角色描述
     */
    @Column(name = "sr_description")
    private String srDescription;

    /**
     * 创建时间
     */
    @Column(name = "sr_create_time")
    private Date srCreateTime;

    /**
     * 修改时间
     */
    @Column(name = "sr_update_time")
    private Date srUpdateTime;

    public static final String SR_ID = "srId";

    public static final String DB_SR_ID = "sr_id";

    public static final String SR_NAME = "srName";

    public static final String DB_SR_NAME = "sr_name";

    public static final String SR_DESCRIPTION = "srDescription";

    public static final String DB_SR_DESCRIPTION = "sr_description";

    public static final String SR_CREATE_TIME = "srCreateTime";

    public static final String DB_SR_CREATE_TIME = "sr_create_time";

    public static final String SR_UPDATE_TIME = "srUpdateTime";

    public static final String DB_SR_UPDATE_TIME = "sr_update_time";
}