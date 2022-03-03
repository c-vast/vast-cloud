package com.vast.auth.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
@Api(tags = "API - AuthController")
@ApiOperation("鉴权、授权、登录")
public class AuthController {

}
