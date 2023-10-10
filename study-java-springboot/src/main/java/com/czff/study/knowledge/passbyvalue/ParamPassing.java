package com.czff.mydemo.knowledge.passbyvalue;

/**
 * @author cuidi
 * @date 2020/9/28 17:40
 * @description java中的参数传递都是值传递
 */
public class ParamPassing {

    private static int intStatic = 222;
    private static String stringStatic = "old string";
    private static StringBuilder stringBuilderStatic = new StringBuilder("old stringBuilder");

    public static void main(String[] args) {

        method(intStatic);
        method(stringStatic);
        method(stringBuilderStatic, stringBuilderStatic);

        System.out.println(intStatic);
        method();
        System.out.println(intStatic);
        System.out.println(stringStatic);
        System.out.println(stringBuilderStatic);
    }

    // 作用域局部变量与静态变量无关
    public static void method(int intStatic) {
        intStatic = 777;
    }

    public static void method() {
        intStatic = 888;
    }

    public static void method(String stringStatic) {
        // string 是 immutable 对象,不可变
        stringStatic = "new string";
    }

    public static void method(StringBuilder stringBuilder1, StringBuilder stringBuilder2) {
        stringBuilder1.append(".method.first-");
        stringBuilder2.append("method.second-");

        // new 出来一个新的局部引用变量与类的静态引用变量无关
        stringBuilder1 = new StringBuilder("new stringBuilder");
        stringBuilder1.append("new method's append");
    }

}
