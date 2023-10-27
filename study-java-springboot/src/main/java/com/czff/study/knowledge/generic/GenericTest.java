package com.czff.study.knowledge.generic;

/**
 * @description 泛型 https://www.cnblogs.com/coprince/p/8603492.html
 * @author cuidi
 * @date 2023/6/1 17:49
 */
public class GenericTest {


    public static void main(String[] args) {

        // 定义的泛型类，就一定要传入泛型类型实参么？
        // 并不是这样，在使用泛型的时候如果传入泛型实参，则会根据传入的泛型实参做相应的限制，此时泛型才会起到本应起到的限制作用。
        // 如果不传入泛型类型实参的话，在泛型类中使用泛型的方法或成员变量定义的类型可以为任何的类型。
        Generic generic = new Generic("111111");
        Generic generic1 = new Generic(4444);
        Generic generic2 = new Generic(55.55);
        Generic generic3 = new Generic(false);

        System.out.println("泛型测试 key is " + generic.getKey());
        System.out.println("泛型测试 key is " + generic1.getKey());
        System.out.println("泛型测试 key is " + generic2.getKey());
        System.out.println("泛型测试 key is " + generic3.getKey());
        System.out.println("泛型测试 key is " + generic.getKey());
    }

}
