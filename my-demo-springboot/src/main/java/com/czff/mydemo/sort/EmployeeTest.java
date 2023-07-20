package com.czff.mydemo.sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author cuidi
 * @description Guide to Java 8 Comparator.comparing()
 * 参考；https://www.baeldung.com/java-8-comparator-comparing#:~:text=Using%20Comparator.reversed%20When%20invoked%20on%20an%20existing%20Comparator%2C,are%20sorted%20in%20descending%20order%20of%20the%20name%3A
 * @date 2023/1/31 10:11
 */
public class EmployeeTest {
    public static void main(String[] args) {
        whenComparing_thenSortedByName();
        whenComparingWithComparator_thenSortedByNameDesc();
        whenThenComparing_thenSortedByAgeName();
    }

    public static void whenComparing_thenSortedByName() {
        Employee[] employees = new Employee().initData();
        Comparator<Employee> employeeNameComparator
                = Comparator.comparing(Employee::getName);
        Arrays.sort(employees, employeeNameComparator);
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    public static void whenComparingWithComparator_thenSortedByNameDesc() {
        Employee[] employees = new Employee().initData();
        Comparator<Employee> employeeNameComparator
                = Comparator.comparing(
                Employee::getName, (s1, s2) -> {
                    return s2.compareTo(s1);
                });
        Arrays.sort(employees, employeeNameComparator);
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    public static void whenReversed_thenSortedByNameDesc() {
        Employee[] employees = new Employee().initData();
        Comparator<Employee> employeeNameComparator
                = Comparator.comparing(Employee::getName);
        Comparator<Employee> employeeNameComparatorReversed
                = employeeNameComparator.reversed();
        Arrays.sort(employees, employeeNameComparatorReversed);
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    public static void whenComparingInt_thenSortedByAge() {
        Employee[] employees = new Employee().initData();
        Comparator<Employee> employeeAgeComparator
                = Comparator.comparingInt(Employee::getAge);
        Arrays.sort(employees, employeeAgeComparator);
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    public static void whenComparingLong_thenSortedByMobile() {
        Employee[] employees = new Employee().initData();
        Comparator<Employee> employeeMobileComparator
                = Comparator.comparingLong(Employee::getMobile);
        Arrays.sort(employees, employeeMobileComparator);
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    public static void whenComparingDouble_thenSortedBySalary() {
        Employee[] employees = new Employee().initData();
        Comparator<Employee> employeeSalaryComparator
                = Comparator.comparingDouble(Employee::getSalary);
        Arrays.sort(employees, employeeSalaryComparator);
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    public static void whenThenComparing_thenSortedByAgeName() {
        Employee[] employees = new Employee().initData();
        Comparator<Employee> employee_Age_Name_Comparator
                = Comparator.comparing(Employee::getAge)
                .thenComparing(Employee::getName);

        Arrays.sort(employees, employee_Age_Name_Comparator);
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}
