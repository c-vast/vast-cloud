package com.vast.iot.common.server;

import io.netty.channel.Channel;
import lombok.Data;

import java.util.Date;

@Data
public class Connection {
    private String sign;
    private String name;
    private Date createTime;
    private Date onlineTime;
    private int packageNum;
    private int errorPackageNum;
    private int disconnectNum;
    private boolean connected;
    private Channel channel;
}
