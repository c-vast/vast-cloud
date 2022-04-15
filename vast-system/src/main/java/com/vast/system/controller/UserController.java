package com.vast.system.controller;

import com.vast.common.dto.UserDTO;
import com.vast.system.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;

@RestController
@RequestMapping("user")
@Api(tags = "API - UserController")
@ApiOperation("用户信息")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("getUserInfoByUsername")
    public UserDTO getUserInfoByUsername(@NotBlank(message = "用户名不能为空") String username){
        return userService.getUserInfoByUsername(username);
    }
}