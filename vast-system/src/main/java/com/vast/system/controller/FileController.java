package com.vast.system.controller;

import com.vast.common.annotation.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("file")
@Api(tags = "API - FileController")
@ApiOperation("文件操作")
@ResponseResult
public class FileController {
}
