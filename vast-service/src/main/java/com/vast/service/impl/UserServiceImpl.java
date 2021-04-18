package com.vast.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.common.exception.ServiceException;
import com.vast.dao.mapper.system.IUserMapper;
import com.vast.model.dto.UserDTO;
import com.vast.model.entity.system.UserDO;
import com.vast.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * Copyright (C), 2020-2021, c-vast
 *
 * @version 1.0.0
 * @className: UserServiceImpl
 * @author: hechenghao1998@foxmail.com
 * @createDate: 2021/4/10 1:57
 * @description: 用户服务实现
 */
@Service
public class UserServiceImpl extends ServiceImpl<IUserMapper,UserDO> implements IUserService {


    @Override
    public void check(UserDO userDO) {
        QueryWrapper<UserDO> queryWrapper = new QueryWrapper<>();

        queryWrapper.eq("account", userDO.getAccount());
        if (userDO.getId() != null && userDO.getId() > 0) {
            queryWrapper.ne("id", userDO.getId());
        }
        Integer count = baseMapper.selectCount(queryWrapper);
        if (count > 0) {
            throw new ServiceException("账号重复");
        }
    }

    @Override
    public UserDO dtoToDo(UserDTO userDTO) {
        UserDO userDO = new UserDO();
        BeanUtils.copyProperties(userDTO, userDO);
        return userDO;
    }
}
