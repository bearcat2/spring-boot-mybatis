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
@Table(name = "sys_user")
public class SysUser extends CommonEntity {
    /**
     * 用户id,自增
     */
    @Id
    @Column(name = "su_id")
    private Integer suId;

    /**
     * 登录名
     */
    @Column(name = "su_login_name")
    private String suLoginName;

    /**
     * 真实姓名
     */
    @Column(name = "su_real_name")
    private String suRealName;

    /**
     * 密码
     */
    @Column(name = "su_password")
    private String suPassword;

    /**
     * 创建时间
     */
    @Column(name = "su_create_time")
    private Date suCreateTime;

    /**
     * 修改时间
     */
    @Column(name = "su_update_time")
    private Date suUpdateTime;

    public static final String SU_ID = "suId";

    public static final String DB_SU_ID = "su_id";

    public static final String SU_LOGIN_NAME = "suLoginName";

    public static final String DB_SU_LOGIN_NAME = "su_login_name";

    public static final String SU_REAL_NAME = "suRealName";

    public static final String DB_SU_REAL_NAME = "su_real_name";

    public static final String SU_PASSWORD = "suPassword";

    public static final String DB_SU_PASSWORD = "su_password";

    public static final String SU_CREATE_TIME = "suCreateTime";

    public static final String DB_SU_CREATE_TIME = "su_create_time";

    public static final String SU_UPDATE_TIME = "suUpdateTime";

    public static final String DB_SU_UPDATE_TIME = "su_update_time";
}