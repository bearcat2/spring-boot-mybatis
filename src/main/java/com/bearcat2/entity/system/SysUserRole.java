package com.bearcat2.entity.system;

import com.bearcat2.entity.common.CommonEntity;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Accessors(chain = true)
@Table(name = "sys_user_role")
public class SysUserRole extends CommonEntity {
    /**
     * 用户角色表主键,自增
     */
    @Id
    @Column(name = "sur_id")
    private Integer surId;

    /**
     * 用户表主键
     */
    @Column(name = "sur_user_id")
    private Integer surUserId;

    /**
     * 角色表主键
     */
    @Column(name = "sur_role_id")
    private Integer surRoleId;

    public static final String SUR_ID = "surId";

    public static final String DB_SUR_ID = "sur_id";

    public static final String SUR_USER_ID = "surUserId";

    public static final String DB_SUR_USER_ID = "sur_user_id";

    public static final String SUR_ROLE_ID = "surRoleId";

    public static final String DB_SUR_ROLE_ID = "sur_role_id";
}