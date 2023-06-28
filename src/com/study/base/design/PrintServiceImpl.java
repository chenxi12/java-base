package com.study.base.design;

/**
 * @Description：
 * @Author：libing
 * @Date：2023/6/12 10:08
 */
public class PrintServiceImpl implements PrintService {
    @Override
    public void print() {
        System.out.println("从数据库中获取缓存");
    }
}
