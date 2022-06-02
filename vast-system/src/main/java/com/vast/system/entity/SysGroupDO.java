package com.vast.system.entity;

import com.vast.common.base.entity.BaseDO;
import lombok.Data;

@Data
public class SysGroupDO extends BaseDO<Integer, SysGroupDO> {
    private String name;
    private Integer type;
    private Integer parentId;
}
