package com.study.base.string;

/**
 * @Description： 字符串intern，字符串常量池有则返回
 * @Author：libing
 * @Date：2023/5/23 17:12
 */
public class StringInternTest {
    /**
     * https://blog.csdn.net/woodpecker8/article/details/128577336
     * @see
     */
    public static void main(String[] args) {
        /*字符串不存在于常量池  s4的引用和s5的引用都指向常量池*/
        String s4 = new String("b") + new String("c");
        // bc在执行s4.intern()前，在常量池中不存在，
        // 执行intern()方法会在字符串常量池中bc的存储地址，设置s4的地址引用。
        String s6 = s4.intern();
        String s5 = "bc";
        // bc的地址就是堆空间中s4的地址引用，和s4是同一地址。
        System.out.println(s4 == s5);//true
        // s6是s4.intern()返回的地址就是常量池的地址，但此时常量池中s6的地址就是s4的地址引用。
        System.out.println(s6 == s5);//true

        /*
        1 、new StringBuilder(); 因为是字符串的拼接操作
        2 、new String(“a”);
        3 、字符串常量池中的“a”;
        4 、new String(“b”);
        5 、字符串常量池中的“b”;
        6 、StringBuilder中的toString方法里的 new String(char[]);
        */
        String s1 = new String("hello");
        String s2 = s1.intern();
        System.out.println(s1 == s2);//false
        System.out.println(s1 == "hello");//false
        System.out.println(s2 == "hello");//true

//        String s3 = new StringBuilder().append(s1).append(s2).toString();
//        String s4 = s3.intern();
//        System.out.println(s3 == s4);//true
//        System.out.println(s3 == "hellohello");//true

        StringDemo stringDemo = new StringDemo();
        stringDemo.setName("Hello");
        stringDemo = new StringDemo();
        System.out.println(stringDemo);
        String str = new String("123");
        str  = new String("456");
        System.out.println(str);


    }
}
