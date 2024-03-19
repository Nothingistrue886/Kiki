package com.czff.study.knowledge.jvm.classmemberinitialization;

/**
 * @author 疾风劲草
 * @date 2024/2/21 11:17
 * @description 为什么静态内部类可以不传入引用呢？
 * 因为其本质就是针对外部类的内部类，而不是对象的内部类，不必用this来调用。
 * 首先，从静态的概念出发理解，静态修饰过后的一切物件都只与类相关，不与对象引用相关
 * As we known，静态变量，静态方法，静态块等都是类级别的属性，而不是单纯的对象属性。
 * 他们在类第一次被使用时被加载（记住，是一次使用，不一定是实例化）。
 * 我们可以简单得用 类名.变量 或者 类名.方法来调用它们。
 * 与调用没有被static 修饰过变量和方法不同的是：一般变量和方法是用当前对象的引用（即this）来调用的，静态的方法和变量则不需要。
 * 从一个角度上来说，它们是共享给所有对象的，不是一个角度私有。这点上，静态内部类也是一样的。
 */
public class OuterClass {

    public static int outerNum = S1();
    static int S1(){
        System.out.println("outer static num 静态变量");
        return 1;
    }

    static {
        System.out.println("OuterClass is loaded");
    }

    static class StaticInnerClass {
        public static OuterClass outerClass = new OuterClass();
        static {
            System.out.println("StaticInnerClass is loaded");
        }
    }

    public static OuterClass staticMethod() {
        System.out.println("Static method is called");
        return StaticInnerClass.outerClass;
    }

    public static void main(String[] args) {

//        OuterClass outerClass = new OuterClass();
        System.out.println(OuterClass.outerNum);// 调用外部类的静态变量，静态方法可以让外部类得到加载，不过这里静态内部类没有被加载


//        OuterClass.staticMethod();  //我们其实加载静态内部类的时候，其实还会先加载外部类，才加载静态内部类
    }
}