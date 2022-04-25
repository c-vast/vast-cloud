package com.vast.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.vast.common.base.entity.BaseDO;
import lombok.Data;

@Data
@TableName("t_sys_role")
public class SysRoleDO extends BaseDO<Integer> {
    private String name;
    private String sign;
    private Integer type;
    private Integer state;
    private Integer parentId;
}
