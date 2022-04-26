package com.vast.common.enums;

import lombok.Getter;

/**
 * Copyright (C), 2020-2021, c-vast
 *
 * @version 1.0.0
 * @className: ResultCode
 * @author: hechenghao1998@foxmail.com
 * @createDate: 2021/7/17 23:53
 * @description: 响应结果枚举
 */
@Getter
public enum ResultCode {
    SUCCESS(0, "请求成功"),
    FAILURE(1, "请求失败"),
    PARAM_IS_INVALID(1001, "参数无效"),
    PARAM_IS_BLANK(1002, "参数为空"),
    PARAM_TYPE_BIND_ERROR(1003, "参数类型错误"),
    PARAM_NOT_COMPLETE(1004, "参数缺失"),
    PARAM_VALIDATION_ERROR(1005,"参数未通过校验"),
    PARAM_ERROR(1006,"参数不正确"),
    USER_NOT_LOG_IN(2001, "用户未登录"),
    USER_LOGIN_ERROR(2002, "账号不存在或密码错误"),
    USER_TOKEN_EXPIRED(2003,"用户令牌过期"),
    SYSTEM_ERROR(10000, "系统异常，请稍后重试");

    private Integer code;
    private String message;

    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
