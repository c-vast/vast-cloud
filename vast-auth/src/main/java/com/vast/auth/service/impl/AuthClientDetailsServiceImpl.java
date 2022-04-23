package com.vast.auth.service.impl;

import com.vast.auth.service.AuthClientDetailsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Service;

/**
 * Copyright (C), 2020-2022, c-vast
 *
 * @version 1.0.0
 * @className: AuthClientDetailsServiceImpl
 * @author: hechenghao1998@foxmail.com
 * @createDate: 2022/4/23 15:12
 * @description:
 */
@Slf4j
@Service
public class AuthClientDetailsServiceImpl implements AuthClientDetailsService {
    @Override
    public ClientDetails loadClientByClientId(String s) throws ClientRegistrationException {
        return null;
    }
}
