package com.study.base.alg;

import java.util.Arrays;

/**
 * @Description：
 * @Author：libing
 * @Date：2023/5/26 14:37
 */
public class ReverseListNode {
    static class ListNode {
        int val; // value值
        ListNode next; // 指针

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return val + "->" + next;
        }
    }

    //迭代法    1,2,3,4,5
    public static ListNode reverseNode_1(ListNode node) {
//        ListNode node = nodeList.next;
//        //如果节点为空说明只有一个节点
//        if (null == node) {
//            return nodeList;
//        }
        ListNode previous = null, current, next;
        current = node;
        while (null != current) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    //迭代法    1,2,3,4,5
    public static void reverseNode_2(ListNode node) {
        int len = 0;
        ListNode cur = node;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        int[] stack = new int[len];
        ListNode currentNode = node;
        for (int i = 0; i < len; i++) {
            stack[i] = currentNode.val;
            currentNode = currentNode.next;
        }
        int[] array = new int[len];
        for (int i = 0; i < array.length; i++) {
            array[i] = stack[len - 1 - i];
        }
        System.out.println(Arrays.toString(array));

    }


    public static ListNode prepareListNode() {
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        return node1;
    }

    public static void main(String[] args) {
        ListNode listNode = prepareListNode();
        System.out.println(listNode);
        System.out.println(reverseNode_1(listNode));
        reverseNode_2(prepareListNode());
    }

}
