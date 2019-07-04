package com.bearcat2.entity.system;

import com.bearcat2.entity.common.CommonEntity;

import java.io.Serializable;
import java.util.Date;

public class SysRole extends CommonEntity implements Serializable {
    /**
     * 角色id,自增
     */
    private Integer srId;

    /**
     * 角色名
     */
    private String srName;

    /**
     * 角色描述
     */
    private String srDescription;

    /**
     * 创建时间
     */
    private Date srCreateTime;

    /**
     * 修改时间
     */
    private Date srUpdateTime;

    private static final long serialVersionUID = 1L;

    /**
     * 角色id,自增
     *
     * @return sr_id 角色id,自增
     */
    public Integer getSrId() {
        return srId;
    }

    /**
     * 角色id,自增
     *
     * @param srId 角色id,自增
     */
    public void setSrId(Integer srId) {
        this.srId = srId;
    }

    /**
     * 角色名
     *
     * @return sr_name 角色名
     */
    public String getSrName() {
        return srName;
    }

    /**
     * 角色名
     *
     * @param srName 角色名
     */
    public void setSrName(String srName) {
        this.srName = srName == null ? null : srName.trim();
    }

    /**
     * 角色描述
     *
     * @return sr_description 角色描述
     */
    public String getSrDescription() {
        return srDescription;
    }

    /**
     * 角色描述
     *
     * @param srDescription 角色描述
     */
    public void setSrDescription(String srDescription) {
        this.srDescription = srDescription == null ? null : srDescription.trim();
    }

    /**
     * 创建时间
     *
     * @return sr_create_time 创建时间
     */
    public Date getSrCreateTime() {
        return srCreateTime;
    }

    /**
     * 创建时间
     *
     * @param srCreateTime 创建时间
     */
    public void setSrCreateTime(Date srCreateTime) {
        this.srCreateTime = srCreateTime;
    }

    /**
     * 修改时间
     *
     * @return sr_update_time 修改时间
     */
    public Date getSrUpdateTime() {
        return srUpdateTime;
    }

    /**
     * 修改时间
     *
     * @param srUpdateTime 修改时间
     */
    public void setSrUpdateTime(Date srUpdateTime) {
        this.srUpdateTime = srUpdateTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", srId=").append(srId);
        sb.append(", srName=").append(srName);
        sb.append(", srDescription=").append(srDescription);
        sb.append(", srCreateTime=").append(srCreateTime);
        sb.append(", srUpdateTime=").append(srUpdateTime);
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
        SysRole other = (SysRole) that;
        return (this.getSrId() == null ? other.getSrId() == null : this.getSrId().equals(other.getSrId()))
                && (this.getSrName() == null ? other.getSrName() == null : this.getSrName().equals(other.getSrName()))
                && (this.getSrDescription() == null ? other.getSrDescription() == null : this.getSrDescription().equals(other.getSrDescription()))
                && (this.getSrCreateTime() == null ? other.getSrCreateTime() == null : this.getSrCreateTime().equals(other.getSrCreateTime()))
                && (this.getSrUpdateTime() == null ? other.getSrUpdateTime() == null : this.getSrUpdateTime().equals(other.getSrUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getSrId() == null) ? 0 : getSrId().hashCode());
        result = prime * result + ((getSrName() == null) ? 0 : getSrName().hashCode());
        result = prime * result + ((getSrDescription() == null) ? 0 : getSrDescription().hashCode());
        result = prime * result + ((getSrCreateTime() == null) ? 0 : getSrCreateTime().hashCode());
        result = prime * result + ((getSrUpdateTime() == null) ? 0 : getSrUpdateTime().hashCode());
        return result;
    }
}