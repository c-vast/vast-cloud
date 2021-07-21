package com.vast.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;

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
public class VastGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(VastGatewayApplication.class, args);
    }
}
