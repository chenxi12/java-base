package com.study.base.refrence;

/**
 * @Description：
 * @Author：libing
 * @Date：2023/5/23 19:45
 */
public class Person {
    @Override
    protected void finalize(){
        System.out.println("对象即将被销毁");
    }
}
