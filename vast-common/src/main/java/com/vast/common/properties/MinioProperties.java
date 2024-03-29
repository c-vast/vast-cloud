package com.vast.common.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "vast.minio")
@Data
public class MinioProperties {
    private Boolean enable;

    private String endpoint;

    private String accessKey;

    private String secretKey;

    private String bucketName;
}
