package com.bearcat2.entity.system;

import java.io.Serializable;

public class SysDataDictionary implements Serializable {
    /**
     * 主键id,自增
     */
    private Integer sdrId;

    /**
     * 字典名
     */
    private String sdrName;

    /**
     * 字典值value
     */
    private String sdrValue;

    /**
     * 父id
     */
    private Integer sdrParentId;

    /**
     * 层级关系
     */
    private Integer sdrLevel;

    /**
     * 序号
     */
    private Integer sdrOrder;

    private static final long serialVersionUID = 1L;

    /**
     * 主键id,自增
     * @return sdr_id 主键id,自增
     */
    public Integer getSdrId() {
        return sdrId;
    }

    /**
     * 主键id,自增
     * @param sdrId 主键id,自增
     */
    public void setSdrId(Integer sdrId) {
        this.sdrId = sdrId;
    }

    /**
     * 字典名
     * @return sdr_name 字典名
     */
    public String getSdrName() {
        return sdrName;
    }

    /**
     * 字典名
     * @param sdrName 字典名
     */
    public void setSdrName(String sdrName) {
        this.sdrName = sdrName == null ? null : sdrName.trim();
    }

    /**
     * 字典值value
     * @return sdr_value 字典值value
     */
    public String getSdrValue() {
        return sdrValue;
    }

    /**
     * 字典值value
     * @param sdrValue 字典值value
     */
    public void setSdrValue(String sdrValue) {
        this.sdrValue = sdrValue == null ? null : sdrValue.trim();
    }

    /**
     * 父id
     * @return sdr_parent_id 父id
     */
    public Integer getSdrParentId() {
        return sdrParentId;
    }

    /**
     * 父id
     * @param sdrParentId 父id
     */
    public void setSdrParentId(Integer sdrParentId) {
        this.sdrParentId = sdrParentId;
    }

    /**
     * 层级关系
     * @return sdr_level 层级关系
     */
    public Integer getSdrLevel() {
        return sdrLevel;
    }

    /**
     * 层级关系
     * @param sdrLevel 层级关系
     */
    public void setSdrLevel(Integer sdrLevel) {
        this.sdrLevel = sdrLevel;
    }

    /**
     * 序号
     * @return sdr_order 序号
     */
    public Integer getSdrOrder() {
        return sdrOrder;
    }

    /**
     * 序号
     * @param sdrOrder 序号
     */
    public void setSdrOrder(Integer sdrOrder) {
        this.sdrOrder = sdrOrder;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", sdrId=").append(sdrId);
        sb.append(", sdrName=").append(sdrName);
        sb.append(", sdrValue=").append(sdrValue);
        sb.append(", sdrParentId=").append(sdrParentId);
        sb.append(", sdrLevel=").append(sdrLevel);
        sb.append(", sdrOrder=").append(sdrOrder);
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
        SysDataDictionary other = (SysDataDictionary) that;
        return (this.getSdrId() == null ? other.getSdrId() == null : this.getSdrId().equals(other.getSdrId()))
            && (this.getSdrName() == null ? other.getSdrName() == null : this.getSdrName().equals(other.getSdrName()))
            && (this.getSdrValue() == null ? other.getSdrValue() == null : this.getSdrValue().equals(other.getSdrValue()))
            && (this.getSdrParentId() == null ? other.getSdrParentId() == null : this.getSdrParentId().equals(other.getSdrParentId()))
            && (this.getSdrLevel() == null ? other.getSdrLevel() == null : this.getSdrLevel().equals(other.getSdrLevel()))
            && (this.getSdrOrder() == null ? other.getSdrOrder() == null : this.getSdrOrder().equals(other.getSdrOrder()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getSdrId() == null) ? 0 : getSdrId().hashCode());
        result = prime * result + ((getSdrName() == null) ? 0 : getSdrName().hashCode());
        result = prime * result + ((getSdrValue() == null) ? 0 : getSdrValue().hashCode());
        result = prime * result + ((getSdrParentId() == null) ? 0 : getSdrParentId().hashCode());
        result = prime * result + ((getSdrLevel() == null) ? 0 : getSdrLevel().hashCode());
        result = prime * result + ((getSdrOrder() == null) ? 0 : getSdrOrder().hashCode());
        return result;
    }
}