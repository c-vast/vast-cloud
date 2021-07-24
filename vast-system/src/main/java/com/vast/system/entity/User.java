package com.vast.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.vast.common.base.entity.BaseEntity;
import lombok.Data;

/**
 * Copyright (C), 2020-2021, c-vast
 *
 * @version 1.0.0
 * @className: User
 * @author: hechenghao1998@foxmail.com
 * @createDate: 2021/7/25 1:15
 * @description:
 */
@Data
@TableName("t_sys_user")
public class User extends BaseEntity<Long> {
    private String userName;
    private String loginAccount;
    private String loginPassword;
}
