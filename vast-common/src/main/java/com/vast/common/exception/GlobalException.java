package com.vast.common.exception;

import com.vast.common.enums.ResultCode;
import lombok.Data;

/**
 * Copyright (C), 2020-2021, c-vast
 *
 * @version 1.0.0
 * @className: GlobalException
 * @author: hechenghao1998@foxmail.com
 * @createDate: 2021/7/18 1:01
 * @description: 全局异常
 */
@Data
public class GlobalException extends RuntimeException {
    private Integer code;

    public GlobalException() {
        super();
    }

    public GlobalException(ResultCode resultCode) {
        super(resultCode.getMessage());
        this.code = resultCode.getCode();
    }

    public GlobalException(ResultCode resultCode, Throwable cause) {
        super(resultCode.getMessage(), cause);
        this.code = resultCode.getCode();
    }

    public GlobalException(String message) {
        super(message);
        this.code = ResultCode.FAILURE.getCode();
    }

    public GlobalException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public GlobalException(Integer code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

}
