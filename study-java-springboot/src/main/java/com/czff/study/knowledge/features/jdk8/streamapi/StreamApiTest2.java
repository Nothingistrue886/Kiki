package com.czff.study.knowledge.features.jdk8.streamapi;

import com.czff.study.knowledge.features.jdk8.Employee;
import com.czff.study.knowledge.features.jdk8.EmployeeData;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author 疾风劲草
 * @date 2024/7/29 15:51
 * @description 中间操作
 **/
public class StreamApiTest2 {

    // 筛选与切片,注意执行终止操作后，Stream流就被关闭了，使用时需要再次创建Stream流
    public void test1(){
        List<Employee> employees = EmployeeData.getEmployees();
        //filter(Predicate p)——接收 Lambda ， 从流中排除某些元素。
        Stream<Employee> employeeStream = employees.stream();
        //练习：查询员工表中薪资大于7000的员工信息
        employeeStream.filter(e -> e.getSalary() > 7000).forEach(System.out::println);

        //limit(n)——截断流，使其元素不超过给定数量。
        employeeStream.limit(3).forEach(System.out::println);
        System.out.println();

        //skip(n) —— 跳过元素，返回一个扔掉了前 n 个元素的流。若流中元素不足 n 个，则返回一个空流。与 limit(n) 互补
        employeeStream.skip(3).forEach(System.out::println);
        //distinct()——筛选，通过流所生成元素的 hashCode() 和 equals() 去除重复元素
        employees.add(new Employee(1010,"刘庆东",56,8000));
        employees.add(new Employee(1010,"刘庆东",56,8000));
        employees.add(new Employee(1010,"刘庆东",56,8000));
        employees.add(new Employee(1010,"刘庆东",56,8000));
        employeeStream.distinct().forEach(System.out::println);

    }

    //2-映射
    public void test2(){

        // map 方法用于将流中的每个元素应用一个函数，并将其映射为一个新的元素。结果是一个一对一的映射。
        List<String> words1 = Arrays.asList("apple", "banana", "cherry");
        List<Integer> lengths = words1.stream()
                .map(String::length).filter(len->len>5)
                .collect(Collectors.toList());
        System.out.println(lengths); // 输出: [5, 6, 6]

        List<String> sentences = Arrays.asList("Hello world", "Java streams are powerful", "FlatMap is useful");
        // flatMap 的关键在于它将每个元素映射为一个流，然后将这些流合并成一个单一的流
        List<String> words2 = sentences.stream()
                .flatMap(sentence -> Arrays.stream(sentence.split(" ")))
                .collect(Collectors.toList());
        System.out.println(words2); // 输出: [Hello, world, Java, streams, are, powerful, FlatMap, is, useful]

    }

    //3-排序
    public void test3(){
        //sorted()——自然排序
        List<Integer> list = Arrays.asList(12, 34, 54, 65, 32);
        list.stream().sorted().forEach(System.out::println);

        //抛异常，原因:Employee没有实现Comparable接口
//        List<Employee> employees = EmployeeData.getEmployees();
//        employees.stream().sorted().forEach(System.out::println);

        //sorted(Comparator com)——定制排序
        List<Employee> employees1 = EmployeeData.getEmployees();
        employees1.stream().sorted((e1,e2)->{
            int ageValue = Integer.compare(e1.getAge(), e2.getAge());
            if (ageValue != 0){
                return ageValue;
            }else {
                return -Double.compare(e1.getSalary(),e2.getSalary());
            }
        }).forEach(System.out::println);
    }


}
