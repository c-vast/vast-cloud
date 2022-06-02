package com.vast.common.aspect;


import com.vast.common.util.IPUtils;
import com.vast.common.util.RequestUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Slf4j
@Aspect
@Component
public class RequestLogAspect {

    @Pointcut("execution(public * com.vast.*.controller.*.*(..)) && !@annotation(com.vast.common.DisableLog))")
    public void log() {

    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        HttpServletRequest request = RequestUtils.getRequest();
        log.info("REQUEST URL : " + request.getRequestURL().toString());
        log.info("HTTP METHOD : " + request.getMethod());
        log.info("IP : " + IPUtils.getClientIp(request));
        log.info("CLASS METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "."
                + joinPoint.getSignature().getName());
        log.info("PARAMETER : " + Arrays.toString(joinPoint.getArgs()));
    }

    @Around("log()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object ob = proceedingJoinPoint.proceed();
        long endTime = System.currentTimeMillis();
        log.info("TIME CONSUMING : " + (endTime - startTime));
        return ob;
    }

    @AfterReturning(pointcut = "log()", returning = "object")
    public void doAfterReturning(Object object) {
        log.info("response={}", object.toString());
    }
}
