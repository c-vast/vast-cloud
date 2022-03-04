package com.vast.common.dto;

import com.vast.common.base.dto.BaseDTO;
import lombok.Data;

/**
 * Copyright (C), 2020-2021, c-vast
 *
 * @version 1.0.0
 * @className: UserDto
 * @author: hechenghao1998@foxmail.com
 * @createDate: 2021/7/25 2:05
 * @description:
 */
@Data
public class UserDTO extends BaseDTO<Long> {
    private String username;
    private String password;
    private String nickname;
    private String email;
    private String mobile;
    private Integer state;

    private String token;
    private String refreshToken;
}
