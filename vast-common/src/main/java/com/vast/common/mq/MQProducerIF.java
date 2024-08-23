package com.vast.common.mq;

public interface MQProducerIF {
    void pushMessage(String destinationName,boolean queue,String message);
}
