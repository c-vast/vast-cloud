package com.vast.model.dto;

import com.common.base.dto.BaseDTO;
import lombok.Data;

/**
 * Copyright (C), 2020-2021, c-vast
 *
 * @version 1.0.0
 * @className: UserDTO
 * @author: hechenghao1998@foxmail.com
 * @createDate: 2021/4/10 2:03
 * @description: 用户数据传输
 */
@Data
public class UserDTO extends BaseDTO<Long> {
    private String account;
    private String password;
    private Integer state;
    private String email;
    private String phone;
    private String name;
}
