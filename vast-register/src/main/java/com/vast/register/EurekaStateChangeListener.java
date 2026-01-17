package com.vast.register;

import com.netflix.appinfo.InstanceInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.eureka.server.event.*;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * Copyright (C), 2020-2021, c-vast
 *
 * @version 1.0.0
 * @className: EurekaStateChangeListener
 * @author: hechenghao1998@foxmail.com
 * @createDate: 2021/7/17 23:38
 * @description: EurekaStateChangeListener
 */
@Component
@Slf4j
public class EurekaStateChangeListener {
    @EventListener
    public void listen(EurekaInstanceCanceledEvent event) {
        log.info("{}\t{} 服务下线", event.getServerId(), event.getAppName());
    }

    @EventListener
    public void listen(EurekaInstanceRegisteredEvent event) {
        InstanceInfo instanceInfo = event.getInstanceInfo();
        log.info("{}进行注册", instanceInfo.getAppName());
    }

    @EventListener
    public void listen(EurekaInstanceRenewedEvent event) {
        log.info("{}\t{} 服务进行续约", event.getServerId(), event.getAppName());
    }

    @EventListener
    public void listen(EurekaRegistryAvailableEvent event) {
        log.info("注册中心 启动");
    }

    @EventListener
    public void listen(EurekaServerStartedEvent event) {
        log.info("Eureka Server 启动");
    }
}
