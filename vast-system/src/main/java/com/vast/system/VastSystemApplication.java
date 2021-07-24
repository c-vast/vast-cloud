package com.vast.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * Copyright (C), 2020-2021, c-vast
 *
 * @version 1.0.0
 * @className: VastSystemApplication
 * @author: hechenghao1998@foxmail.com
 * @createDate: 2021/7/25 1:34
 * @description:
 */
@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients
@ComponentScan(value = "com.vast.*")
public class VastSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(VastSystemApplication.class,args);
    }
}
