package com.bzcircle.monitorservice.model;

import lombok.Data;

import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "t_monitor_duration")
public class TMonitorDuration {
    /**
     * id
     */
    private Integer id;

    /**
     * 服务类型:oms/agent/msp/api
     */
    private String serviceType;

    /**
     * 接口路径
     */
    private String interfacePath;

    /**
     * 持续时间
     */
    private Integer executionTime;

    /**
     * 开始时间
     */
    private Long beginTime;

    /**
     * 结束时间
     */
    private Long endTime;

    /**
     * trance_id
     */
    private String tranceId;

    /**
     * 产生日期
     */
    private String produceTime;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 接口名称
     */
    private String interfaceName;
}
