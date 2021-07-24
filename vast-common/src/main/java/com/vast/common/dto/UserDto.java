package com.vast.common.dto;

import com.vast.common.annotation.valid.InsertValid;
import com.vast.common.annotation.valid.UpdateValid;
import com.vast.common.base.dto.BaseDto;
import lombok.Data;

import javax.validation.constraints.NotBlank;

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
public class UserDto extends BaseDto<Long> {
    @NotBlank(message = "用户名不能为空",groups = {InsertValid.class, UpdateValid.class})
    private String userName;
    @NotBlank(message = "登录账号不能为空",groups = {InsertValid.class, UpdateValid.class})
    private String loginAccount;
    @NotBlank(message = "登录密码不能为空",groups = {InsertValid.class, UpdateValid.class})
    private String loginPassword;
}
