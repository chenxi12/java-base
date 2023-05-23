package com.study.base.string;

/**
 * @Description： 字符串intern，字符串常量池有则返回
 * @Author：libing
 * @Date：2023/5/23 17:12
 */
public class StringInternTest {
    public static void main(String[] args) {
        //新创建一个字符串对象
        String string = new String("Hello world");
        //获取字符串常量池中的对象
        String intern = string.intern();
        System.out.println(string == intern);//返回FALSE
    }
}
