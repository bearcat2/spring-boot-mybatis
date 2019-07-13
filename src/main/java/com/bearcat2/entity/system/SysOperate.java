package com.bearcat2.entity.system;

import com.bearcat2.entity.common.CommonEntity;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Accessors(chain = true)
@Table(name = "sys_operate")
public class SysOperate extends CommonEntity {
    /**
     * 操作id,自增
     */
    @Id
    @Column(name = "so_id")
    private Integer soId;

    /**
     * 操作名称
     */
    @Column(name = "so_name")
    private String soName;

    /**
     * 显示名称(操作名的中文显示)
     */
    @Column(name = "so_show_name")
    private String soShowName;

    /**
     * 序号
     */
    @Column(name = "so_orderd")
    private Integer soOrderd;

    /**
     * 创建时间
     */
    @Column(name = "so_create_time")
    private Date soCreateTime;

    /**
     * 创建人
     */
    @Column(name = "so_create_user")
    private String soCreateUser;

    /**
     * 更新时间
     */
    @Column(name = "so_update_time")
    private Date soUpdateTime;

    /**
     * 更新人
     */
    @Column(name = "so_update_user")
    private String soUpdateUser;

    public static final String SO_ID = "soId";

    public static final String DB_SO_ID = "so_id";

    public static final String SO_NAME = "soName";

    public static final String DB_SO_NAME = "so_name";

    public static final String SO_SHOW_NAME = "soShowName";

    public static final String DB_SO_SHOW_NAME = "so_show_name";

    public static final String SO_ORDERD = "soOrderd";

    public static final String DB_SO_ORDERD = "so_orderd";

    public static final String SO_CREATE_TIME = "soCreateTime";

    public static final String DB_SO_CREATE_TIME = "so_create_time";

    public static final String SO_CREATE_USER = "soCreateUser";

    public static final String DB_SO_CREATE_USER = "so_create_user";

    public static final String SO_UPDATE_TIME = "soUpdateTime";

    public static final String DB_SO_UPDATE_TIME = "so_update_time";

    public static final String SO_UPDATE_USER = "soUpdateUser";

    public static final String DB_SO_UPDATE_USER = "so_update_user";
}