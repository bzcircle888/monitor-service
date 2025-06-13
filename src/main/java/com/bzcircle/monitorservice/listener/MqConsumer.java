package com.bzcircle.monitorservice.listener;

import com.bzcircle.service.common.MqTag;
import com.bzcircle.service.common.MqTopic;
import com.bzcircle.service.config.BaseConsumer;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Component
public class MqConsumer extends BaseConsumer {

    @Resource
    private MqListener mqListener;

    @Override
    @PostConstruct
    public void pushConsumer() {
        log.info("MqConsumer init");
        super.pushConsumer();
    }

    @Override
    public List<ConsumerBean> registerConsumer() {
        List<ConsumerBean> list = Lists.newArrayList();

        ConsumerBean consumerBean = new ConsumerBean();
        consumerBean.setTopic(MqTopic.COMMON.getCode());
        consumerBean.setTag(MqTag.SERVICE_BASEJAR_BUSINESSEXCEPTION_TO_MONITOR.getCode() + "||" + MqTag.SERVICE_BASEJAR_TIME_TOO_LONG_TO_MONITOR.getCode());
        consumerBean.setListener(mqListener);
        list.add(consumerBean);

        return list;
    }
}
