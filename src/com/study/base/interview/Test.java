package com.study.base.interview;

import lombok.Getter;
import lombok.Setter;

/**
 * @Description：
 * @Author：libing
 * @Date：2023/6/20 10:52
 */
public class Test {
    public static void main(String[] args) {
        LinkedNode linkedNode = new LinkedNode();
        linkedNode.setValue(1);
        LinkedNode linkedNode1 = new LinkedNode();

        LinkedNode linkedNode2 = new LinkedNode();
        linkedNode2.setValue(8);
        linkedNode2.setNextNode(null);
        linkedNode1.setValue(7);
        linkedNode1.setNextNode(linkedNode2);
        linkedNode.setNextNode(linkedNode1);


        System.out.println(linkedNode);

        LinkedNode preNode = null;
        LinkedNode currentNode = linkedNode;

        while (null != currentNode) {
            LinkedNode nextNode = currentNode.getNextNode();
            currentNode.setNextNode(preNode);
            preNode = currentNode;
            currentNode = nextNode;
        }
        System.out.println(preNode);

    }


}

@Setter
@Getter
class LinkedNode {
    private Integer value;
    private LinkedNode nextNode;

    @Override
    public String toString() {
        return value + "->" + nextNode;
    }
}

class Key implements Comparable<Key> {

    @Override
    public int compareTo(Key o) {
        return 0;
    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public boolean equals(Object object) {
        return false;
    }
}
