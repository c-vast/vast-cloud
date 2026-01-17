package com.vast.gateway;

import com.vast.common.event.listener.MessageListener;
import com.vast.common.mq.activemq.consumer.EventMessageConsumer;
import com.vast.common.mq.activemq.producer.EventMessageProducer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Copyright (C), 2020-2021, c-vast
 *
 * @version 1.0.0
 * @className: VastGatewayApplication
 * @author: hechenghao1998@foxmail.com
 * @createDate: 2021/7/21 22:25
 * @description:
 */

@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
@EnableFeignClients
@EnableSwagger2
@ComponentScan(basePackages = "com.vast",
        excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,
        classes = {EventMessageConsumer.class,
                EventMessageProducer.class,
        MessageListener.class}))
@EnableResourceServer
public class VastGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(VastGatewayApplication.class, args);
    }
}
