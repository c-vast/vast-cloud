package com.vast.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vast.system.entity.User;
import com.vast.system.mapper.UserMapper;
import com.vast.system.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Copyright (C), 2020-2021, c-vast
 *
 * @version 1.0.0
 * @className: UserServiceImpl
 * @author: hechenghao1998@foxmail.com
 * @createDate: 2021/7/25 1:56
 * @description:
 */
@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
