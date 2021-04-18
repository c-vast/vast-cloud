package com.vast.system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
@ComponentScan(basePackages = {"com.vast.*"})
@MapperScan({"com.vast.dao.*"})
public class VastSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(VastSystemApplication.class, args);
    }

}
