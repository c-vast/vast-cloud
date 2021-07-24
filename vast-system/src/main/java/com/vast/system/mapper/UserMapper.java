package com.vast.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.vast.system.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * Copyright (C), 2020-2021, c-vast
 *
 * @version 1.0.0
 * @className: UserMapper
 * @author: hechenghao1998@foxmail.com
 * @createDate: 2021/7/25 1:23
 * @description:
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
