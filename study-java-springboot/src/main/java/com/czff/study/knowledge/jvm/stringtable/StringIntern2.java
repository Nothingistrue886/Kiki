package com.czff.study.knowledge.jvm.stringtable;

/**
 * @author 疾风劲草
 * @date 2024/1/12 15:33
 * @description
 */
public class StringIntern2 {
    public static void main(String[] args) {
        String s = new String("1");
        String intern = s.intern();
        String s2 = "1";
        System.out.println(s == s2);

        String s3 = new String("1") + new String("1");
        String intern3 = s3.intern();
        String s4 = "11";
        System.out.println(s3 == s4);
        System.out.println(String.class.getName() + "@" + Integer.toHexString(System.identityHashCode(s)));
        System.out.println(String.class.getName() + "@" + Integer.toHexString(System.identityHashCode(s2)));
        System.out.println(String.class.getName() + "@" + Integer.toHexString(System.identityHashCode(intern)));
        System.out.println(String.class.getName() + "@" + Integer.toHexString(System.identityHashCode(s3)));
        System.out.println(String.class.getName() + "@" + Integer.toHexString(System.identityHashCode(intern3)));
        System.out.println(String.class.getName() + "@" + Integer.toHexString(System.identityHashCode(s4)));

        System.out.println("======================");

        String ss = new String("1");
        String ss2 = "1";
        ss.intern();
        System.out.println(ss == ss2);

        String ss3 = new String("1") + new String("1");
        String ss4 = "11";
        String internss3 = ss3.intern();
        System.out.println(ss3 == ss4);
        System.out.println(String.class.getName() + "@" + Integer.toHexString(System.identityHashCode(ss3)));
        System.out.println(String.class.getName() + "@" + Integer.toHexString(System.identityHashCode(internss3)));
        System.out.println(String.class.getName() + "@" + Integer.toHexString(System.identityHashCode(ss4)));
    }
}
