package com.vast.common.mq.activemq.consumer;

import com.vast.common.mq.MQConsumerIF;
import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.command.ActiveMQObjectMessage;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.Message;

@Slf4j
@Component
public class EventMessageConsumer {

    @Autowired
    private MQConsumerIF mqConsumerIF;

    @JmsListener(destination = "${mq.message.queue}", concurrency = "100-1000", containerFactory = "connectionFactory")
    public void receivedQueue(Message message) {
        onMessage(message);
    }

    @JmsListener(destination = "${mq.message.topic}", concurrency = "100-1000", containerFactory = "connectionFactory")
    public void receivedTopic(Message message) {
        onMessage(message);
    }

    public void onMessage(Message message) {
        try {
            String messageText;
            if (message instanceof ActiveMQTextMessage){
                ActiveMQTextMessage activeMQTextMessage=(ActiveMQTextMessage) message;
                messageText = activeMQTextMessage.getText();
            }else {
                ActiveMQObjectMessage activeMQObjectMessage = (ActiveMQObjectMessage) message;
                messageText = activeMQObjectMessage.getObject().toString();
            }
            mqConsumerIF.onReceivedMessage(messageText);
        } catch (Exception e) {
            log.error("消息监听器监听到消息，发生异常：{}", e.getMessage(),e);
        }
    }
}
