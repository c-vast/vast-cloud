package com.vast.common.base.entity;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

@Data
public abstract class BaseLogicDO<PK extends Serializable,T extends Model<T>> extends BaseDO<PK,T> {
    @TableLogic
    private Integer deleted;
}
