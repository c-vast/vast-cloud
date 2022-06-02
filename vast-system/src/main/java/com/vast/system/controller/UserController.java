package com.vast.system.controller;

import com.vast.common.annotation.ResponseResult;
import com.vast.common.dto.UserInfoDTO;
import com.vast.system.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;

@RestController
@RequestMapping("user")
@Api(tags = "API - UserController")
@ApiOperation("用户信息")
@ResponseResult
@Validated
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation("根据用户名获取用户信息")
    @GetMapping("getUserInfoByUsername")
    public UserInfoDTO getUserInfoByUsername(@ApiParam("用户名") @NotBlank(message = "用户名不能为空") String username){
        return userService.getUserInfoByUsername(username);
    }
}
