package com.vast.common.dto;

import com.vast.common.base.dto.BaseDTO;
import lombok.Data;

@Data
public class SystemLogDTO extends BaseDTO<Long> {
    private String username;
    private String operation;
    private String time;
    private String method;
    private String params;
    private String ip;
    private String result;
}
