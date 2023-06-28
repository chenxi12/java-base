package com.study.base.alg.lru;

/**
 * @Description：
 * @Author：libing
 * @Date：2023/6/28 20:10
 */
public class LRUTest {
    public static void main(String[] args) {
        LRUCache<Integer> integerLRUCache = new LRUCache<>(2);
        integerLRUCache.put("A",1);
        integerLRUCache.put("B",2);
        integerLRUCache.put("C",3);
        integerLRUCache.getByKey("B");

        integerLRUCache.printLru();
    }
}
