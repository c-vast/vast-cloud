package com.vast.auth.feign;

import com.vast.common.dto.UserInfoDTO;
import com.vast.common.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
@FeignClient("vast-system")
public interface UserFeign {

    @GetMapping("/user/getUserInfoByUsername")
    Result<UserInfoDTO> getUserInfoByUsername(String username);
}
