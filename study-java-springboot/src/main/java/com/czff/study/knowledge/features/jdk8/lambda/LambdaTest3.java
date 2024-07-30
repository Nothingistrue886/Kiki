package com.czff.study.knowledge.features.jdk8.lambda;

import com.czff.study.knowledge.features.jdk8.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author 疾风劲草
 * @date 2024/7/29 09:58
 * @description
 * 只包含一个抽象方法的接口，称为函数式接口
 * 可以在一个接口上使用 @FunctionalInterface 注解
 * 函数四大类
 * Consumer 消费型 Consumer<T>     void accept(T t)
 * Supplier 供给型 Supplier<T>     T get()
 * Function 函数型 Function<T,R>   R apply(T t)
 * Predicate断言型 Predicate<T>    boolean test(T t)
 **/
public class LambdaTest3 {

    // 消费型接口 Consumer<T>     void accept(T t)
    public void test1() {
        //未使用Lambda表达式
        learn("java", new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("学习什么？ " + s);
            }
        });
        System.out.println("====================");
        //使用Lambda表达
        learn("html", s -> System.out.println("学习什么？ " + s));

    }

    private void learn(String s, Consumer<String> stringConsumer) {
        stringConsumer.accept(s);
    }

    // 供给型接口 Supplier<T>     T get()
    public void test2() {
        //未使用Lambdabiaodas
        Supplier<String> sp = new Supplier<String>() {
            @Override
            public String get() {
                return new String("我能提供东西");
            }
        };
        System.out.println(sp.get());
        System.out.println("====================");
        //使用Lambda表达
        Supplier<String> sp1 = () -> new String("我能通过lambda提供东西");
        System.out.println(sp1.get());
    }

    // 函数型接口 Function<T,R>   R apply(T t)
    public void test3() {
        Employee employee = new Employee(1001, "Tom", 45, 10000);

        // 使用匿名内部类
        Function<Employee, String> func1 = new Function<Employee, String>() {
            @Override
            public String apply(Employee employee) {
                return employee.getName();
            }
        };
        System.out.println(func1.apply(employee));
        System.out.println("====================");

        // 使用Lambda表达式
        Function<Employee,String>func2 = e -> e.getName();
        System.out.println(func2.apply(employee));

    }


    // 断定型接口 Predicate<T>    boolean test(T t)
    public static void test4() {
        List<String> asList = Arrays.asList("a", "b", "c");
        // 用匿名内部类
        List<String> filterString = filterString(asList, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return "abc".contains(s);
            }
        });
        System.out.println(Arrays.toString(filterString.toArray()));
        System.out.println("====================");

        // 使用Lambda表达式
        List<String> filterString2 = filterString(asList, s -> "ac".contains(s));
        System.out.println((Arrays.toString(filterString2.toArray())));
    }

    public static List<String> filterString(List<String> list, Predicate<String> predicate) {
        List<String> filterList = new ArrayList<>();
        for (String element : list) {
            if (predicate.test(element)) {
                filterList.add(element);
            }
        }
        return filterList;
    }


}
