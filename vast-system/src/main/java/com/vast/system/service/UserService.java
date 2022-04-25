package com.vast.system.service;

import com.vast.common.dto.UserInfoDTO;
import com.vast.system.entity.SysUserInfoDO;

public interface UserService {
    UserInfoDTO getUserInfoByUsername(String username);
    boolean saveUserInfo(SysUserInfoDO sysUserInfoDO);
}
