package com.study.base.clone;

/**
 * @Description：深拷贝 注意对象里边的引用对象不会被深拷贝还是指向同一个对象
 * @Author：libing
 * @Date：2023/5/24 11:16
 */
public class CloneTest {
    public static void main(String[] args) {
        Clone clone = new Clone();
        clone.setName("clone");
        try {
            Clone clone1 = (Clone) clone.clone();
            clone1.setName("test");
            //clone
            System.out.println(clone.getName());
            //clone1 name:test
            System.out.println("clone1 name:" + clone1.getName());
            //false
            System.out.println(clone == clone1);
            //true
            System.out.println(clone.getCloneInner() == clone1.getCloneInner());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

    }
}
