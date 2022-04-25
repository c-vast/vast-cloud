package com.vast.common.dto;

import com.vast.common.base.dto.BaseDTO;
import lombok.Data;

import java.util.List;

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
public class UserInfoDTO extends BaseDTO<Long> {
    private String username;
    private String password;
    private String nickname;
    private String email;
    private String mobile;
    private Integer enable;
    private String roleSign;
}
