package com.vast.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.vast.common.component.JWTOperator;
import com.vast.common.constant.Constants;
import com.vast.common.exception.GlobalException;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

@Component
public class AuthFilter extends ZuulFilter {

    @Autowired
    private JWTOperator jwtOperator;

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return false;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String authToken = request.getHeader(Constants.AUTHORIZATION);
        if (StringUtils.isEmpty(authToken)){
            throw new GlobalException("令牌不存在");
        }
        Claims claims = jwtOperator.verifyJWT(authToken);
        if (claims==null){
            throw new GlobalException("令牌过期或令牌无效");
        }
        return null;
    }
}
