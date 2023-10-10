package com.czff.mydemo.knowledge.jvm.classmemberinitialization;

/**
 * @author cuidi
 * @date 2020/7/31 18:10
 * @description
 */
public class Father {
    // 静态变量和静态代码块按照代码的先后顺序执行
    public static int StaicNum1 = S1();
    static int S1(){
        System.out.println("父类的静态变量");
        return 1;
    }
    static {
        System.out.println("父类的静态方法代码块");
    }

    public int Num2 = S2();
    int S2(){
        System.out.println("父类的实例变量");
        return 2;
    }
    {
        System.out.println("父类的普通方法代码块");
    }

    public Father() {
        System.out.println("父类的构造方法");
    }

}
