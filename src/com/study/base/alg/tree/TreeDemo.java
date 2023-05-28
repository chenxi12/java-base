package com.study.base.alg.tree;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * @Description：
 * @Author：libing
 * @Date：2023/5/28 10:35
 */
public class TreeDemo {
    public static void main(String[] args) {
        TreeNode root = new TreeNode('A');
        TreeNode B = new TreeNode('B');
        TreeNode C = new TreeNode('C');
        TreeNode D = new TreeNode('D');
        TreeNode E = new TreeNode('E');
        TreeNode F = new TreeNode('F');
        TreeNode G = new TreeNode('G');
        root.setLeftTreeNode(B);
        root.setRightTreeNode(C);
        B.setLeftTreeNode(D);
        B.setRightTreeNode(E);
        C.setLeftTreeNode(F);
        C.setRightTreeNode(G);
        //前序 ABDECFG
        System.out.println("前序");
        prePrintTree(root);
        //中序 DBEAFCG
        System.out.println("中序");
        midPrintTree(root);

        //后序 DEBFCGA
        System.out.println("后序");
        endPrintTree(root);

        //层次遍历
        System.out.println("层次遍历");
        levelPrintTree(root);
    }

    /**
     * 层级遍历
     *
     * @param root
     */
    private static void levelPrintTree(TreeNode root) {
        if (Objects.isNull(root)) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.println(node.getValue());
            if (Objects.nonNull(node.getLeftTreeNode())) {
                queue.offer(node.getLeftTreeNode());
            }
            if (Objects.nonNull(node.getRightTreeNode())) {
                queue.offer(node.getRightTreeNode());
            }
        }
    }

    /**
     * 后序遍历
     *
     * @param root
     */
    private static void endPrintTree(TreeNode root) {
        if (Objects.isNull(root)) {
            return;
        }
        TreeNode leftTreeNode = root.getLeftTreeNode();
        endPrintTree(leftTreeNode);
        TreeNode rightTreeNode = root.getRightTreeNode();
        endPrintTree(rightTreeNode);
        System.out.println(root.getValue());
    }

    /**
     * 先序遍历二叉树 根左右
     *
     * @param node
     */
    private static void prePrintTree(TreeNode node) {
        if (Objects.nonNull(node)) {
            Object value = node.getValue();
            System.out.println(value);
            TreeNode leftTreeNode = node.getLeftTreeNode();
            prePrintTree(leftTreeNode);
            TreeNode rightTreeNode = node.getRightTreeNode();
            prePrintTree(rightTreeNode);
        }

    }

    /**
     * 中序遍历
     *
     * @param node
     */
    private static void midPrintTree(TreeNode node) {
        if (Objects.isNull(node)) {
            return;
        }
        TreeNode leftTreeNode = node.getLeftTreeNode();
        midPrintTree(leftTreeNode);
        System.out.println(node.getValue());
        TreeNode rightTreeNode = node.getRightTreeNode();
        midPrintTree(rightTreeNode);
    }
}
