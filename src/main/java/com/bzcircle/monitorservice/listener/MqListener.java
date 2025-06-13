package com.bzcircle.monitorservice.listener;

import com.aliyun.openservices.shade.com.alibaba.fastjson.JSON;
import com.bzcircle.monitorservice.dao.TMonitorDurationMapper;
import com.bzcircle.monitorservice.dao.TMonitorExceptionMapper;
import com.bzcircle.monitorservice.model.TMonitorDuration;
import com.bzcircle.monitorservice.model.TMonitorException;
import com.bzcircle.service.common.MqTag;
import com.bzcircle.service.config.BaseListener;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

@AllArgsConstructor
@Service
@Log4j2
public class MqListener extends BaseListener {

    @Resource
    private TMonitorDurationMapper durationMapper;
    @Resource
    private TMonitorExceptionMapper exceptionMapper;

    @Override
    public boolean process(String msg, String tags) {
        log.info("【Monitor-MQ】消费者收到MQL >> tags:{} , msg:{}", tags, msg);
        if (Objects.equals(tags, MqTag.SERVICE_BASEJAR_TIME_TOO_LONG_TO_MONITOR.getCode())) {
            durationMapper.insert(JSON.parseObject(msg, TMonitorDuration.class));
        }else {
            exceptionMapper.insert(JSON.parseObject(msg, TMonitorException.class));
        }
        return true;
    }
}
