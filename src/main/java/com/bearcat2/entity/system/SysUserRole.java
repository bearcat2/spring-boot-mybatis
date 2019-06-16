package com.bearcat2.entity.system;

import java.io.Serializable;

public class SysUserRole implements Serializable {
    /**
     * 用户角色表主键,自增
     */
    private Integer surId;

    /**
     * 用户表主键
     */
    private Integer surUserId;

    /**
     * 角色表主键
     */
    private Integer surRoleId;

    private static final long serialVersionUID = 1L;

    /**
     * 用户角色表主键,自增
     * @return sur_id 用户角色表主键,自增
     */
    public Integer getSurId() {
        return surId;
    }

    /**
     * 用户角色表主键,自增
     * @param surId 用户角色表主键,自增
     */
    public void setSurId(Integer surId) {
        this.surId = surId;
    }

    /**
     * 用户表主键
     * @return sur_user_id 用户表主键
     */
    public Integer getSurUserId() {
        return surUserId;
    }

    /**
     * 用户表主键
     * @param surUserId 用户表主键
     */
    public void setSurUserId(Integer surUserId) {
        this.surUserId = surUserId;
    }

    /**
     * 角色表主键
     * @return sur_role_id 角色表主键
     */
    public Integer getSurRoleId() {
        return surRoleId;
    }

    /**
     * 角色表主键
     * @param surRoleId 角色表主键
     */
    public void setSurRoleId(Integer surRoleId) {
        this.surRoleId = surRoleId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", surId=").append(surId);
        sb.append(", surUserId=").append(surUserId);
        sb.append(", surRoleId=").append(surRoleId);
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
        SysUserRole other = (SysUserRole) that;
        return (this.getSurId() == null ? other.getSurId() == null : this.getSurId().equals(other.getSurId()))
            && (this.getSurUserId() == null ? other.getSurUserId() == null : this.getSurUserId().equals(other.getSurUserId()))
            && (this.getSurRoleId() == null ? other.getSurRoleId() == null : this.getSurRoleId().equals(other.getSurRoleId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getSurId() == null) ? 0 : getSurId().hashCode());
        result = prime * result + ((getSurUserId() == null) ? 0 : getSurUserId().hashCode());
        result = prime * result + ((getSurRoleId() == null) ? 0 : getSurRoleId().hashCode());
        return result;
    }
}