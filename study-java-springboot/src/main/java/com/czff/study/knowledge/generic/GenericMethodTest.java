package com.czff.study.knowledge.generic;

/**
 * @author cuidi
 * @description 泛型方法
 * @date 2023/6/2 10:34
 */
public class GenericMethodTest {

    public static void main(String[] args) {
        GenericMethod.Apple apple = new GenericMethod.Apple();
        GenericMethod.Person person = new GenericMethod.Person();

        GenericMethod.GenerateTest<GenericMethod.Fruit> generateTest = new GenericMethod.GenerateTest<>();
        //apple是Fruit的子类，所以这里可以
        generateTest.show_1(apple);
        //编译器会报错，因为泛型类型实参指定的是Fruit，而传入的实参类是Person
        //generateTest.show_1(person);

        //使用这两个方法都可以成功
        generateTest.show_2(apple);
        generateTest.show_2(person);

        //使用这两个方法也都可以成功
        generateTest.show_3(apple);
        generateTest.show_3(person);

    }

}
