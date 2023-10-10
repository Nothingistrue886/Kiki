package com.czff.mydemo.knowledge.stream;

import java.util.*;

import static java.util.stream.Collectors.toList;

/**
 * 1.创建Stream
 * 2.中间操作
 * 3.终止操作
 *
 * @author czff
 */
public class StreamTest1 {

    public static void main(String[] args) {

//        mapToInt();


//        peekTest();

//        sortedTest();


//        flatMap();
        mapTest();

//        filterSliceTest();
    }

    private static void mapToInt() {
        List<Student> list = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            Student a = new Student();
            a.setSorceNumber(5);
            if (i == 4) {
                a.setSorceNumber(null);
            }
            list.add(a);
        }
        // 空指针
        // int sum = list.stream().mapToInt(Student::getSorceNumber).sum();

        // 正确写法
        int sum = list.stream().mapToInt(o -> Objects.isNull(o.getSorceNumber()) ? 0 : o.getSorceNumber()).sum();
        System.out.println(sum);
    }

    private static void peekTest() {
        Student s1 = new Student("aa", 10);
        Student s2 = new Student("bb", 20);
        List<Student> studentList = Arrays.asList(s1, s2);

        studentList.stream()
                .peek(student -> student.setSorceNumber(99)).forEach(student -> {
            System.out.println(student.getName() + "--" + student.getSorceNumber());
        });
    }

    private static void sortedTest() {
        List<String> sortedList = Arrays.asList("aa", "cc", "bb");
        sortedList.stream().sorted().forEach(System.out::println);

        Student aa = new Student("aa", 20);
        Student cc = new Student("cc", 30);
        Student bb = new Student("bb", 10);
        List<Student> students = Arrays.asList(aa, bb, cc);

        students.stream().sorted(Comparator.comparingInt(Student::getSorceNumber)).forEach(s -> System.out.println(s.getName() + "-" + s.getSorceNumber()));


        students.stream().sorted(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return Integer.compare(o1.getSorceNumber(), o2.getSorceNumber());
            }
        }).forEach(student -> System.out.println(student.getSorceNumber()));

        students.stream().sorted(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return Integer.compare(o2.getSorceNumber(), o1.getSorceNumber());
            }
        }).forEach(student -> System.out.println(student.getSorceNumber()));
    }

    /**
     * 中间操作 flatMap 映射
     */
    private static void flatMap() {

        String[] words = new String[]{"Hello", "World"};
        List<String[]> a = Arrays.stream(words)
                .map(word -> word.split(""))
                .distinct()
                .collect(toList());
        a.forEach(s -> System.out.println(Arrays.toString(s)));
        System.out.println("---");

        String[] words2 = new String[]{"Hello", "World"};
        List<String> a2 = Arrays.stream(words2)
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(toList());
        a2.forEach(s -> System.out.println(s));
        System.out.println("---");

        List<String> list1 = Arrays.asList("a,b,c", "abc", "1,2,3");
        List<String[]> collect = list1.stream().map(s -> s.split(",")).collect(toList());
        collect.forEach(System.out::println);
        System.out.println("---");

        List<String> list2 = Arrays.asList("a,b,c", "abc", "1,2,3");
        list2.stream().flatMap(e -> {
            String[] split = e.split(",");
            return Arrays.stream(split);
        }).forEach(System.out::println);
    }

    /**
     * 中间操作 map 映射
     */
    private static void mapTest() {
        List<String> list1 = Arrays.asList("a,b,c", "abc", "1,2,3");
        List<String> list2 = Arrays.asList("a,b,c", "bc", "1,2,3");

        List<String> list = list1.stream().filter(item -> list2.contains(item)).collect(toList());
        for (String s : list) {
            System.out.println(s);
        }

//        List<String> stringList = Arrays.asList("a,b,c", "abc", "1,2,3");
//        stringList.stream().map(s -> s.toUpperCase().replace(",", "")).forEach(System.out::println);

//        List<String> stringList2 = Arrays.asList("a", "b", "c");
//        Stream<String> stream = stringList2.stream().map(new Function<String, String>() {
//            @Override
//            public String apply(String s) {
//                return s.toUpperCase();
//            }
//        });
//        stream.forEach(System.out::println);


    }

    /**
     * 中间操作 筛选与切片
     */
    private static void filterSliceTest() {
        List<String> stringList = new ArrayList<>();
        stringList.add("a");
        stringList.add("c");
        stringList.add("b");
        stringList.add("d");
        stringList.add("b");

        stringList.stream().filter(s -> "abc".contains(s)).forEach(System.out::println);
        System.out.println("---");
        stringList.stream().filter("abc"::contains).distinct().forEach(System.out::println);
        System.out.println("---");
        stringList.stream().filter("abc"::contains).distinct().limit(1).forEach(System.out::println);
        System.out.println("---");
        stringList.stream().filter("abc"::contains).distinct().skip(1).forEach(System.out::println);
    }
}
