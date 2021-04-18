package com.vast.dao.mapper.system;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.vast.model.entity.system.UserDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * Copyright (C), 2020-2021, c-vast
 *
 * @version 1.0.0
 * @className: IUserMapper
 * @author: hechenghao1998@foxmail.com
 * @createDate: 2021/4/10 1:55
 * @description: 用户数据操作
 */
@Mapper
public interface IUserMapper extends BaseMapper<UserDO> {
}
