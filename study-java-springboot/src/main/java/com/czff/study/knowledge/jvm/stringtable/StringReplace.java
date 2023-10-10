package com.czff.mydemo.knowledge.jvm.stringtable;

/**
 * @author 疾风劲草
 * @date 2022/5/19 9:53
 * @description 字符串常量池
 */
public class StringReplace {

    public static void main(String[] args) {
        //String s1 = new String("hello");
        String str = new String("a") + new String("b");



        /**
         *  JDK 1.7后，intern方法还是会先去查询常量池中是否有已经存在，如果存在，则返回常量池中的引用，
         *  这一点与之前没有区别，区别在于，
         *  如果在常量池找不到对应的字符串，则不会再将字符串拷贝到常量池，
         *  而只是在常量池中生成一个对原字符串的引用。
         *  简单的说，就是往常量池放的东西变了：
         *  原来在常量池中找不到时，复制一个副本放到常量池，1.7后则是将在堆上的地址引用复制到常量池。
         */
        String s1 = "abc";
        String s2 = new String("abc");
        String s3 = s2.intern();

        System.out.println(s1 == s2);
        System.out.println(s2 == s3);
        System.out.println(s1 == s3);

        /*//String s = new String("ABC");
        String s1 = "A";
        String s2 = "B";
        String s3 = s1 + s2;
        // 深入理解java虚拟机
        String str1 = new StringBuilder("chaofan").append("wei").toString();
        System.out.println(str1.intern() == str1);

        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2);*/

    }

}
