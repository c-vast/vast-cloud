package com.vast.common.dto;

import com.vast.common.annotation.valid.*;
import com.vast.common.base.dto.BaseDTO;
import com.vast.common.datadesensitization.DataDesensitization;
import com.vast.common.datadesensitization.DataDesensitizationStrategy;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

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
@FieldRepeatValid
@AtLeastOneNotNull(fieldNames = {"email", "mobile"}, message = "邮箱、手机号至少填写一个")
public class UserInfoDTO extends BaseDTO<Long> {
    @RepeatValidField(message = "用户名已存在")
    @NotBlank(message = "用户名不能为空",groups = {InsertValid.class, UpdateValid.class})
    @Length(message = "用户名长度应为6-12位",groups = {InsertValid.class, UpdateValid.class})
    private String username;
    @NotBlank(message = "密码不能为空",groups = {InsertValid.class, UpdateValid.class})
    @Length(message = "密码长度应为6-12位",groups = {InsertValid.class, UpdateValid.class})
    private String password;
    @RepeatValidField(message = "用户昵称已存在")
    @NotBlank(message = "用户昵称不能为空",groups = {InsertValid.class, UpdateValid.class})
    @Length(message = "用户昵称长度应为2-12位",groups = {InsertValid.class, UpdateValid.class})
    private String nickname;
    @RepeatValidField(message = "邮箱已被注册")
    private String email;
    @RepeatValidField(message = "手机号已被注册")
    @DataDesensitization(strategy = DataDesensitizationStrategy.PHONE)
    private String mobile;
    private Integer enable;
    private String roleSign;
}
