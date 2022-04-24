package com.vast.auth.service.impl;

import com.vast.auth.dto.AuthUserDetailsDTO;
import com.vast.auth.feign.UserFeign;
import com.vast.auth.service.AuthUserDetailsService;
import com.vast.common.dto.UserDTO;
import com.vast.common.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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
    private UserFeign userFeign;

    private static final List<AuthUserDetailsDTO> AUTH_USER_DETAILS_DTO_LIST=new ArrayList<>();
    static {
        UserDTO userDTO=new UserDTO();
        userDTO.setUsername("admin");
        userDTO.setPassword(new BCryptPasswordEncoder().encode("123456"));
        userDTO.setEnable(1);
        userDTO.setNickname("admin");
        AuthUserDetailsDTO detailsDTO=new AuthUserDetailsDTO(userDTO, AuthorityUtils.createAuthorityList("ROLE_ADMIN"));
        AUTH_USER_DETAILS_DTO_LIST.add(detailsDTO);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        List<AuthUserDetailsDTO> collect = AUTH_USER_DETAILS_DTO_LIST.stream()
                .filter(p -> s.equals(p.getUsername())).limit(1)
                .collect(Collectors.toList());
        if (Objects.isNull(collect.get(0))){
            throw new UsernameNotFoundException("用户不存在");
        }
        return collect.get(0);
    }
}
