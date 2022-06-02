package com.vast.common.vo.tree;

import com.vast.common.base.vo.BaseVO;
import lombok.Data;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

@Data
public class TreeNodeVO<ID extends Serializable> extends BaseVO<ID> {
    private ID parentId;
    private List<TreeNodeVO<ID>> children;

    public void add(TreeNodeVO<ID> treeNodeVO) {
        checkChildren();
        children.add(treeNodeVO);
    }

    public void addAll(List<TreeNodeVO<ID>> treeNodeVOList) {
        checkChildren();
        children.addAll(treeNodeVOList);
    }

    private void checkChildren() {
        if (children == null) {
            children = new LinkedList<>();
        }
    }
}
