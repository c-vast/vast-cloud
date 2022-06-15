package com.vast.iot.common.server;

import io.netty.channel.Channel;
import io.netty.util.internal.StringUtil;

import java.util.Collection;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConnectionManager {
    private final Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public Connection getConnection(String key) {
        if (connectionMap.containsKey(key)){
            return connectionMap.get(key);
        }
        Connection connection=new Connection();
        connection.setSign(key);
        connection.setName(key);
        connection.setConnected(true);
        connection.setCreateTime(new Date());
        connection.setOnlineTime(new Date());
        connectionMap.put(key,connection);
        return connection;
    }

    public void closeConnection(String key) {
        if (connectionMap.containsKey(key)) {
            Connection connection = connectionMap.get(key);
            if (connection != null) {
                connection.setConnected(false);
                connection.setOnlineTime(new Date());
                connection.setDisconnectNum(connection.getDisconnectNum() + 1);
                Channel channel = connection.getChannel();
                if (channel != null) {
                    channel.close();
                    connection.setChannel(null);
                }
            }
        }
    }

    public Collection<Connection> listConnection() {
        return connectionMap.values();
    }
}
