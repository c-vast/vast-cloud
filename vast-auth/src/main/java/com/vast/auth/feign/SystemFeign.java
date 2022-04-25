package com.vast.auth.feign;

import com.vast.common.dto.ClientInfoDTO;
import com.vast.common.dto.UserInfoDTO;
import com.vast.common.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient("vast-system")
public interface SystemFeign {

    @GetMapping("/user/getUserInfoByUsername")
    Result<UserInfoDTO> getUserInfoByUsername(@RequestParam("username") String username);

    @GetMapping("/client/getClientByClientId")
    Result<ClientInfoDTO> getClientByClientId(@RequestParam("clientId") String clientId);
}
