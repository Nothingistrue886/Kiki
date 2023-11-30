package com.czff.study.knowledge.springbean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author 疾风劲草
 * @date 2023/11/26 18:19
 * @description
 */
@Data
@Component
public class Student {

    @Autowired
    Person person;

    private String name;

    public Student() {
        System.out.println("this is Student constructor");
    }

    void sayBye() {
        System.out.println("goodbye!");
    }
}

