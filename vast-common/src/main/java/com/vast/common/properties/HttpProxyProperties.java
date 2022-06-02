package com.vast.common.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "http.proxy")
public class HttpProxyProperties {
    private Boolean enabled;
    private String host;
    private Integer port;
}
