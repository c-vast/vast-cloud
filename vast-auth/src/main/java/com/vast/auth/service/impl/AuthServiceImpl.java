package com.vast.auth.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.vast.auth.feign.UserFeign;
import com.vast.auth.service.AuthService;
import com.vast.common.component.JWTOperator;
import com.vast.common.dto.UserDTO;
import com.vast.common.exception.BusinessException;
import com.vast.common.result.Result;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserFeign userFeign;

    @Autowired
    private JWTOperator jwtOperator;

    @Override
    public UserDTO login(String username, String password) {
        Result<UserDTO> result = userFeign.getUserInfoByUsername(username);
        if (!result.isSuccess()){
            throw new BusinessException(result.getMessage());
        }
        UserDTO data = result.getData();
        if (!data.getPassword().equals(password)){
            throw new BusinessException("用户名或密码不正确");
        }
        data.setPassword(null);
        Map<String, Object> map = BeanUtil.beanToMap(data);
        String jwt = jwtOperator.generateJWT(map);
        String refreshJWT = jwtOperator.generateRefreshJWT(map);
        data.setToken(jwt);
        data.setRefreshToken(refreshJWT);
        return data;
    }

    @Override
    public String refreshToken(String token,String refreshToken) {
        Claims verifyJWT = jwtOperator.verifyJWT(refreshToken);
        if (verifyJWT==null){
            throw new BusinessException("刷新令牌过期");
        }
        Claims claims = jwtOperator.getClaims(token);
        String jwt = jwtOperator.generateJWT(claims);
        return jwt;
    }
}
