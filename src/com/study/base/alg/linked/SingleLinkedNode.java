package com.study.base.alg.linked;

import lombok.Data;

import java.util.Objects;

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
    public int hashCode() {
        return Integer.parseInt(value.toString());
    }

    @Override
    public boolean equals(Object node) {
        if (this == node) { //判断一下如果是同一个对象直接返回true，提高效率
            return true;
        }
        if (node == null || node.getClass() != this.getClass()) { //如果传进来的对象为null或者二者为不同类，直接返回false
            return false;
        }
        SingleLinkedNode target = (SingleLinkedNode) node;
        return Integer.parseInt(target.value.toString()) == Integer.parseInt(this.value.toString());
    }

    @Override
    public String toString() {
        return value + "->" + next;
    }

}
