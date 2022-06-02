package com.vast.common.vo.tree;

import lombok.Data;

import java.io.Serializable;

@Data
public class ViewTreeNodeVO<ID extends Serializable> extends TreeNodeVO<ID>{
    private String label;
    private String type;
    private String icon;
    private String name;
    private String sign;
}
