package com.czff.mydemo.knowledge.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * function 函数四大类
 * Consumer 消费型
 * Supplier 供给型
 * Function 函数型
 * Predicate断言型
 * 方法引用和lambda表达式都是对函数式接口的实例化
 */
public class LambdaTest {

    public static void main(String[] args) {


//        test6();

//        test5();


        /**
         * 方法引用
         */
//        test4();
        /**
         * lambda表达式
         */
//        test3();
//        test2();
//        test1();


    }

    private static void test6() {
        Function<String, Person> function = new Function<String, Person>() {
            @Override
            public Person apply(String str) {
                return new Person(str);
            }
        };
        Person apply = function.apply("l4");
        System.out.println(apply.getName());

        Function<String, Person> function2 = name -> new Person(name);
        Person apply2 = function2.apply("l4");
        System.out.println(apply2.getName());
    }

    private static void test5() {
        Supplier<Person> supplier = new Supplier<Person>() {
            @Override
            public Person get() {
                return new Person("zhangsan");
            }
        };
        System.out.println(supplier.get());

        Supplier<Person> supplier2 = () -> new Person("zhangsan");
        System.out.println(supplier2.get());
    }

    private static void test4() {
        Person person = new Person("ergouzi");
        Supplier<String> supplier = person::getName;
        System.out.println(supplier.get());
    }

    private static void test3() {
        List<String> asList = Arrays.asList("a", "b", "c");
        List<String> filterString = filterString(asList, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return "abc".contains(s);
            }
        });
        System.out.println(Arrays.toString(filterString.toArray()));

        List<String> filterString2 = filterString(asList, s -> "ac".contains(s));
        System.out.println((Arrays.toString(filterString2.toArray())));
    }

    public static List<String> filterString(List<String> list, Predicate<String> predicate) {
        List<String> filterList = new ArrayList<>();
        list.forEach(l -> {
            if (predicate.test(l)) {
                filterList.add(l);
            }
        });
        return filterList;
    }

    private static void test2() {
        happyTime(500, new Consumer<Double>() {
            @Override
            public void accept(Double money) {
                System.out.println("买水花费：" + money);
            }
        });

        happyTime(500, money -> System.out.println("买水花费：" + money));
    }

    public static void happyTime(double money, Consumer<Double> consumer) {
        consumer.accept(money);
    }

    private static void test1() {
        System.out.println("hello");
        Comparator<Integer> comparator = Comparator.comparingInt(o -> o);
        int compare = comparator.compare(11, 23);
        System.out.println(compare);

        Consumer<String> consumer = System.out::println;
        consumer.accept("爱我中华");
    }
}
