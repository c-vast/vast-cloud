package com.vast.system.entity;

import com.vast.common.base.entity.BaseDO;
import lombok.Data;

@Data
public class SysDictDO extends BaseDO<Integer,SysDictDO> {
    private String value;
    private String label;
    private String type;
    private String description;
    private Integer sort;
    private Integer parentId;
    private String remark;
}
