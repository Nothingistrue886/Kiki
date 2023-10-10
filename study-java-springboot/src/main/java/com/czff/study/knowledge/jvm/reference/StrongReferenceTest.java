package com.czff.mydemo.knowledge.jvm.reference;

/**
 *  强引用的测试
 *
 * @author cuidi
 * @create 2022  16:05
 */
public class StrongReferenceTest {
    public static void main(String[] args) {
        StringBuffer str = new StringBuffer ("Hello,World!");
        StringBuffer str1 = str;

        str = null;
        System.gc();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(str1);
    }
}
