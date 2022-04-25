package com.vast.auth.dto;

import com.vast.common.dto.ClientInfoDTO;
import com.vast.common.util.JsonUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.util.StringUtils;

import java.util.*;

/**
 * Copyright (C), 2020-2022, c-vast
 *
 * @version 1.0.0
 * @className: AuthClientDetailsDTO
 * @author: hechenghao1998@foxmail.com
 * @createDate: 2022/4/23 15:13
 * @description:
 */
@Data
@AllArgsConstructor
public class AuthClientDetailsDTO implements ClientDetails {

    private ClientInfoDTO clientInfoDTO;

    @Override
    public String getClientId() {
        return clientInfoDTO.getClientId();
    }

    @Override
    public Set<String> getResourceIds() {
        return new HashSet<>(Arrays.asList(clientInfoDTO.getResourceIds().split(",")));
    }

    @Override
    public boolean isSecretRequired() {
        return !StringUtils.isEmpty(clientInfoDTO.getClientSecret());
    }

    @Override
    public String getClientSecret() {
        return clientInfoDTO.getClientSecret();
    }

    @Override
    public boolean isScoped() {
        return !StringUtils.isEmpty(clientInfoDTO.getScope());
    }

    @Override
    public Set<String> getScope() {
        return new HashSet<>(Arrays.asList(clientInfoDTO.getScope().split(",")));
    }

    @Override
    public Set<String> getAuthorizedGrantTypes() {
        return new HashSet<>(Arrays.asList(clientInfoDTO.getAuthorizedGrantTypes().split(",")));
    }

    @Override
    public Set<String> getRegisteredRedirectUri() {
        return new HashSet<>(Arrays.asList(clientInfoDTO.getWebServerRedirectUri().split(",")));
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        return new ArrayList<>();
    }

    @Override
    public Integer getAccessTokenValiditySeconds() {
        return clientInfoDTO.getAccessTokenValidity();
    }

    @Override
    public Integer getRefreshTokenValiditySeconds() {
        return clientInfoDTO.getRefreshTokenValidity();
    }

    @Override
    public boolean isAutoApprove(String s) {
        return !StringUtils.isEmpty(clientInfoDTO.getAutoApprove());
    }

    @Override
    public Map<String, Object> getAdditionalInformation() {
        return JsonUtils.jsonToMap(clientInfoDTO.getAdditionalInformation(),String.class,Object.class);
    }
}
