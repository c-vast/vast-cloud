package com.vast.system.controller;

import com.common.pojo.vo.ResultVO;
import com.common.wrapper.ResultVOWrapper;
import com.vast.model.dto.UserDTO;
import com.vast.model.entity.system.UserDO;
import com.vast.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Copyright (C), 2020-2021, c-vast
 *
 * @version 1.0.0
 * @className: UserController
 * @author: hechenghao1998@foxmail.com
 * @createDate: 2021/4/10 2:00
 * @description: 用户服务控制器
 */
@RestController
@RequestMapping("user")
@Slf4j
public class UserController {
    @Autowired
    private IUserService userService;

    @PostMapping("saveOrUpdate")
    public ResultVO saveOrUpdate(@RequestBody UserDTO userDTO){
        UserDO userDO = userService.dtoToDo(userDTO);
        userService.check(userDO);
        boolean save = userService.saveOrUpdate(userDO);
        if (save)
            return ResultVOWrapper.success();
        return ResultVOWrapper.fail("操作失败");
    }

    @PostMapping("delete/{id}")
    public ResultVO delete(@PathVariable("id") Long id){
        boolean b = userService.removeById(id);
        return ResultVOWrapper.success();
    }
}
