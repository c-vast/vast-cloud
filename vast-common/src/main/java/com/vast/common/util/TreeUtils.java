package com.vast.common.util;

import com.vast.common.vo.tree.TreeNodeVO;

import java.io.Serializable;
import java.util.*;

public class TreeUtils {
    public static <T extends TreeNodeVO<ID>, ID extends Serializable> List<T> build(List<T> treeNodes, ID root) {
        List<T> trees = new LinkedList<>();
        for (T treeNode : treeNodes) {
            if (Objects.equals(root, treeNode.getParentId())) {
                trees.add(treeNode);
            }
            for (T it : treeNodes) {
                if (Objects.equals(it.getParentId(), treeNode.getId())) {
                    treeNode.add(it);
                }
            }
        }
        return trees;
    }

    public static <T extends TreeNodeVO<ID>, ID extends Serializable> List<T> build(List<T> treeNodes) {
        List<T> trees = new LinkedList<>();
        Map<ID, T> map = new LinkedHashMap<>();
        for (T t : treeNodes) {
            map.put(t.getId(), t);
        }
        Collection<T> values = map.values();
        for (T value : values) {
            ID parentId = value.getParentId();
            if (map.containsKey(parentId)) {
                T t = map.get(parentId);
                t.add(value);
            } else {
                trees.add(value);
            }
        }
        return trees;
    }

    public static <T extends TreeNodeVO<ID>, ID extends Serializable> List<T> buildByRecursive(List<T> treeNodes, ID root) {
        List<T> trees = new LinkedList<>();
        for (T treeNode : treeNodes) {
            if (Objects.equals(root, treeNode.getParentId())) {
                trees.add(findChildren(treeNode, treeNodes));
            }
        }
        return trees;
    }

    private static <T extends TreeNodeVO<ID>, ID extends Serializable> T findChildren(T treeNode, List<T> treeNodes) {
        for (T it : treeNodes) {
            if (Objects.equals(treeNode.getId(), it.getParentId())) {
                treeNode.add(findChildren(it, treeNodes));
            }
        }
        return treeNode;
    }
}
