package com.bearcat2.entity.system;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class SysPrivilege implements Serializable {
    /**
     * 权限id
     */
    private Integer spId;

    /**
     * 资源名称
     */
    private String spName;

    /**
     * 资源uri
     */
    private String spUri;

    /**
     * 资源类型(1:模块;2:菜单;3:按钮)
     */
    private Integer spType;

    /**
     * 操作名
     */
    private String spOperateName;

    /**
     * 父权限id
     */
    private Integer spParentId;

    /**
     * 位置排序
     */
    private Integer spOrderd;

    /**
     * 创建时间
     */
    private Date spCreateTime;

    /**
     * 修改时间
     */
    private Date spUpdateTime;

    private static final long serialVersionUID = 1L;

    // 获取所有子权限
    private List<SysPrivilege> childrenSysPrivilege = new ArrayList<>();

    /**
     * 权限id
     * @return sp_id 权限id
     */
    public Integer getSpId() {
        return spId;
    }

    /**
     * 权限id
     * @param spId 权限id
     */
    public void setSpId(Integer spId) {
        this.spId = spId;
    }

    /**
     * 资源名称
     * @return sp_name 资源名称
     */
    public String getSpName() {
        return spName;
    }

    /**
     * 资源名称
     * @param spName 资源名称
     */
    public void setSpName(String spName) {
        this.spName = spName == null ? null : spName.trim();
    }

    /**
     * 资源uri
     * @return sp_uri 资源uri
     */
    public String getSpUri() {
        return spUri;
    }

    /**
     * 资源uri
     * @param spUri 资源uri
     */
    public void setSpUri(String spUri) {
        this.spUri = spUri == null ? null : spUri.trim();
    }

    /**
     * 资源类型(1:模块;2:菜单;3:按钮)
     * @return sp_type 资源类型(1:模块;2:菜单;3:按钮)
     */
    public Integer getSpType() {
        return spType;
    }

    /**
     * 资源类型(1:模块;2:菜单;3:按钮)
     * @param spType 资源类型(1:模块;2:菜单;3:按钮)
     */
    public void setSpType(Integer spType) {
        this.spType = spType;
    }

    /**
     * 操作名
     * @return sp_operate_name 操作名
     */
    public String getSpOperateName() {
        return spOperateName;
    }

    /**
     * 操作名
     * @param spOperateName 操作名
     */
    public void setSpOperateName(String spOperateName) {
        this.spOperateName = spOperateName == null ? null : spOperateName.trim();
    }

    /**
     * 父权限id
     * @return sp_parent_id 父权限id
     */
    public Integer getSpParentId() {
        return spParentId;
    }

    /**
     * 父权限id
     * @param spParentId 父权限id
     */
    public void setSpParentId(Integer spParentId) {
        this.spParentId = spParentId;
    }

    /**
     * 位置排序
     * @return sp_orderd 位置排序
     */
    public Integer getSpOrderd() {
        return spOrderd;
    }

    /**
     * 位置排序
     * @param spOrderd 位置排序
     */
    public void setSpOrderd(Integer spOrderd) {
        this.spOrderd = spOrderd;
    }

    /**
     * 创建时间
     * @return sp_create_time 创建时间
     */
    public Date getSpCreateTime() {
        return spCreateTime;
    }

    /**
     * 创建时间
     * @param spCreateTime 创建时间
     */
    public void setSpCreateTime(Date spCreateTime) {
        this.spCreateTime = spCreateTime;
    }

    /**
     * 修改时间
     * @return sp_update_time 修改时间
     */
    public Date getSpUpdateTime() {
        return spUpdateTime;
    }

    /**
     * 修改时间
     * @param spUpdateTime 修改时间
     */
    public void setSpUpdateTime(Date spUpdateTime) {
        this.spUpdateTime = spUpdateTime;
    }

    public List<SysPrivilege> getChildrenSysPrivilege() {
        return childrenSysPrivilege;
    }

    public void setChildrenSysPrivilege(List<SysPrivilege> childrenSysPrivilege) {
        this.childrenSysPrivilege = childrenSysPrivilege;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", spId=").append(spId);
        sb.append(", spName=").append(spName);
        sb.append(", spUri=").append(spUri);
        sb.append(", spType=").append(spType);
        sb.append(", spOperateName=").append(spOperateName);
        sb.append(", spParentId=").append(spParentId);
        sb.append(", spOrderd=").append(spOrderd);
        sb.append(", spCreateTime=").append(spCreateTime);
        sb.append(", spUpdateTime=").append(spUpdateTime);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SysPrivilege privilege = (SysPrivilege) o;
        return Objects.equals(spId, privilege.spId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(spId);
    }
}