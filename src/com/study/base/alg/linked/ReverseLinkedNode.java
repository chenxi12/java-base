package com.study.base.alg.linked;

/**
 * @Description：
 * @Author：libing
 * @Date：2023/5/27 13:45
 */
public class ReverseLinkedNode {
    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 4, 5};
        //初始化列表
        SingleLinkedNode singleLinkedNode = SingleLinkedNode.initLinkedNodeList(ints, 0);
        System.out.println("old linked:" + singleLinkedNode);
        SingleLinkedNode current = singleLinkedNode;
        SingleLinkedNode next;
        //临时先组成的倒叙节点
        SingleLinkedNode temp = null;
        while (null != current) {
            //获取当前节点的下一个节点
            next = current.getNext();
            //将当前节点的下一个节点指向原先的前边节点
            current.setNext(temp);
            temp = current;
            current = next;
        }
        System.out.println("new linked:" + temp);
    }
}
