package com.czff.study.knowledge.jvm.classmemberinitialization;

/**
 * @author cuidi
 * @date 2020/7/31 18:09
 * @description  类、对象以及他们成员加载、初始化的顺序
 */
public class ClassLoading {
    public static void main(String[] args) {

        /**
         * 1. 首先加载要创建对象的类及其直接与间接父类。
         * 2. 在类被加载的同时会将静态成员进行加载，主要包括静态成员变量的初始化，静态语句块的执行，在加载时按代码的先后顺序进行。
         * 3. 需要的类加载完成后，开始创建对象，首先会加载非静态的成员，主要包括非静态成员变量的初始化，非静态语句块的执行，在加载时按代码的先后顺序进行。
         * 4. 最后执行构造器，构造器执行完毕，对象初始化完成。
         */
        Son son = new Son();

    }
}
