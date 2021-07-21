package com.vast.common.config;

import com.vast.common.interceptor.ResponseResultInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Copyright (C), 2020-2021, c-vast
 *
 * @version 1.0.0
 * @className: WebConfiguration
 * @author: hechenghao1998@foxmail.com
 * @createDate: 2021/7/18 18:13
 * @description:
 */
@Configuration
public class WebConfiguration implements WebMvcConfigurer {
    private final ResponseResultInterceptor responseResultInterceptor;

    public WebConfiguration(ResponseResultInterceptor responseResultInterceptor) {
        this.responseResultInterceptor = responseResultInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(responseResultInterceptor);
    }
}
