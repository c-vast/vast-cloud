package com.vast.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.vast.model.dto.UserDTO;
import com.vast.model.entity.system.UserDO;

/**
 * Copyright (C), 2020-2021, c-vast
 *
 * @version 1.0.0
 * @className: IUserService
 * @author: hechenghao1998@foxmail.com
 * @createDate: 2021/4/10 1:56
 * @description: 用户服务
 */
public interface IUserService extends IService<UserDO> {
    //@TODO 以下方法可以提取公共方法

    void check(UserDO userDO);

    UserDO dtoToDo(UserDTO userDTO);
}
