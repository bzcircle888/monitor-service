package com.bzcircle.monitorservice.model;

import lombok.Data;

import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "t_monitor_exception")
public class TMonitorException {

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
     * 异常类型
     */
    private String exceptionType;

    /**
     * 异常code
     */
    private String exceptionCode;

    /**
     * 异常message
     */
    private String exceptionMessage;

    /**
     * 线程id
     */
    private String threadId;

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
}
