package com.vast.gateway.component;

import cn.hutool.http.HttpStatus;
import com.vast.common.constant.Constants;
import com.vast.common.enums.ResultCode;
import com.vast.common.result.Result;
import com.vast.common.util.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Slf4j
@Component
public class ResourceAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        httpServletResponse.setCharacterEncoding(Constants.UTF8);
        httpServletResponse.setContentType(Constants.APPLICATION_JSON_UTF8_VALUE);
        httpServletResponse.setStatus(HttpStatus.HTTP_OK);

        Result<Object> result=Result.failure(ResultCode.FAILURE);

        if (e!=null){
            result.setMessage(e.getMessage());
            log.error("AuthenticationException -> {}",e.getMessage(),e);
        }

        if (e instanceof InsufficientAuthenticationException) {
            result=Result.failure(ResultCode.USER_TOKEN_EXPIRED);
        }

        PrintWriter writer = httpServletResponse.getWriter();
        writer.append(JsonUtils.objectToJson(result));
    }
}
