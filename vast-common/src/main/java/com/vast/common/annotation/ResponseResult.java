package com.vast.common.annotation;

import java.lang.annotation.*;

/**
 * Copyright (C), 2020-2021, c-vast
 *
 * @version 1.0.0
 * @className: ResponseResult
 * @author: hechenghao1998@foxmail.com
 * @createDate: 2021/7/18 0:16
 * @description:
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface ResponseResult {
}
