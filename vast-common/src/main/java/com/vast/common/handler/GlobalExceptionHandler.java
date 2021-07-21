package com.vast.common.handler;

import com.vast.common.enums.ResultCode;
import com.vast.common.exception.BusinessException;
import com.vast.common.exception.GlobalException;
import com.vast.common.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ValidationException;

/**
 * Copyright (C), 2020-2021, c-vast
 *
 * @version 1.0.0
 * @className: GlobalExceptionHandler
 * @author: hechenghao1998@foxmail.com
 * @createDate: 2021/7/18 1:08
 * @description: 全局异常处理
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(GlobalException.class)
    public Result<Object> globalExceptionHandler(GlobalException e, HttpServletRequest request) {
        log.error("发生异常：{} -> {}", e.getCode(), e.getMessage(),e);
        return Result.failure(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(BusinessException.class)
    public Result<Object> businessExceptionExceptionHandler(BusinessException e, HttpServletRequest request) {
        log.error("发生业务异常：{} -> {}", e.getCode(), e.getMessage(),e);
        return Result.failure(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(Throwable.class)
    public Result<Object> handlerThrowable(Throwable e, HttpServletRequest request) {
        log.error("发生未知异常：{}",e.getMessage(), e);
        return Result.failure(ResultCode.SYSTEM_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public Result<Object> handlerException(Exception e, HttpServletRequest request) {
        log.error("发生异常：{}",e.getMessage(), e);
        return Result.failure(ResultCode.SYSTEM_ERROR);
    }

    @ExceptionHandler(ValidationException.class)
    public Result<Object> handlerValidationException(ValidationException e, HttpServletRequest request) {
        log.error("发生参数校验未通过异常：{}",e.getMessage(), e);
        return Result.failure(ResultCode.PARAM_VALIDATION_ERROR,e.getMessage());
    }

    @ExceptionHandler(BindException.class)
    public Result<Object> handleBindExcpetion(BindException e, HttpServletRequest request) {
        log.error("发生参数绑定异常：{}",e.getMessage(), e);
        return Result.failure(ResultCode.PARAM_TYPE_BIND_ERROR,e.getAllErrors().get(0).getDefaultMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException e, HttpServletRequest request) {
        log.error("请求接口MethodArgumentNotValidException异常：{}",e.getMessage(),e);
        return Result.failure(ResultCode.PARAM_IS_INVALID,e.getBindingResult().getAllErrors().get(0).getDefaultMessage());
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public Result<Object> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e, HttpServletRequest request) {
        log.error("请求接口MethodArgumentTypeMismatchException异常：{}",e.getMessage(),e);
        return Result.failure(ResultCode.PARAM_TYPE_BIND_ERROR);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public Result<Object> handleHttpMessageNotReadableException(HttpMessageNotReadableException e, HttpServletRequest request) {
        log.error("请求接口HttpMessageNotReadableExceptio异常：{}",e.getMessage(),e);
        return Result.failure(ResultCode.FAILURE);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public Result<Object> handleMissingServletRequestParameterException(MissingServletRequestParameterException e, HttpServletRequest request) {
        log.error("请求接口MissingServletRequestParameterException异常：{}",e.getMessage(),e);
        return Result.failure(ResultCode.PARAM_NOT_COMPLETE);
    }
}
