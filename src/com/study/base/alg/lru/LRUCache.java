package com.study.base.alg.lru;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Description：
 * @Author：libing
 * @Date：2023/6/20 19:23
 */
public class LRUCache<T> {

    /**
     * 容器
     */
    private LinkedHashMap<String, T> cache;

    /**
     * 初始化容量
     */
    private int capacity;

    public LRUCache(int capacity) {
        cache = new LinkedHashMap<>(capacity);
        this.capacity = capacity;
    }

    public T getByKey(String key) {
        //查看是否包含某个key
        boolean contains = cache.containsKey(key);
        if (!contains) {
            return null;
        }
        T t = cache.get(key);

        /*更换到队尾巴，先进先出*/
        //移除某元素
        cache.remove(key);
        //添加到队头
        cache.put(key, t);
        return t;
    }

    public synchronized void put(String key, T value) {
        cache.remove(key);

        // cache 已满,删除链表头
        if (capacity == cache.size()) {
            Set<String> keySet = cache.keySet();
            Iterator<String> iterator = keySet.iterator();
            cache.remove(iterator.next());
        }
        cache.put(key, value);// 添加到链尾
    }

    public void printLru() {
        cache.forEach((k, v) -> System.out.println("Key:" + k + "---value:" + v));
    }

}
