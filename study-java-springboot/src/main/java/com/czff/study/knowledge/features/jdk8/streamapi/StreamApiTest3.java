package com.czff.study.knowledge.features.jdk8.streamapi;

import com.czff.study.knowledge.features.jdk8.Employee;
import com.czff.study.knowledge.features.jdk8.EmployeeData;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author 疾风劲草
 * @date 2024/7/30 10:34
 * @description 终止操作
 * 还可以参考：https://blog.csdn.net/li1325169021/article/details/119980249
 **/
public class StreamApiTest3 {

    // 匹配与查找
    public void test1(){
        List<Employee> employees = EmployeeData.getEmployees();

        //allMatch(Predicate p)——检查是否匹配所有元素。
        //练习：是否所有的员工的年龄都大于18
        boolean allMatch = employees.stream().allMatch(e -> e.getAge() > 18);
        System.out.println(allMatch);
        //anyMatch(Predicate p)——检查是否至少匹配一个元素。
        //练习：是否存在员工的工资大于 5000
        boolean anyMatch = employees.stream().anyMatch(e -> e.getSalary() > 5000);
        System.out.println(anyMatch);

        //noneMatch(Predicate p)——检查是否没有匹配的元素。
        //练习：是否存在员工姓“雷”
        boolean noneMatch = employees.stream().noneMatch(e -> e.getName().startsWith("雷"));
        System.out.println(noneMatch);

        //findFirst——返回第一个元素
        Optional<Employee> first = employees.stream().findFirst();
        System.out.println(first);
    }

    // 统计 计算 遍历
    public void test2(){
        List<Employee> employees = EmployeeData.getEmployees();
        // count——返回流中元素的总个数
        long count = employees.stream().filter(e -> e.getSalary()>5000).count();
        System.out.println(count);

        //max(Comparator c)——返回流中最大值
        //练习：返回最高的工资
        Stream<Double> salaryStream = employees.stream().map(e -> e.getSalary());
        Optional<Double> maxSalary = salaryStream.max(Double::compareTo);
        System.out.println(maxSalary);

        //min(Comparator c)——返回流中最小值
        //练习：返回最低工资的员工
        Optional<Double> minSalary = employees.stream().map(e -> e.getSalary()).min(Double::compareTo);
        System.out.println(minSalary);

        //forEach(Consumer c)——内部迭代
        employees.stream().forEach(System.out::println);
        System.out.println();
        //使用集合的遍历操作
        employees.forEach(System.out::println);
    }

    // 收集
    public void test4(){
        //collect(Collector c)——将流转换为其他形式。接收一个 Collector接口的实现，用于给Stream中元素做汇总的方法
        //练习1：查找工资大于6000的员工，结果返回为一个List或Set
        List<Employee> employees = EmployeeData.getEmployees();
        List<Employee> employeeList = employees.stream().filter(e -> e.getSalary() > 6000).collect(Collectors.toList());

        employeeList.forEach(System.out::println);
        System.out.println();
        Set<Employee> employeeSet = employees.stream().filter(e -> e.getSalary() > 6000).collect(Collectors.toSet());
        employeeSet.forEach(System.out::println);
    }


}
