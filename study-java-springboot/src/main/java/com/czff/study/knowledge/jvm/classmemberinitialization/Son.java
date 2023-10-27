package com.czff.study.knowledge.jvm.classmemberinitialization;

/**
 * @author cuidi
 * @date 2020/7/31 18:11
 * @description
 */
public class Son extends Father {
    public static int StaicNum1 = S3();
    static int S3(){
        System.out.println("子类的静态变量");
        return 1;
    }
    static {
        System.out.println("子类的静态方法代码块");
    }

    public int Num2 = S4();
    int S4(){
        System.out.println("子类的实例变量");
        return 2;
    }
    {
        System.out.println("子类的普通方法代码块");
    }

    public Son() {
        System.out.println("子类的构造方法");
    }
}
