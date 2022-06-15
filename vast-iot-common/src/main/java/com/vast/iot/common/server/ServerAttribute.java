package com.vast.iot.common.server;

import io.netty.channel.ChannelInitializer;
import lombok.Data;

@Data
public class ServerAttribute {
    private int port;
    private ChannelInitializer channelInitializer;
}
