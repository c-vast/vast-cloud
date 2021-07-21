package com.vast.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Copyright (C), 2020-2021, c-vast
 *
 * @version 1.0.0
 * @className: VastEurekaApplication
 * @author: hechenghao1998@foxmail.com
 * @createDate: 2021/7/17 23:38
 * @description: VastEurekaApplication
 */
@EnableEurekaServer
@SpringBootApplication
public class VastEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(VastEurekaApplication.class, args);
    }

}
