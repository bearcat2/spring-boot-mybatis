package com.bearcat2.entity.system;

import com.bearcat2.entity.common.CommonEntity;

import java.io.Serializable;
import java.util.Date;

public class SysUser extends CommonEntity implements Serializable {
    /**
     * 用户id,自增
     */
    private Integer suId;

    /**
     * 登录名
     */
    private String suLoginName;

    /**
     * 真实姓名
     */
    private String suRealName;

    /**
     * 密码
     */
    private String suPassword;

    /**
     * 创建时间
     */
    private Date suCreateTime;

    /**
     * 修改时间
     */
    private Date suUpdateTime;

    private static final long serialVersionUID = 1L;

    /**
     * 用户id,自增
     * @return su_id 用户id,自增
     */
    public Integer getSuId() {
        return suId;
    }

    /**
     * 用户id,自增
     * @param suId 用户id,自增
     */
    public void setSuId(Integer suId) {
        this.suId = suId;
    }

    /**
     * 登录名
     * @return su_login_name 登录名
     */
    public String getSuLoginName() {
        return suLoginName;
    }

    /**
     * 登录名
     * @param suLoginName 登录名
     */
    public void setSuLoginName(String suLoginName) {
        this.suLoginName = suLoginName == null ? null : suLoginName.trim();
    }

    /**
     * 真实姓名
     * @return su_real_name 真实姓名
     */
    public String getSuRealName() {
        return suRealName;
    }

    /**
     * 真实姓名
     * @param suRealName 真实姓名
     */
    public void setSuRealName(String suRealName) {
        this.suRealName = suRealName == null ? null : suRealName.trim();
    }

    /**
     * 密码
     * @return su_password 密码
     */
    public String getSuPassword() {
        return suPassword;
    }

    /**
     * 密码
     * @param suPassword 密码
     */
    public void setSuPassword(String suPassword) {
        this.suPassword = suPassword == null ? null : suPassword.trim();
    }

    /**
     * 创建时间
     * @return su_create_time 创建时间
     */
    public Date getSuCreateTime() {
        return suCreateTime;
    }

    /**
     * 创建时间
     * @param suCreateTime 创建时间
     */
    public void setSuCreateTime(Date suCreateTime) {
        this.suCreateTime = suCreateTime;
    }

    /**
     * 修改时间
     * @return su_update_time 修改时间
     */
    public Date getSuUpdateTime() {
        return suUpdateTime;
    }

    /**
     * 修改时间
     * @param suUpdateTime 修改时间
     */
    public void setSuUpdateTime(Date suUpdateTime) {
        this.suUpdateTime = suUpdateTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", suId=").append(suId);
        sb.append(", suLoginName=").append(suLoginName);
        sb.append(", suRealName=").append(suRealName);
        sb.append(", suPassword=").append(suPassword);
        sb.append(", suCreateTime=").append(suCreateTime);
        sb.append(", suUpdateTime=").append(suUpdateTime);
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
        SysUser other = (SysUser) that;
        return (this.getSuId() == null ? other.getSuId() == null : this.getSuId().equals(other.getSuId()))
            && (this.getSuLoginName() == null ? other.getSuLoginName() == null : this.getSuLoginName().equals(other.getSuLoginName()))
            && (this.getSuRealName() == null ? other.getSuRealName() == null : this.getSuRealName().equals(other.getSuRealName()))
            && (this.getSuPassword() == null ? other.getSuPassword() == null : this.getSuPassword().equals(other.getSuPassword()))
            && (this.getSuCreateTime() == null ? other.getSuCreateTime() == null : this.getSuCreateTime().equals(other.getSuCreateTime()))
            && (this.getSuUpdateTime() == null ? other.getSuUpdateTime() == null : this.getSuUpdateTime().equals(other.getSuUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getSuId() == null) ? 0 : getSuId().hashCode());
        result = prime * result + ((getSuLoginName() == null) ? 0 : getSuLoginName().hashCode());
        result = prime * result + ((getSuRealName() == null) ? 0 : getSuRealName().hashCode());
        result = prime * result + ((getSuPassword() == null) ? 0 : getSuPassword().hashCode());
        result = prime * result + ((getSuCreateTime() == null) ? 0 : getSuCreateTime().hashCode());
        result = prime * result + ((getSuUpdateTime() == null) ? 0 : getSuUpdateTime().hashCode());
        return result;
    }
}