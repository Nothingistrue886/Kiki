package com.czff.study.knowledge.features.jdk8.streamapi;

import com.czff.study.knowledge.features.jdk8.Employee;
import com.czff.study.knowledge.features.jdk8.EmployeeData;

import java.util.*;
import java.util.stream.Stream;

/**
 * @author 疾风劲草
 * @date 2024/7/29 14:00
 * @description 创建Stream
 **/
public class StreamApiTest1 {

    //创建 Stream方式一：通过集合
    public void test1() {
        List<Employee> employees = EmployeeData.getEmployees();
        //default Stream<E> stream() : 返回一个顺序流
        Stream<Employee> stream = employees.stream();

        Set<String> set = new HashSet<>();
        Collections.addAll(set,"张三","李四","王五","张麻子");
        Stream<String> stream1 = set.stream();

        //default Stream<E> parallelStream() : 返回一个并行流
        Stream<Employee> employeeStream = employees.parallelStream();
    }

    //创建 Stream方式二：通过数组
    public void test2() {
        // 用数组来创建 Stream 流对象
        String[] strings = new String[]{"张三","李四","王五","张麻子"};
        //第一种方法：用 Arrays.stream() 方法来创建
        Stream<String> stream5 = Arrays.stream(strings);

        //第二种方法：用 Stream.of() 方法来创建
        Stream<String> stream6 = Stream.of(strings);
    }

    //创建 Stream方式三：通过map
    public void test3() {
        Map<String,Integer> m = new HashMap<>();
        m.put("张三",19);
        m.put("李四",28);
        m.put("王五",33);
        m.put("张麻子",22);
        //第一种方法:把键值对“封装”成一个整体
        Set<Map.Entry<String,Integer>> entries = m.entrySet();
        Stream<Map.Entry<String,Integer>> stream2 = entries.stream();
        //第二种方法:分别把集合中的键和值全部获取出来，单独放在系列集合中
        Set<String> k = m.keySet();
        Collection<Integer> v = m.values();
        Stream<String> stream3 = k.stream();
        Stream<Integer> stream4 = v.stream();
    }

    //创建 Stream方式四：创建无限流
    public void test4() {

        //迭代
        //public static<T> Stream<T> iterate(final T seed, final UnaryOperator<T> f)
        //遍历前10个偶数
        Stream.iterate(0, t -> t + 2).limit(10).forEach(System.out::println);

        //生成
        //public static<T> Stream<T> generate(Supplier<T> s)
        Stream.generate(Math::random).limit(10).forEach(System.out::println);
    }



}
