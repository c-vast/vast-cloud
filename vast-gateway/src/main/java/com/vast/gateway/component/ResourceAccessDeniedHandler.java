package com.vast.gateway.component;

import com.vast.common.constant.Constants;
import com.vast.common.enums.ResultCode;
import com.vast.common.result.Result;
import com.vast.common.util.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Slf4j
@Component
public class ResourceAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
        httpServletResponse.setCharacterEncoding(Constants.UTF8);
        httpServletResponse.setContentType(Constants.APPLICATION_JSON_UTF8_VALUE);
        httpServletResponse.setStatus(HttpStatus.OK.value());

        Result<Object> result=Result.failure(ResultCode.FAILURE);

        if (e!=null){
            result.setMessage(e.getMessage());
            log.error("AccessDeniedException -> {}",e.getMessage(),e);
        }

        PrintWriter writer = httpServletResponse.getWriter();
        writer.append(JsonUtils.objectToJson(result));
    }
}
