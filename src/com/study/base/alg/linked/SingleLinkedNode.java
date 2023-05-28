package com.study.base.alg.linked;

import lombok.Data;

/**
 * @Description：
 * @Author：libing
 * @Date：2023/5/27 13:08
 */
@Data
public class SingleLinkedNode {
    private Object value;
    private SingleLinkedNode next;

    static SingleLinkedNode initLinkedNodeList(int[] ints, int startIndex) {
        SingleLinkedNode singleLinkedNode = new SingleLinkedNode();
        singleLinkedNode.setValue(ints[startIndex]);
        if (startIndex == ints.length - 1) {
            singleLinkedNode.setNext(null);
            return singleLinkedNode;
        }
        startIndex++;
        SingleLinkedNode next = initLinkedNodeList(ints, startIndex);
        singleLinkedNode.setNext(next);
        return singleLinkedNode;
    }

    @Override
    public String toString() {
        return value + "->" + next;
    }

}
