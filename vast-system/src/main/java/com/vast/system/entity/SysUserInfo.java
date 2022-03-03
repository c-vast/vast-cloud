package com.vast.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.vast.common.base.entity.BaseDO;
import lombok.Data;

@TableName("t_sys_userinfo")
@Data
public class SysUserInfo extends BaseDO<Long> {
    private String username;
    private String password;
    private String nickname;
    private String email;
    private String mobile;
    private Integer state;
}
