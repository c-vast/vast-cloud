package com.vast.common.event.listener;

import cn.hutool.json.JSONUtil;
import com.vast.common.event.MessageEvent;
import com.vast.common.event.domain.MessageModel;
import com.vast.common.mq.MQProducerIF;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MessageListener {

    @Autowired
    private MQProducerIF mqProducer;

    @Async
    @EventListener
    public void onApplicationEvent(MessageEvent event) {
        int type = event.getType();
        long timestamp = event.getTimestamp();
        MessageModel content = event.getContent();
        if (content.isPush()) {
            mqProducer.pushMessage(content.getDestinationName(), content.isQueue(), content.getMessage());
        }
        String jsonStr = JSONUtil.toJsonStr(content);
        log.info("消息监听器监听到消息：{}，消息类型：{}，时间戳：{}", jsonStr, type, timestamp);
    }
}
