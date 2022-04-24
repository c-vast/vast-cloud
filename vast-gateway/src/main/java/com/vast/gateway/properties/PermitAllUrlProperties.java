package com.vast.gateway.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "vast.security.ignore")
@Data
public class PermitAllUrlProperties {
    private List<String> urls;
}
