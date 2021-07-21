package com.vast.common.base.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Copyright (C), 2020-2021, c-vast
 *
 * @version 1.0.0
 * @className: BaseEntity
 * @author: hechenghao1998@foxmail.com
 * @createDate: 2021/7/18 18:20
 * @description:
 */
@Data
public abstract class BaseEntity<PK extends Serializable> implements Serializable {
    private PK id;
    private Date createTime;
    private Date updateTime;
}
