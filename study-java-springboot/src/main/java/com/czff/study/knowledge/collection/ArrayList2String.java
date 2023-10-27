package com.czff.study.knowledge.collection;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author cuidi
 * @date 2020/9/5 14:06
 * @description
 */
public class ArrayList2String {
    public static void main(String[] args) {
        /**
         * 为什么c输出的不是地址值呢?
         *     A:Collection c = new ArrayList();
         *     这是多态，所以输出c的toString()方法，其实是输出ArrayList的toString()
         *     B:看ArrayList的toString()
         *     而我们在ArrayList里面却没有发现toString()。
         *     以后遇到这种情况，也不要担心，你认为有，它却没有，就应该去它父亲里面看看。
         *     C:
         *     ArrayList<E> extends AbstractList<E>
         *     AbstractList<E> extends AbstractCollection<E>
         *     AbstractCollection的toString()的方法源码
         */
        Collection c = new ArrayList();
        c.add("hello");
        c.add("world");
        c.add("java");
        /**
         * 对于这段代码: System.out.println(c);
         * 想看他是怎么输出的，点击println看它的源码
         * 发现是按String.valueOf(obj)输出的，继续点进去
         * 发现sout是按对象的toString方法输出的
         * 那再去看ArrayList的toString是怎么重写的就好了
         */
        System.out.println(c);
        System.out.println(c.toString());
    }
}
