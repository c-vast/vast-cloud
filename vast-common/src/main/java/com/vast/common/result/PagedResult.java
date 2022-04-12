package com.vast.common.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel(value = "分页响应结果", description = "分页响应结果")
public class PagedResult <R,D>{
    @ApiModelProperty(value = "分页数据-当前页数据")
    private List<R> result;
    @ApiModelProperty(value = "额外的用户数据")
    private D userData;
    @ApiModelProperty(value = "总记录数")
    private int count = 0;
    @ApiModelProperty(value = "当前页")
    private int page = 0;
    @ApiModelProperty(value = "每页记录数")
    private int pageSize = 0;
    @ApiModelProperty(value = "总页数")
    private int totalPage = 0;
    @ApiModelProperty(value = "开始行")
    private int fromRow;
    @ApiModelProperty(value = "结束行")
    private int toRow;

    public PagedResult(Integer currentPage, int pageSize,int totalRow, List<R> result) {
        if(currentPage == null)currentPage = 1;
        this.count = totalRow;
        this.pageSize = pageSize;
        //计算总页数
        int page = this.count / this.pageSize;
        if(this.count % this.pageSize != 0)
            page++;
        this.totalPage = page;
        //设置当前页
        if(currentPage < 1)currentPage = 1;
        else if(currentPage > totalPage)currentPage = totalPage;
        this.page = currentPage;
        //设置开始行
        int row = (this.page - 1) * this.pageSize;
        row++;
        this.fromRow = row;
        //设置结束行
        row = this.getFromRow() + this.pageSize - 1;
        if(row > this.count)
            row = this.count;
        this.toRow = row;
        this.result = result;
    }
}
