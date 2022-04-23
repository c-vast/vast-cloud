package com.vast.auth.enhancer;

import com.vast.auth.dto.AuthUserDetailsDTO;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.HashMap;
import java.util.Map;

/**
 * Copyright (C), 2020-2022, c-vast
 *
 * @version 1.0.0
 * @className: AuthTokenEnhancer
 * @author: hechenghao1998@foxmail.com
 * @createDate: 2022/4/23 14:54
 * @description:
 */
public class AuthTokenEnhancer implements TokenEnhancer {
    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken oAuth2AccessToken, OAuth2Authentication oAuth2Authentication) {
        AuthUserDetailsDTO authUserDetailsDTO = (AuthUserDetailsDTO) oAuth2Authentication.getPrincipal();

        Map<String, Object> additionalInfo = new HashMap<>();
        additionalInfo.put("id", authUserDetailsDTO.getUserDTO().getId());
        additionalInfo.put("username", authUserDetailsDTO.getUserDTO().getUsername());
        additionalInfo.put("email", authUserDetailsDTO.getUserDTO().getEmail());
        additionalInfo.put("mobile", authUserDetailsDTO.getUserDTO().getMobile());

        ((DefaultOAuth2AccessToken) oAuth2AccessToken).setAdditionalInformation(additionalInfo);
        return oAuth2AccessToken;
    }
}
