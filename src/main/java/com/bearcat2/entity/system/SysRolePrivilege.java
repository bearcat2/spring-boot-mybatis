package com.bearcat2.entity.system;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Accessors(chain = true)
@Table(name = "sys_role_privilege")
public class SysRolePrivilege  {
    /**
     * 角色权限表主键id,自增
     */
    @Id
    @Column(name = "srp_id")
    private Integer srpId;

    /**
     * 角色表主键id
     */
    @Column(name = "srp_role_id")
    private Integer srpRoleId;

    /**
     * 权限表主键id
     */
    @Column(name = "srp_privilege_id")
    private Integer srpPrivilegeId;

    public static final String SRP_ID = "srpId";

    public static final String DB_SRP_ID = "srp_id";

    public static final String SRP_ROLE_ID = "srpRoleId";

    public static final String DB_SRP_ROLE_ID = "srp_role_id";

    public static final String SRP_PRIVILEGE_ID = "srpPrivilegeId";

    public static final String DB_SRP_PRIVILEGE_ID = "srp_privilege_id";
}