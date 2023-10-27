package com.czff.study.knowledge.jvm.stringtable;

public class StringPool {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "abc";
        System.out.println(s1 == s2);       // true
        System.out.println(s1.equals(s2));  // true
        System.out.println("-------------------------------");
        String s3 = "abcd";
        String s4 = s1 + "d";
        String s5 = "abc" + "d";
        System.out.println(s3 == s4);       // false
        System.out.println(s3.equals(s4));  // true
        System.out.println("-------------------------------");
        System.out.println(s3 == s5);       // true
        System.out.println(s3.equals(s5));  // true
        String s6 = new String("abc");
        String s7 = new String("abc");
        System.out.println("-------------------------------");
        System.out.println(s6 == s7);       // false
        System.out.println(s6.equals(s7));  // true
    }
}
