package com.vast.common.event.publisher;

import com.vast.common.event.MessageEvent;
import com.vast.common.event.constant.EventTypeConstant;
import com.vast.common.event.domain.MessageModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MessagePublisher {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;
    public void sendMessage(String message) {
        log.info("发送消息：{}", message);
        MessageModel messageModel = new MessageModel();
        messageModel.setMessage(message);
        messageModel.setPush(true);
        messageModel.setDestinationName("message.topic");
        messageModel.setQueue(false);
        applicationEventPublisher.publishEvent(new MessageEvent(this, EventTypeConstant.MESSAGE, messageModel));
    }
}
