package com.vast.common.mq;

public interface MQConsumerIF {
    void onReceivedMessage(Object message);
}
