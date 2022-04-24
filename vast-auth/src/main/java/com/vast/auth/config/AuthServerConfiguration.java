package com.vast.auth.config;

import com.vast.auth.enhancer.AuthTokenEnhancer;
import com.vast.auth.service.AuthClientDetailsService;
import com.vast.auth.service.AuthUserDetailsService;
import com.vast.common.properties.TokenProperties;
import com.vast.common.util.RSAUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import java.security.KeyPair;
import java.util.Arrays;

/**
 * Copyright (C), 2020-2022, c-vast
 *
 * @version 1.0.0
 * @className: Oauth2AuthServerConfiguration
 * @author: hechenghao1998@foxmail.com
 * @createDate: 2022/4/23 15:02
 * @description:
 */
@Configuration
public class AuthServerConfiguration extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private TokenProperties tokenProperties;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private AuthUserDetailsService authUserDetailsService;
    @Autowired
    private AuthClientDetailsService authClientDetailsService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        //clients.withClientDetails(authClientDetailsService);
        clients.inMemory()
                .withClient("admin")
                .secret(passwordEncoder.encode("admin123456"))
                .accessTokenValiditySeconds(tokenProperties.getExpirationTime())
                .refreshTokenValiditySeconds(tokenProperties.getRefreshExpTime())
                .scopes("all")
                .authorizedGrantTypes("password","refresh_token");
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.allowFormAuthenticationForClients();
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        TokenEnhancerChain enhancerChain = new TokenEnhancerChain();
        enhancerChain.setTokenEnhancers(Arrays.asList(tokenEnhancer(), jwtAccessTokenConverter()));

        endpoints.tokenStore(tokenStore())
                .authenticationManager(authenticationManager)
                .userDetailsService(authUserDetailsService)
                .tokenEnhancer(enhancerChain);
    }

    @Bean
    public TokenStore tokenStore() {
        return new JwtTokenStore(jwtAccessTokenConverter());
    }

    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey(tokenProperties.getSigningKey());
        //converter.setKeyPair(keyPair());
        return converter;
    }

    @Bean
    public TokenEnhancer tokenEnhancer() {
        return new AuthTokenEnhancer();
    }

    @Bean
    public KeyPair keyPair(){
        return RSAUtils.generateKeyPair(tokenProperties.getSigningKey());
    }
}
