package com.vast.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.vast.common.base.entity.BaseDO;
import lombok.Data;

@Data
@TableName("t_sys_permission")
public class SysPermissionDO extends BaseDO<Integer> {
    private Integer parentId;
    private String name;
    private String url;
    private String sign;
    private Integer type;
    private String icon;
    private Integer orderNum;
}
