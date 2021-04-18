package com.vast.model.entity.system;

import com.baomidou.mybatisplus.annotation.TableName;
import com.common.base.entity.BaseEntity;
import lombok.Data;

/**
 * Copyright (C), 2020-2021, c-vast
 *
 * @version 1.0.0
 * @className: UserDO
 * @author: hechenghao1998@foxmail.com
 * @createDate: 2021/4/10 1:21
 * @description: 用户
 */
@TableName("t_sys_user")
@Data
public class UserDO extends BaseEntity<Long> {
    private String account;
    private String password;
    private Integer state;
    private String email;
    private String phone;
    private String salt;
    private String name;
}
