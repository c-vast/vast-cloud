package com.vast.auth.service.impl;

import com.vast.auth.dto.AuthUserDetailsDTO;
import com.vast.auth.feign.SystemFeign;
import com.vast.auth.service.AuthUserDetailsService;
import com.vast.common.dto.UserInfoDTO;
import com.vast.common.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Copyright (C), 2020-2022, c-vast
 *
 * @version 1.0.0
 * @className: AuthUserDetailsService
 * @author: hechenghao1998@foxmail.com
 * @createDate: 2022/4/23 14:37
 * @description:
 */
@Slf4j
@Service
public class AuthUserDetailsServiceImpl implements AuthUserDetailsService {

    @Autowired
    private SystemFeign systemFeign;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Result<UserInfoDTO> result = systemFeign.getUserInfoByUsername(s);
        if (result==null||!result.isSuccess()){
            throw new UsernameNotFoundException("用户不存在");
        }
        UserInfoDTO userInfoDTO = result.getData();
        userInfoDTO.setPassword(passwordEncoder.encode(userInfoDTO.getPassword()));
        return new AuthUserDetailsDTO(userInfoDTO);
    }
}
