package com.vast.common.base.query;

import lombok.Data;

import java.io.Serializable;

@Data
public class BaseQuery implements Serializable {
    private String id;
    private Integer pageNo;
    private Integer pageSize;
    private String startTime;
    private String endTime;
    private String userId;
    private String orderBy;
}
