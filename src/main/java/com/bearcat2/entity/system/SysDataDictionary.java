package com.bearcat2.entity.system;

import com.bearcat2.entity.common.CommonEntity;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Accessors(chain = true)
@Table(name = "sys_data_dictionary")
public class SysDataDictionary extends CommonEntity {
    /**
     * 主键id,自增
     */
    @Id
    @Column(name = "sdr_id")
    private Integer sdrId;

    /**
     * 字典名
     */
    @Column(name = "sdr_name")
    private String sdrName;

    /**
     * 字典值value
     */
    @Column(name = "sdr_value")
    private String sdrValue;

    /**
     * 父id
     */
    @Column(name = "sdr_parent_id")
    private Integer sdrParentId;

    /**
     * 层级关系
     */
    @Column(name = "sdr_level")
    private Integer sdrLevel;

    /**
     * 序号
     */
    @Column(name = "sdr_order")
    private Integer sdrOrder;

    public static final String SDR_ID = "sdrId";

    public static final String DB_SDR_ID = "sdr_id";

    public static final String SDR_NAME = "sdrName";

    public static final String DB_SDR_NAME = "sdr_name";

    public static final String SDR_VALUE = "sdrValue";

    public static final String DB_SDR_VALUE = "sdr_value";

    public static final String SDR_PARENT_ID = "sdrParentId";

    public static final String DB_SDR_PARENT_ID = "sdr_parent_id";

    public static final String SDR_LEVEL = "sdrLevel";

    public static final String DB_SDR_LEVEL = "sdr_level";

    public static final String SDR_ORDER = "sdrOrder";

    public static final String DB_SDR_ORDER = "sdr_order";
}