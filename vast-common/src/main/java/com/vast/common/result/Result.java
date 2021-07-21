package com.vast.common.result;

import com.vast.common.enums.ResultCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Copyright (C), 2020-2021, c-vast
 *
 * @version 1.0.0
 * @className: Result
 * @author: hechenghao1998@foxmail.com
 * @createDate: 2021/7/17 23:51
 * @description: 响应结果
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "响应结果", description = "响应结果")
public class Result<T> implements Serializable {
    @ApiModelProperty(value = "响应码")
    private Integer code;
    @ApiModelProperty(value = "响应消息")
    private String message;
    @ApiModelProperty(value = "响应数据")
    private T data;

    public Result(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Result(ResultCode resultCode) {
        this(resultCode.getCode(),resultCode.getMessage());
    }

    public Result(ResultCode resultCode, T data) {
        this(resultCode);
        this.data = data;
    }

    public boolean isSuccess() {
        return ResultCode.SUCCESS.getCode().equals(this.code);
    }

    public static Result<Object> success() {
        return new Result<>(ResultCode.SUCCESS);
    }

    public static <T> Result<T> success(T data) {
        return new Result<>(ResultCode.SUCCESS, data);
    }

    public static Result<Object> failure(ResultCode resultCode) {
        return new Result<>(resultCode);
    }

    public static Result<Object> failure(Integer code, String message) {
        return new Result<>(code, message);
    }

    public static <T> Result<T> failure(ResultCode resultCode, T data) {
        return new Result<>(resultCode, data);
    }
    public static Result<Object> failure(ResultCode resultCode, String message) {
        return new Result<>(resultCode.getCode(),message);
    }
}
