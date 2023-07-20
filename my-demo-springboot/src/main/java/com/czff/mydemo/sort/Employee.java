package com.czff.mydemo.sort;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author cuidi
 * @description
 * @date 2023/1/31 9:58
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    String name;
    int age;
    double salary;
    long mobile;

    public Employee[] initData() {
        Employee[] employees = new Employee[]{
                new Employee("John", 25, 3000.0, 9922001),
                new Employee("Ace", 22, 2000.0, 5924001),
                new Employee("Keith", 35, 4000.0, 3924401),
                new Employee("Jake", 22, 2000.0, 5924001)};
        return employees;
    }
}
