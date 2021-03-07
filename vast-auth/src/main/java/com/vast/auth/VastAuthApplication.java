package com.vast.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class VastAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(VastAuthApplication.class, args);
    }

}
