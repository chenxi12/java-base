package com.study.base.alg.linked;

/**
 * @Description： 倒数第N个节点
 * @Author：libing
 * @Date：2023/6/26 21:20
 */
public class ReverseNNode {
    public static void main(String[] args) {
        SingleLinkedNode a = new SingleLinkedNode();
        a.setValue(1);
        SingleLinkedNode b = new SingleLinkedNode();
        b.setValue(2);
        SingleLinkedNode c = new SingleLinkedNode();
        c.setValue(3);

        SingleLinkedNode d = new SingleLinkedNode();
        d.setValue(4);
        SingleLinkedNode e = new SingleLinkedNode();
        e.setValue(5);


        a.setNext(b);
        b.setNext(c);
        c.setNext(d);
        d.setNext(e);
        e.setNext(null);
        getTwoNode(a);
    }

    private static void getTwoNode(SingleLinkedNode a) {
        SingleLinkedNode fastNode = a.getNext(), slowNode = a;
        while (fastNode.getNext() != null) {
            fastNode = fastNode.getNext();
            slowNode = slowNode.getNext();
        }
        System.out.println(slowNode.getValue());
    }
}
