package com.vast.common.base.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * Copyright (C), 2020-2021, c-vast
 *
 * @version 1.0.0
 * @className: BaseVo
 * @author: hechenghao1998@foxmail.com
 * @createDate: 2021/7/25 2:09
 * @description:
 */
@Data
public class BaseVo<ID extends Serializable> implements Serializable {
    private ID id;
}
