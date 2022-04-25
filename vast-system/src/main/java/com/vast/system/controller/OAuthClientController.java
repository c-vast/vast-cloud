package com.vast.system.controller;

import com.vast.common.dto.ClientInfoDTO;
import com.vast.system.service.ClientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;

@RestController
@RequestMapping("client")
@Api(tags = "API - OAuthClientController")
@ApiOperation("用户信息")
public class OAuthClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("getClientByClientId")
    public ClientInfoDTO getClientByClientId(@NotBlank(message = "client_id不能为空")String clientId){
        return clientService.getClientByClientId(clientId);
    }
}
