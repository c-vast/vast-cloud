package com.vast.system.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.vast.common.dto.UserInfoDTO;
import com.vast.common.exception.BusinessException;
import com.vast.common.util.IdUtils;
import com.vast.common.util.Utils;
import com.vast.system.entity.SysUserInfoDO;
import com.vast.system.mapper.SysUserInfoMapper;
import com.vast.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@DS("master")
public class UserServiceImpl implements UserService {

    @Autowired
    private SysUserInfoMapper sysUserInfoMapper;

    @Override
    public UserInfoDTO getUserInfoByUsername(String username) {
        LambdaQueryWrapper<SysUserInfoDO> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(SysUserInfoDO::getUsername, username);
        SysUserInfoDO sysUserInfoDO = sysUserInfoMapper.selectOne(lambdaQueryWrapper);
        if (sysUserInfoDO == null) {
            throw new BusinessException("用户不存在");
        }
        UserInfoDTO userInfoDTO = Utils.BeanConverter(UserInfoDTO.class, sysUserInfoDO);
        userInfoDTO.setRoleSign("ROLE_ADMIN");
        return userInfoDTO;
    }

    @Override
    public boolean saveUserInfo(UserInfoDTO userInfoDTO) {
        SysUserInfoDO sysUserInfoDO = Utils.BeanConverter(SysUserInfoDO.class, userInfoDTO);
        long snowflakeId = IdUtils.getSnowflakeId();
        sysUserInfoDO.setId(snowflakeId);
        return sysUserInfoMapper.insert(sysUserInfoDO)>0;
    }
}
