package com.czff.mydemo.optional;


import java.util.Optional;


public class OptionalTest1 {
    public static void main(String[] args) throws Exception {
        // 声明一个空Optional
        Optional<Student> empty = Optional.empty();

        // 依据一个非空值创建Optional
        Student student = new Student();
        Optional<Student> studentOptional1 = Optional.of(student);

        // 可接受null的Optional
        student = new Student("czff", 100);
        Optional<Student> studentOptional2 = Optional.ofNullable(student);


        /**
         * 判单Optional容器中是否包含对象
         */
        boolean b = studentOptional2.isPresent();
        System.out.println(b);

        studentOptional2.ifPresent(s -> s.setAge(111));
        // 使用get一定要注意，假如student对象为空，get是会报错的
        // java.util.NoSuchElementException: No value present
        System.out.println(studentOptional2.get().toString());

        System.out.println("---");

        /**
         * 获取Optional容器的对象
         */
        student = null;
        Optional<Student> studentOptional3 = Optional.ofNullable(student);

        // 当student为空的时候,返回我们新建的这个对象,有点像三目运算的感觉
        Student student2 = studentOptional3.orElse(new Student("张三", 18));
        System.out.println(student2.toString());

        // orElseGet就是当student为空的时候，返回通过Supplier供应商函数创建的对象
        Student student3 = studentOptional3.orElseGet(() -> new Student("李四", 20));
        System.out.println(student3.toString());

        // orElseThrow就是当student为空的时候，可以抛出我们指定的异常
//        studentOptional3.orElseThrow(() -> new Exception("student is null"));

        System.out.println("---");

        /**
         * 过滤
         */
        Student student4 = new Student("czff", 20);
        Optional<Student> studentOptional4 = Optional.ofNullable(student4);
        studentOptional4.filter(element -> "czff".equals(element.getName())).ifPresent(e -> System.out.println(e.toString()));

        /**
         * 映射
         */
        studentOptional4.map(s -> {
            s.setAge(s.getAge() + 1);
            return s;
        }).ifPresent(e -> System.out.println(e.toString()));
    }
}
