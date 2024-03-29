package com.vast.common.base.dto;

import com.vast.common.annotation.valid.RepeatValidId;
import com.vast.common.annotation.valid.UpdateValid;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Copyright (C), 2020-2021, c-vast
 *
 * @version 1.0.0
 * @className: BaseDto
 * @author: hechenghao1998@foxmail.com
 * @createDate: 2021/7/25 2:06
 * @description:
 */
@Data
public abstract class BaseDTO<ID extends Serializable> implements Serializable {
    @RepeatValidId
    @NotNull(message = "编号不存在",groups = UpdateValid.class)
    private ID id;
}
