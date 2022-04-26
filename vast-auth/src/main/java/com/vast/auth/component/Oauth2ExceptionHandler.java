package com.vast.auth.component;

import com.vast.common.enums.ResultCode;
import com.vast.common.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class Oauth2ExceptionHandler {
    @ExceptionHandler(value = OAuth2Exception.class)
    public Result<Object> handleOAuth2Exception(OAuth2Exception e) {
        log.error("请求接口OAuth2Exception异常：{}",e.getMessage(),e);
        return Result.failure(ResultCode.USER_LOGIN_ERROR);
    }
}
