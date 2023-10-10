package com.czff.mydemo.knowledge.collection.listarrayconversion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author cuidi
 * @date 2021/8/18 11:03
 * @description 数组转List
 * 1.不能直接使用 Arrays.asList 来转换基本类型数组
 * 2.Arrays.asList 返回的 listarrayconversion 不支持增删操作。
 * 3.对原始数组的修改会影响到我们获得的那个 listarrayconversion
 */
public class ArrayToList {
    public static void main(String[] args) {

        efficientConversion();
        //supportOperation();
        //unsupportOperation();
        streamConverison();
    }

    /**
     * 解析：
     * 通过Collections.addAll(arrayList, strArray)方式转换，
     * 根据数组的长度创建一个长度相同的List，
     * 然后通过Collections.addAll()方法，
     * 将数组中的元素转为二进制，然后添加到List中，这是最高效的方法。
     * 应用场景：
     * 需要在将数组转换为List后，对List进行增删改查操作，
     * 在List的数据量巨大的情况下，优先使用，可以提高操作速度。
     */
    private static void efficientConversion() {
        String[] strArray = new String[]{"y", "q"};
        ArrayList<String> list = new ArrayList<>(strArray.length);
        Collections.addAll(list, strArray);
        list.add("1");
        System.out.println(list);
    }

    /**
     * 解析：
     * 通过ArrayList的构造器，将Arrays.asList(strArray)的返回值
     * 由java.util.Arrays.ArrayList转为java.util.ArrayList。
     * 应用场景：
     * 需要在将数组转换为List后，对List进行增删改查操作，在List的数据量不大的情况下，可以使用。
     */
    private static void supportOperation() {
        String[] strArray = new String[2];
        ArrayList<String> list = new ArrayList<String>(Arrays.asList(strArray));
        list.add("1");
        System.out.println(list);
    }

    /**
     * 解析：
     * Arrays.asList(strArray)返回值是java.util.Arrays类中一个私有静态内部类
     * java.util.Arrays.ArrayList，它并非java.util.ArrayList类。
     * java.util.Arrays.ArrayList类具有 set()，get()，contains()等方法，
     * 但是不具有添加add()或删除remove()方法,所以调用add()方法会报错。
     * 应用场景：
     * Arrays.asList(strArray)方式仅能用在将数组转换为List后，不需要增删其中的值，仅作为数据源读取使用。
     */
    private static void unsupportOperation() {
        String[] strArray = new String[2];
        List<String> list = Arrays.asList(strArray);
        //对转换后的list插入一条数据
        list.add("1");
        System.out.println(list);
    }

    /**
     * int[] arr = {1, 2, 3};
     * listarrayconversion list = Arrays.asList(arr);
     * log.info("list:{} size:{} class:{}", list, list.size(), list.get(0).getClass());
     * 这个 listarrayconversion 包含的其实是一个 int 数组，整个 listarrayconversion 的元素个数是 1，元素类型是整数数组。
     * 解析：
     * 其原因是，只能是把 int 装箱为 Integer，不可能把 int 数组装箱为 Integer 数组。
     * 我们知道，Arrays.asList 方法传入的是一个泛型 T 类型可变参数，最终 int 数组整体作为了一个对象成为了泛型类型 T。
     * 直接遍历这样的 listarrayconversion 必然会出现 Bug。
     * 解决：
     * Arrays.iostream 方法来转换，可以把 int 数组声明为包装类型 Integer 数组
     */
    private static void streamConverison() {

        List<Integer> intList = Arrays.stream(new int[]{1, 2, 3,}).boxed().collect(Collectors.toList());
        List<Long> longList = Arrays.stream(new long[]{1, 2, 3}).boxed().collect(Collectors.toList());
        List<Double> doubleList = Arrays.stream(new double[]{1, 2, 3}).boxed().collect(Collectors.toList());
        String[] arrays = {"tom", "jack", "kate"};
        List<String> collect = Arrays.stream(arrays).collect(Collectors.toList());
        List<String> stringList = Stream.of(arrays).collect(Collectors.toList());
        System.out.println(intList);
        System.out.println(longList);
        System.out.println(doubleList);
        System.out.println(collect);
        System.out.println(stringList);
    }

}
