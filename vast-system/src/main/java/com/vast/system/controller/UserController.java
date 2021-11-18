package com.vast.system.controller;

import com.vast.common.annotation.ResponseResult;
import com.vast.common.annotation.valid.InsertValid;
import com.vast.common.base.controller.BaseController;
import com.vast.common.dto.UserDto;
import com.vast.common.util.AESUtils;
import com.vast.common.util.IdUtils;
import com.vast.system.entity.User;
import com.vast.system.service.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Copyright (C), 2020-2021, c-vast
 *
 * @version 1.0.0
 * @className: UserController
 * @author: hechenghao1998@foxmail.com
 * @createDate: 2021/7/25 2:00
 * @description:
 */
@RestController
@RequestMapping("user")
@Slf4j
@ApiOperation("用户")
public class UserController extends BaseController {
    @Autowired
    private UserService userService;

    @PostMapping("insert")
    @ResponseResult
    @ApiOperation("插入用户")
    private boolean insert(@Validated(InsertValid.class)@RequestBody UserDto dto){
        User user=new User();
        BeanUtils.copyProperties(dto,user);
        user.setId(IdUtils.getSnowflakeId());
        user.setLoginPassword(AESUtils.encrypt(user.getLoginPassword(),""));
        return userService.save(user);
    }
}
