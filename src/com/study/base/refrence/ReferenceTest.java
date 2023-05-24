package com.study.base.refrence;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * @Description： 强软弱虚引用
 * @Author：libing
 * @Date：2023/5/23 17:12
 */
public class ReferenceTest {
    public static void main(String[] args) {
        Person person = new Person();
        System.out.println(person);
        System.gc();
        System.out.println(person);
        /*软引用空间充足不回收*/
        Object obj1 = new Object();
        SoftReference<Object> softReference = new SoftReference<>(obj1);
        obj1 = null;
        System.out.println(softReference.get());
        System.gc();
        System.out.println(softReference.get());

        /*弱引用都会回收*/
        Person obj = new Person();
        WeakReference<Object> weakReference = new WeakReference<>(obj);
        obj = null;
        System.out.println(weakReference.get());
        System.gc();
        System.out.println(weakReference.get());

        //虚引用
        ReferenceQueue<Object> queue = new ReferenceQueue<>();
        PhantomReference<String> phantomReference = new PhantomReference<>("虚引用 ", queue);
        System.out.println("虚引用:" + phantomReference.get());

    }
}
