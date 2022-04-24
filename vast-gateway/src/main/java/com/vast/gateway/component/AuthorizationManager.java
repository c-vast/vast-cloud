package com.vast.gateway.component;

import com.netflix.zuul.context.RequestContext;
import com.vast.common.constant.Constants;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

@Component
public class AuthorizationManager implements AuthenticationManager {
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String requestURI = request.getRequestURI();
        if (request.getMethod().equalsIgnoreCase(HttpMethod.OPTIONS.name())) {
            authentication.setAuthenticated(true);
            return authentication;
        }
        String token = request.getHeader(Constants.AUTHORIZATION);
        String realToken = token.replace(Constants.JWT_TOKEN_PREFIX, "");
        if (StringUtils.isEmpty(token)){
            authentication.setAuthenticated(false);
            return authentication;
        }
        authentication.setAuthenticated(true);
        return authentication;
    }
}
