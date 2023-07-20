package com.czff.mydemo.stream;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 3.终止操作
 * reduce 规约
 * <p>
 * toList 集合
 * toMap
 * toSet
 *
 * @author czff
 */
public class StreamTest2 {

    public static void main(String[] args) {

        reduceTest3();

//        reduceTest2();

//        reduceTest1();

//        toMapHeavyLoad();
//        collectTransfor();
    }

    private static void reduceTest3() {
        int s = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).reduce(0, (acc, n) -> acc + n);
        System.out.println(s);
    }

    private static void reduceTest2() {
        // 按行读取配置文件:

        List<String> props = Arrays.asList("profile=native", "debug=true", "logging=warn", "interval=500");

        Stream<Map<String, String>> mapStream = props.stream().map(e -> {
            String[] split = e.split("=", 2);
            return Collections.singletonMap(split[0], split[1]);
        });
        Map<String, String> reduce = mapStream.reduce(new HashMap<>(3), (m, e) -> {
            m.putAll(e);
            return m;
        });

        reduce.forEach((k, v) -> {
            System.out.println(k + "=" + v);
        });
    }

    /**
     * Optional<T> reduce(BinaryOperator<T> accumulator)：
     * 第一次执行时，accumulator函数的第一个参数为流中的第一个元素，第二个参数为流中元素的第二个元素；
     * 第二次执行时，第一个参数为第一次函数执行的结果，第二个参数为流中的第三个元素；依次类推。
     * <p>
     * T reduce(T identity, BinaryOperator<T> accumulator)：
     * 流程跟上面一样，只是第一次执行时，accumulator函数的第一个参数为identity，而第二个参数为流中的第一个元素。
     */
    private static void reduceTest1() {
        //经过测试，当元素个数小于24时，并行时线程数等于元素个数，当大于等于24时，并行时线程数为16
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24);

        Optional<Integer> reduce = list.stream().reduce((x, y) -> x + y);
        reduce.ifPresent(integer -> integer = integer + 10);
        System.out.println(reduce.get());
        System.out.println("---");

        Integer v = list.stream().reduce((x1, x2) -> x1 + x2).get();
        System.out.println(v);
        System.out.println("---");

        Integer v1 = list.stream().reduce(10, (x1, x2) -> x1 + x2);
        System.out.println(v1);
    }

    private static void toMapHeavyLoad() {
        Student student1 = new Student("z3", 10);
        Student student2 = new Student("w5", 30);
        Student student3 = new Student("l4", 20);
        Student student4 = new Student("l4", 70);
        List<Student> students = Arrays.asList(student1, student2, student3, student4);
        // toMap 重载方法，解决在变成Map中的 key 重复的问题
        students.stream()
                .collect(Collectors.toMap(Student::getName,
                        Student::getSorceNumber,
                        new BinaryOperator<Integer>() {
                            @Override
                            public Integer apply(Integer n1, Integer n2) {
                                return n2;
                            }
                        }))
                .entrySet().forEach(System.out::println);
        System.out.println("---");
        // toMap 重载方法，解决将返回结果HashMap 转换成 Map的其他实现类
        // 简化写法
        students.stream()
                .collect(Collectors.toMap(Student::getName,
                        Student::getSorceNumber,
                        (n1, n2) -> n2,
                        TreeMap::new))
                .entrySet().forEach(System.out::println);

//        students.stream()
//                .collect(Collectors.toMap(Student::getName,
//                        Student::getSorceNumber,
//                        (n1, n2) -> n2,
//                        new Supplier<TreeMap<String, Integer>>() {
//                            @Override
//                            public TreeMap<String, Integer> get() {
//                                return new TreeMap<String, Integer>();
//                            }
//                        })).entrySet().forEach(System.out::println);
    }

    /**
     * toList
     * toSet
     * toMap
     */
    private static void collectTransfor() {
        Student student1 = new Student("z3", 10);
        Student student2 = new Student("w5", 30);
        Student student3 = new Student("l4", 20);
        List<Student> students = Arrays.asList(student1, student2, student3);

        List<Integer> collectList = students.stream()
                .map(Student::getSorceNumber)
                .collect(Collectors.toList());
        System.out.println(Arrays.toString(collectList.toArray()));
        System.out.println("---");

        Set<Integer> collectSet = students.stream()
                .map(Student::getSorceNumber)
                .collect(Collectors.toSet());
        System.out.println(Arrays.toString(collectSet.toArray()));

        System.out.println("---");

        Map<String, Integer> collectMap = students.stream()
                .collect(Collectors.toMap(Student::getName, Student::getSorceNumber));
        collectMap.entrySet().forEach(System.out::println);
    }
}
