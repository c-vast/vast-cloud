package com.vast.common.dto;

import com.vast.common.base.dto.BaseDTO;
import lombok.Data;

@Data
public class ClientInfoDTO extends BaseDTO<Integer> {
    private String clientId;
    private String resourceIds;
    private String clientSecret;
    private String scope;
    private String authorizedGrantTypes;
    private String webServerRedirectUri;
    private String authorities;
    private Integer accessTokenValidity;
    private Integer refreshTokenValidity;
    private String additionalInformation;
    private String autoApprove;
}
