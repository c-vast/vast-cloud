package com.vast.auth.controller;

import com.vast.auth.service.AuthService;
import com.vast.common.dto.UserDTO;
import com.vast.common.vo.UserVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
@Api(tags = "API - AuthController")
@ApiOperation("鉴权、授权、登录")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("login")
    public UserDTO login(@RequestBody UserVO vo){
        return authService.login(vo.getUsername(),vo.getPassword());
    }

    @PostMapping("refreshToken")
    public String refreshToken(String token,String refreshToken){
        return authService.refreshToken(token,refreshToken);
    }
}
