package com.study.base.alg.linked;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @Description： 环形链表
 * @Author：libing
 * @Date：2023/6/25 13:43
 */
public class CycleLinked {
    public static void main(String[] args) {
        SingleLinkedNode a = new SingleLinkedNode();
        a.setValue(1);
        SingleLinkedNode b = new SingleLinkedNode();
        b.setValue(2);
        SingleLinkedNode c = new SingleLinkedNode();
        c.setValue(3);
        a.setNext(b);
        b.setNext(c);
        c.setNext(a);
        //快慢指针
        boolean flag = isHasCycle(a);
        System.out.println(flag);

        boolean hashFlag = isHasCycleByHash(a);
        System.out.println(hashFlag);

        boolean byHash = hasCycle(a);
        System.out.println(byHash);
    }

    private static boolean hasCycle(SingleLinkedNode a) {
        if (null == a || a.getNext() == null) {
            return false;
        }
        SingleLinkedNode fast = a, slow = a;
        while (fast.getNext() != null) {
            fast = fast.getNext().getNext();
            slow = slow.getNext();
            if (slow.getValue() == fast.getValue()) {
                return true;
            }
        }
        return false;
    }

    private static boolean isHasCycleByHash(SingleLinkedNode a) {
        if (a == null || a.getNext() == null) {
            return false;
        }
        Set<SingleLinkedNode> set = new HashSet<>();
        while (a != null) {
            if (!set.add(a)) {
                return true;
            }
            a = a.getNext();
        }
        return false;
    }

    private static boolean isHasCycle(SingleLinkedNode a) {
        if (Objects.isNull(a)) {
            return false;
        }
        SingleLinkedNode fast = a, slow = a;
        while (fast.getNext() != null) {
            fast = fast.getNext().getNext();
            slow = slow.getNext();
            if (slow.getValue() == fast.getValue()) {
                return true;
            }
        }
        return false;
    }
}
