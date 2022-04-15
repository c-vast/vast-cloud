package com.vast.websocket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients
@ComponentScan(value = "com.vast")
public class VastWebSocketApplication {
    public static void main(String[] args) {
        SpringApplication.run(VastWebSocketApplication.class,args);
    }
}