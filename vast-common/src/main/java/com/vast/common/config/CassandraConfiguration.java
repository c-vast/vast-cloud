package com.vast.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;

@Configuration
public class CassandraConfiguration extends AbstractCassandraConfiguration {

    //空间名称
    @Value("${spring.data.cassandra.keyspace-name}")
    private String keyspaceName;

    //节点IP（连接的集群节点IP）
    @Value("${spring.data.cassandra.contact-points}")
    private String contactPoints;

    //端口
    @Value("${spring.data.cassandra.port}")
    private int port;

    @Override
    protected String getKeyspaceName() {
        return keyspaceName;
    }

    @Override
    public String getContactPoints() {
        return contactPoints;
    }

    @Override
    public int getPort() {
        return port;
    }
}
