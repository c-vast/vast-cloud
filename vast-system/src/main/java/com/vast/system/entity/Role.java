package com.vast.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.vast.common.base.entity.BaseEntity;
import lombok.Data;

/**
 * Copyright (C), 2020-2021, c-vast
 *
 * @version 1.0.0
 * @className: Role
 * @author: hechenghao1998@foxmail.com
 * @createDate: 2021/7/25 1:19
 * @description:
 */
@Data
@TableName("t_sys_role")
public class Role extends BaseEntity<Integer> {
    private String roleName;
    private String roleCode;
}
