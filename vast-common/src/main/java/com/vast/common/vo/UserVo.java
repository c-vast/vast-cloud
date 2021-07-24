package com.vast.common.vo;

import com.vast.common.base.vo.BaseVo;
import lombok.Data;

/**
 * Copyright (C), 2020-2021, c-vast
 *
 * @version 1.0.0
 * @className: UserVo
 * @author: hechenghao1998@foxmail.com
 * @createDate: 2021/7/25 2:10
 * @description:
 */
@Data
public class UserVo extends BaseVo<Long> {
    private String userName;
    private String loginAccount;
    private String token;
}
