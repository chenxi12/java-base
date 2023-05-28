package com.study.base.alg.tree;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description：树节点
 * @Author：libing
 * @Date：2023/5/27 14:20
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TreeNode {
    private TreeNode leftTreeNode;
    private TreeNode rightTreeNode;
    private Object value;

    public TreeNode(Object value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return leftTreeNode + "<-" + value + "->" + rightTreeNode;
    }
}
