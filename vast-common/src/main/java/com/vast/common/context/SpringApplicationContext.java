package com.vast.common.context;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Copyright (C), 2020-2021, c-vast
 *
 * @version 1.0.0
 * @className: SpringApplicationContext
 * @author: hechenghao1998@foxmail.com
 * @createDate: 2021/7/18 16:53
 * @description:
 */
@Component
@Slf4j
public class SpringApplicationContext implements ApplicationContextAware {
    @Getter
    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(@NotNull ApplicationContext context) throws BeansException {
        log.info("ApplicationContext registered-->{}", context);
        applicationContext=context;
    }

    public static <T> T getBean(Class<T> type) {
        return applicationContext.getBean(type);
    }
    public static <T> T getBean(String name, Class<T> type) {
        return applicationContext.getBean(name, type);
    }
}
