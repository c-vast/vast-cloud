package com.vast.auth.dto;

import com.vast.common.dto.UserInfoDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * Copyright (C), 2020-2022, c-vast
 *
 * @version 1.0.0
 * @className: AuthUserDetailsDto
 * @author: hechenghao1998@foxmail.com
 * @createDate: 2022/4/23 14:44
 * @description:
 */
@Data
@AllArgsConstructor
public class AuthUserDetailsDTO implements UserDetails {

    private UserInfoDTO userInfoDTO;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return AuthorityUtils.createAuthorityList(userInfoDTO.getRoleSign());
    }

    @Override
    public String getPassword() {
        return userInfoDTO.getPassword();
    }

    @Override
    public String getUsername() {
        return userInfoDTO.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return userInfoDTO.getEnable()>0;
    }
}
