package com.vast.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.vast.common.dto.UserDTO;
import com.vast.common.exception.BusinessException;
import com.vast.common.util.Utils;
import com.vast.system.entity.SysUserInfo;
import com.vast.system.mapper.SysUserInfoMapper;
import com.vast.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private SysUserInfoMapper sysUserInfoMapper;

    @Override
    public UserDTO getUserInfoByUsername(String username) {
        LambdaQueryWrapper<SysUserInfo> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(SysUserInfo::getUsername, username);
        SysUserInfo sysUserInfo = sysUserInfoMapper.selectOne(lambdaQueryWrapper);
        if (sysUserInfo == null) {
            throw new BusinessException("用户不存在");
        }
        UserDTO userDTO = Utils.BeanConverter(UserDTO.class, sysUserInfo);
        return userDTO;
    }

    @Override
    public UserDTO getUserInfoByUsernameAndPassword(String username, String password) {
        LambdaQueryWrapper<SysUserInfo> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(SysUserInfo::getUsername, username).eq(SysUserInfo::getPassword, password);
        SysUserInfo sysUserInfo = sysUserInfoMapper.selectOne(lambdaQueryWrapper);
        if (sysUserInfo == null) {
            throw new BusinessException("用户不存在或密码错误");
        }
        UserDTO userDTO = Utils.BeanConverter(UserDTO.class, sysUserInfo);
        return userDTO;
    }
}
