package com.vast.common.exception;

import com.vast.common.enums.ResultCode;

/**
 * Copyright (C), 2020-2021, c-vast
 *
 * @version 1.0.0
 * @className: BusinessException
 * @author: hechenghao1998@foxmail.com
 * @createDate: 2021/7/18 1:30
 * @description: 业务异常
 */
public class BusinessException extends GlobalException{
    public BusinessException(ResultCode resultCode) {
        super(resultCode);
    }

    public BusinessException(ResultCode resultCode, Throwable cause) {
        super(resultCode, cause);
    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(Integer code, String message) {
        super(code,message);
    }

    public BusinessException(Integer code, String message, Throwable cause) {
        super(code,message, cause);
    }
}
