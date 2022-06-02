package com.vast.common.base.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
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
public abstract class BaseDO<PK extends Serializable,T extends Model<T>> extends Model<T> {
    @TableId
    private PK id;
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
}
