package com.czff.study.knowledge.collection;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author cuidi
 * @date 2020/11/24 18:47
 * @description 在 java8 中，您可以使用 Arrays.Stream 或 Stream.of 将 Array 转换为 Stream。
 */
public class ArraysStream {
    public static void main(String[] args) {
        stringArrays();
        intArrays();

        stringList();
    }

    private static void stringList() {
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        filtered.forEach(System.out::println);

        // 获取空字符串的数量
        long count = strings.stream().filter(string -> string.isEmpty()).count();
        System.out.println(count);
    }

    private static void stringArrays() {

        String[] strArray = {"2", "3", "a", "b", "c"};
        Stream<String> strStream1 = Arrays.stream(strArray);
        strStream1.forEach(System.out::println);

        Stream<String> strStream2 = Stream.of(strArray);
        strStream2.forEach(System.out::println);
    }

    private static void intArrays() {

        int[] intArray = {12, 3, 4, 5};
        IntStream intStream1 = Arrays.stream(intArray);
        intStream1.forEach(System.out::println);

        Stream<int[]> intStream2 = Stream.of(intArray);
        IntStream intStream = intStream2.flatMapToInt(Arrays::stream);
        intStream.forEach(System.out::println);
    }



}
