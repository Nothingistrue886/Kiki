package com.czff.springbootweb.controller;

import com.czff.springbootweb.dao.DepartmentDao;
import com.czff.springbootweb.dao.EmployeeDao;
import com.czff.springbootweb.entities.Department;
import com.czff.springbootweb.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * @author 疾风劲草
 * @date 2021/1/16 19:12
 * @description
 */
@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;

    /**
     * 查询所有员工返回列表页面
     */
    @GetMapping("/emps")
    public String list(Model model) {
        Collection<Employee> employees = employeeDao.getAll();
        // 放在请求域中
        model.addAttribute("emps", employees);
        // thmeleaf默认拼接 classpath:/templates/**.html
        return "emps/list";
    }

    /**
     * 来到员工添加页面
     *
     * @return
     */
    @GetMapping("/emp")
    public String toAddPage(Model model) {
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        return "emps/add";
    }

    /**
     * 添加员工
     * springmvc 自动将请求参数和入参对象的属性进行一一绑定
     * 要求请求参数的名字和javaBean入参对象的属性名一致
     */
    @PostMapping("/emp")
    public String addEmp(Employee employee){
        // 来到员工列表页面
        System.out.println(employee);
        employeeDao.save(employee);
        // redirect:/emps 表示重定向到一个地址，/代表当前项目路径
        // forward 表示转发到一个地址
        return "redirect:/emps";
    }

    /**
     * 来到修改页面，查出当前员工，在页面回显
     * @return
     */
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id, Model model){

        Employee employee = employeeDao.get(id);
        model.addAttribute("emp", employee);
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        // 回到修改页面
        return "emps/add";
    }

    /**
     * 修改员工需要提交员工id
     * @param employee
     * @return
     */
    @PutMapping("/emp")
    public String updateEmp(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    /**
     * 删除员工
     * @param id
     * @return
     */
    @DeleteMapping("/emp/{id}")
    public String deleteEmp(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        Collection<Employee> all = employeeDao.getAll();
        for (Employee employee : all) {
            System.out.println(employee);
        }
        return "redirect:/emps";
    }
}
