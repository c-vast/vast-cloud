package com.vast.common.mq.activemq.producer;

import com.vast.common.mq.MQProducerIF;
import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.command.ActiveMQObjectMessage;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Destination;

@Slf4j
@Component
public class EventMessageProducer implements MQProducerIF {
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Override
    public void pushMessage(String destinationName, boolean queue, String message) {
       try {
           Destination destination;
           if (queue) {
               destination=new ActiveMQQueue(destinationName);
           } else {
               destination=new ActiveMQTopic(destinationName);
           }
           ActiveMQObjectMessage objectMessage = new ActiveMQObjectMessage();
           objectMessage.setJMSDestination(destination);
           objectMessage.setObject(message);
           jmsMessagingTemplate.convertAndSend(destination, objectMessage);
       }catch (Exception e){
           log.error("消息发送失败",e);
       }
    }
}
