package com.study.base.day2025.linked;

import java.util.Objects;

/**
 * @author LiBing
 * @since 2025-03-10 下午8:25
 */
public class ReverseLinked {
    public static void main(String[] args) {
        SingleLinkedNode a = new SingleLinkedNode("a");
        SingleLinkedNode b = new SingleLinkedNode("b");
        a.setNextNode(b);
        SingleLinkedNode c = new SingleLinkedNode("c");
        b.setNextNode(c);
        SingleLinkedNode d = new SingleLinkedNode("d");
        c.setNextNode(d);
        SingleLinkedNode rev = reverseNode(a);
        while (Objects.nonNull(rev)) {
            System.out.print(rev.getValue() + " ");
            rev = rev.getNextNode();
        }
    }

    /**
     * 指针法 三个指针 翻转链表
     * @param head
     * @return
     */
    private static SingleLinkedNode reverseNode(SingleLinkedNode head) {
        SingleLinkedNode prev = null;
        SingleLinkedNode cur = head;
        while (Objects.nonNull(cur)) {
            SingleLinkedNode nextNode = cur.getNextNode();
            cur.setNextNode(prev);
            prev = cur;
            cur = nextNode;
        }
        return prev;
    }
}
