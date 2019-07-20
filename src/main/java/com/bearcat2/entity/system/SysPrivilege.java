package com.bearcat2.entity.system;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Accessors(chain = true)
@Table(name = "sys_privilege")
public class SysPrivilege {
    /**
     * 权限id
     */
    @Id
    @Column(name = "sp_id")
    private Integer spId;

    /**
     * 资源名称
     */
    @Column(name = "sp_name")
    private String spName;

    /**
     * 资源uri
     */
    @Column(name = "sp_uri")
    private String spUri;

    /**
     * 资源类型(1:模块;2:菜单;3:按钮)
     */
    @Column(name = "sp_type")
    private Integer spType;

    /**
     * 操作名
     */
    @Column(name = "sp_operate_name")
    private String spOperateName;

    /**
     * 父权限id
     */
    @Column(name = "sp_parent_id")
    private Integer spParentId;

    /**
     * 位置排序
     */
    @Column(name = "sp_orderd")
    private Integer spOrderd;

    /**
     * 创建时间
     */
    @Column(name = "sp_create_time")
    private Date spCreateTime;

    /**
     * 修改时间
     */
    @Column(name = "sp_update_time")
    private Date spUpdateTime;

    // 获取所有子权限
    private List<SysPrivilege> childrenSysPrivilege = new ArrayList<>();

    public static final String SP_ID = "spId";

    public static final String DB_SP_ID = "sp_id";

    public static final String SP_NAME = "spName";

    public static final String DB_SP_NAME = "sp_name";

    public static final String SP_URI = "spUri";

    public static final String DB_SP_URI = "sp_uri";

    public static final String SP_TYPE = "spType";

    public static final String DB_SP_TYPE = "sp_type";

    public static final String SP_OPERATE_NAME = "spOperateName";

    public static final String DB_SP_OPERATE_NAME = "sp_operate_name";

    public static final String SP_PARENT_ID = "spParentId";

    public static final String DB_SP_PARENT_ID = "sp_parent_id";

    public static final String SP_ORDERD = "spOrderd";

    public static final String DB_SP_ORDERD = "sp_orderd";

    public static final String SP_CREATE_TIME = "spCreateTime";

    public static final String DB_SP_CREATE_TIME = "sp_create_time";

    public static final String SP_UPDATE_TIME = "spUpdateTime";

    public static final String DB_SP_UPDATE_TIME = "sp_update_time";
}