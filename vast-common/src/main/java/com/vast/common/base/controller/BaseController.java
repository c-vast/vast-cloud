package com.vast.common.base.controller;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import javax.validation.ValidationException;

/**
 * Copyright (C), 2020-2021, c-vast
 *
 * @version 1.0.0
 * @className: BaseController
 * @author: hechenghao1998@foxmail.com
 * @createDate: 2021/7/18 18:23
 * @description:
 */
public abstract class BaseController {
    protected void validParam(BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            for (ObjectError error : bindingResult.getAllErrors()) {
                throw new ValidationException(error.getDefaultMessage());
            }
        }
    }
}
