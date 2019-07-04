package com.bearcat2.entity.system;

import com.bearcat2.entity.common.CommonEntity;

import java.util.Date;

public class SysOperate extends CommonEntity {
    /**
     * 操作id,自增
     */
    private Integer soId;

    /**
     * 操作名称
     */
    private String soName;

    /**
     * 显示名称(操作名的中文显示)
     */
    private String soShowName;

    /**
     * 序号
     */
    private Integer soOrderd;

    /**
     * 创建时间
     */
    private Date soCreateTime;

    /**
     * 创建人
     */
    private String soCreateUser;

    /**
     * 更新时间
     */
    private Date soUpdateTime;

    /**
     * 更新人
     */
    private String soUpdateUser;

    private static final long serialVersionUID = 1L;

    /**
     * 操作id,自增
     *
     * @return so_id 操作id,自增
     */
    public Integer getSoId() {
        return soId;
    }

    /**
     * 操作id,自增
     *
     * @param soId 操作id,自增
     */
    public void setSoId(Integer soId) {
        this.soId = soId;
    }

    /**
     * 操作名称
     *
     * @return so_name 操作名称
     */
    public String getSoName() {
        return soName;
    }

    /**
     * 操作名称
     *
     * @param soName 操作名称
     */
    public void setSoName(String soName) {
        this.soName = soName == null ? null : soName.trim();
    }

    /**
     * 显示名称(操作名的中文显示)
     *
     * @return so_show_name 显示名称(操作名的中文显示)
     */
    public String getSoShowName() {
        return soShowName;
    }

    /**
     * 显示名称(操作名的中文显示)
     *
     * @param soShowName 显示名称(操作名的中文显示)
     */
    public void setSoShowName(String soShowName) {
        this.soShowName = soShowName == null ? null : soShowName.trim();
    }

    /**
     * 序号
     *
     * @return so_orderd 序号
     */
    public Integer getSoOrderd() {
        return soOrderd;
    }

    /**
     * 序号
     *
     * @param soOrderd 序号
     */
    public void setSoOrderd(Integer soOrderd) {
        this.soOrderd = soOrderd;
    }

    /**
     * 创建时间
     *
     * @return so_create_time 创建时间
     */
    public Date getSoCreateTime() {
        return soCreateTime;
    }

    /**
     * 创建时间
     *
     * @param soCreateTime 创建时间
     */
    public void setSoCreateTime(Date soCreateTime) {
        this.soCreateTime = soCreateTime;
    }

    /**
     * 创建人
     *
     * @return so_create_user 创建人
     */
    public String getSoCreateUser() {
        return soCreateUser;
    }

    /**
     * 创建人
     *
     * @param soCreateUser 创建人
     */
    public void setSoCreateUser(String soCreateUser) {
        this.soCreateUser = soCreateUser == null ? null : soCreateUser.trim();
    }

    /**
     * 更新时间
     *
     * @return so_update_time 更新时间
     */
    public Date getSoUpdateTime() {
        return soUpdateTime;
    }

    /**
     * 更新时间
     *
     * @param soUpdateTime 更新时间
     */
    public void setSoUpdateTime(Date soUpdateTime) {
        this.soUpdateTime = soUpdateTime;
    }

    /**
     * 更新人
     *
     * @return so_update_user 更新人
     */
    public String getSoUpdateUser() {
        return soUpdateUser;
    }

    /**
     * 更新人
     *
     * @param soUpdateUser 更新人
     */
    public void setSoUpdateUser(String soUpdateUser) {
        this.soUpdateUser = soUpdateUser == null ? null : soUpdateUser.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", soId=").append(soId);
        sb.append(", soName=").append(soName);
        sb.append(", soShowName=").append(soShowName);
        sb.append(", soOrderd=").append(soOrderd);
        sb.append(", soCreateTime=").append(soCreateTime);
        sb.append(", soCreateUser=").append(soCreateUser);
        sb.append(", soUpdateTime=").append(soUpdateTime);
        sb.append(", soUpdateUser=").append(soUpdateUser);
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
        SysOperate other = (SysOperate) that;
        return (this.getSoId() == null ? other.getSoId() == null : this.getSoId().equals(other.getSoId()))
                && (this.getSoName() == null ? other.getSoName() == null : this.getSoName().equals(other.getSoName()))
                && (this.getSoShowName() == null ? other.getSoShowName() == null : this.getSoShowName().equals(other.getSoShowName()))
                && (this.getSoOrderd() == null ? other.getSoOrderd() == null : this.getSoOrderd().equals(other.getSoOrderd()))
                && (this.getSoCreateTime() == null ? other.getSoCreateTime() == null : this.getSoCreateTime().equals(other.getSoCreateTime()))
                && (this.getSoCreateUser() == null ? other.getSoCreateUser() == null : this.getSoCreateUser().equals(other.getSoCreateUser()))
                && (this.getSoUpdateTime() == null ? other.getSoUpdateTime() == null : this.getSoUpdateTime().equals(other.getSoUpdateTime()))
                && (this.getSoUpdateUser() == null ? other.getSoUpdateUser() == null : this.getSoUpdateUser().equals(other.getSoUpdateUser()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getSoId() == null) ? 0 : getSoId().hashCode());
        result = prime * result + ((getSoName() == null) ? 0 : getSoName().hashCode());
        result = prime * result + ((getSoShowName() == null) ? 0 : getSoShowName().hashCode());
        result = prime * result + ((getSoOrderd() == null) ? 0 : getSoOrderd().hashCode());
        result = prime * result + ((getSoCreateTime() == null) ? 0 : getSoCreateTime().hashCode());
        result = prime * result + ((getSoCreateUser() == null) ? 0 : getSoCreateUser().hashCode());
        result = prime * result + ((getSoUpdateTime() == null) ? 0 : getSoUpdateTime().hashCode());
        result = prime * result + ((getSoUpdateUser() == null) ? 0 : getSoUpdateUser().hashCode());
        return result;
    }
}