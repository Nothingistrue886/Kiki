package com.czff.study.knowledge.springbean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author 疾风劲草
 * @date 2023/11/24 11:02
 * @description
 */
public class MySpringContainer {

    public static void main(String[] args) {
        // 初始化spring容器
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
//        context.setAllowCircularReferences(false);
        context.refresh();

        context.getBean(Student.class).sayBye();

    }
}
