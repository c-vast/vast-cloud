package com.vast.auth.service.impl;

import com.vast.auth.dto.AuthClientDetailsDTO;
import com.vast.auth.feign.SystemFeign;
import com.vast.auth.service.AuthClientDetailsService;
import com.vast.common.dto.ClientInfoDTO;
import com.vast.common.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private SystemFeign systemFeign;

    @Override
    public ClientDetails loadClientByClientId(String s) throws ClientRegistrationException {
        Result<ClientInfoDTO> result = systemFeign.getClientByClientId(s);
        if (result==null||!result.isSuccess()){
            throw new ClientRegistrationException("客户端不存在");
        }
        ClientInfoDTO clientInfoDTO=result.getData();
        return new AuthClientDetailsDTO(clientInfoDTO);
    }
}
