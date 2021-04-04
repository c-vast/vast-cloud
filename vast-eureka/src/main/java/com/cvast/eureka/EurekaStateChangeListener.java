package com.cvast.eureka;

import com.netflix.appinfo.InstanceInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.eureka.server.event.*;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * Copyright (C), 2020-2021, c-vast
 *
 * @className: EurekaStateChangeListener
 * @author: hechenghao1998@foxmail.com
 * @date: 2021/3/7 18:44
 * @description: Eureka事件监听
 * @version 1.0.0
 */
@Component
@Slf4j
public class EurekaStateChangeListener {
    @EventListener
    public void listen(EurekaInstanceCanceledEvent event) {
        log.info(event.getServerId() + "\t" + event.getAppName() + " 服务下线");
    }

    @EventListener
    public void listen(EurekaInstanceRegisteredEvent event) {
        InstanceInfo instanceInfo = event.getInstanceInfo();
        log.info(instanceInfo.getAppName() + "进行注册");
    }

    @EventListener
    public void listen(EurekaInstanceRenewedEvent event) {
        log.info(event.getServerId() + "\t" + event.getAppName() + " 服务进行续约");
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
