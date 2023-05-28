package com.study.base.alg.tree;

import lombok.Data;

/**
 * @Description：
 * @Author：libing
 * @Date：2023/5/27 14:20
 */
@Data
public class TreeNode {
    private TreeNode leftTreeNode;
    private TreeNode rightTreeNode;
    private Object value;

    public static TreeNode initTreeNode(int[] ints) {
        TreeNode treeNode = new TreeNode();

//        1,2,3,4,5,6,7,8,9   5 4 9
        int midIndex = ints.length >> 1; //4 value=5
        treeNode.setValue(ints[midIndex]);
        if (0 == midIndex) {
            return treeNode;
        }
//        int leftEndIndex = midIndex - 1; // 3

        int[] left = new int[midIndex];
        //1,2,3,4
        for (int i = 0; i < midIndex; i++) {
            left[i] = ints[i];
        }
        for (int i = 0; i < left.length; i++) {
            TreeNode leftNode = initTreeNode(left);
            treeNode.setLeftTreeNode(leftNode);
        }
        //6,7,8,9
        int[] right = new int[midIndex];
        //4

        for (int i = 0; i < midIndex - 1; i++) {//0,1,2,3
            //index 5,6,7,8
            right[i] = ints[midIndex + 1 + i];
//            5,6
        }
        for (int i = 0; i < right.length; i++) {
            TreeNode rightNode = initTreeNode(right);
            treeNode.setRightTreeNode(rightNode);
        }


//        treeNode.setLeftTreeNode(initTreeNode(ints));
//        treeNode.setRightNode(initTreeNode(ints));
//        System.out.println(midIndex);
        return treeNode;
    }

    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 4, 5, 6, 7, 8, 9};
//        int[] ints = {1, 2, 3};
        TreeNode treeNode = initTreeNode(ints);
        System.out.println(treeNode);
    }

    @Override
    public String toString() {
        return leftTreeNode + "<-" + value + "->" + rightTreeNode;
    }
}
