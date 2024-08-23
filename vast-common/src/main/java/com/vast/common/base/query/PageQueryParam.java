package com.vast.common.base.query;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

@Data
public class PageQueryParam {
    private Integer current;
    private Integer size;
    private String column;
    private Boolean isAsc;

    public <T> IPage<T> toPage() {
        Page<T> page = new Page<>(this.current, this.size);
        if (this.column != null) {
            boolean isAsc = this.isAsc == null || this.isAsc;
            page.addOrder(new OrderItem(this.column, isAsc));
        }
        return page;
    }
}
