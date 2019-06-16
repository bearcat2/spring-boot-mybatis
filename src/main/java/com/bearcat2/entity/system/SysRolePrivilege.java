package com.bearcat2.entity.system;

import java.io.Serializable;

public class SysRolePrivilege implements Serializable {
    /**
     * 角色权限表主键id,自增
     */
    private Integer srpId;

    /**
     * 角色表主键id
     */
    private Integer srpRoleId;

    /**
     * 权限表主键id
     */
    private Integer srpPrivilegeId;

    private static final long serialVersionUID = 1L;

    /**
     * 角色权限表主键id,自增
     * @return srp_id 角色权限表主键id,自增
     */
    public Integer getSrpId() {
        return srpId;
    }

    /**
     * 角色权限表主键id,自增
     * @param srpId 角色权限表主键id,自增
     */
    public void setSrpId(Integer srpId) {
        this.srpId = srpId;
    }

    /**
     * 角色表主键id
     * @return srp_role_id 角色表主键id
     */
    public Integer getSrpRoleId() {
        return srpRoleId;
    }

    /**
     * 角色表主键id
     * @param srpRoleId 角色表主键id
     */
    public void setSrpRoleId(Integer srpRoleId) {
        this.srpRoleId = srpRoleId;
    }

    /**
     * 权限表主键id
     * @return srp_privilege_id 权限表主键id
     */
    public Integer getSrpPrivilegeId() {
        return srpPrivilegeId;
    }

    /**
     * 权限表主键id
     * @param srpPrivilegeId 权限表主键id
     */
    public void setSrpPrivilegeId(Integer srpPrivilegeId) {
        this.srpPrivilegeId = srpPrivilegeId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", srpId=").append(srpId);
        sb.append(", srpRoleId=").append(srpRoleId);
        sb.append(", srpPrivilegeId=").append(srpPrivilegeId);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        SysRolePrivilege other = (SysRolePrivilege) that;
        return (this.getSrpId() == null ? other.getSrpId() == null : this.getSrpId().equals(other.getSrpId()))
            && (this.getSrpRoleId() == null ? other.getSrpRoleId() == null : this.getSrpRoleId().equals(other.getSrpRoleId()))
            && (this.getSrpPrivilegeId() == null ? other.getSrpPrivilegeId() == null : this.getSrpPrivilegeId().equals(other.getSrpPrivilegeId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getSrpId() == null) ? 0 : getSrpId().hashCode());
        result = prime * result + ((getSrpRoleId() == null) ? 0 : getSrpRoleId().hashCode());
        result = prime * result + ((getSrpPrivilegeId() == null) ? 0 : getSrpPrivilegeId().hashCode());
        return result;
    }
}