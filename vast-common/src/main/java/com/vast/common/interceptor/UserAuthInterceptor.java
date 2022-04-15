package com.vast.common.interceptor;

import com.vast.common.annotation.IgnoreUserToken;
import com.vast.common.component.JWTOperator;
import com.vast.common.constant.Constants;
import com.vast.common.exception.GlobalException;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Component
public class UserAuthInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private JWTOperator jwtOperator;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod){
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            IgnoreUserToken annotation = handlerMethod.getBeanType().getAnnotation(IgnoreUserToken.class);
            if (annotation == null) {
                annotation = handlerMethod.getMethodAnnotation(IgnoreUserToken.class);
            }
            if (annotation != null) {
                return super.preHandle(request, response, handler);
            }
            String token = request.getHeader(Constants.AUTHORIZATION);
            if (StringUtils.isEmpty(token)) {
                throw new GlobalException("令牌不存在");
            }
            Claims claims = jwtOperator.verifyJWT(token);
            if (claims==null){
                throw new GlobalException("令牌过期或令牌无效");
            }
        }
        return super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }
}
