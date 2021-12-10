package com.vast.common.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "vast.security.token")
@Data
public class TokenProperties {
    private Integer expirationTime;
    private String issuer;
    private String signingKey;
    private Integer refreshExpTime;
}