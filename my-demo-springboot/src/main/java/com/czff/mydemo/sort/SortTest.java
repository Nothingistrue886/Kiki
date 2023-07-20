package com.czff.mydemo.sort;


import java.util.Arrays;
import java.util.List;

public class SortTest {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(
                0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1,
                0, 0, 1, 0, 0, 0, 2, 1, 0, 0, 0, 2, 30, 0, 3);

        /**
         * 异常信息：
         * Exception in thread "Main" java.lang.IllegalArgumentException: Comparison method violates its general contract!
         * 	at java.util.TimSort.mergeHi(TimSort.java:899)
         * 	at java.util.TimSort.mergeAt(TimSort.java:516)
         * 	at java.util.TimSort.mergeCollapse(TimSort.java:441)
         * 	at java.util.TimSort.sort(TimSort.java:245)
         * 	at java.util.Arrays.sort(Arrays.java:1438)
         * 	at java.util.Arrays$ArrayList.sort(Arrays.java:3895)
         * 	at com.czff.demo.JSONObjectTest.Sort.Main(Sort.java:21)
         *
         * 解决：
         * 在 JDK7 版本以上，Comparator 要满足自反性，传递性，对称性，不
         * 然 Arrays.sort，Collections.sort 会报 IllegalArgumentException 异常。
         * 说明：
         * 1） 自反性：x，y 的比较结果和 y，x 的比较结果相反。
         * 2） 传递性：x>y,y>z,则 x>z。
         * 3） 对称性：x=y,则 x,z 比较结果和 y，z 比较结果相同。
         */
        list.sort((o1, o2) -> o1 > o2 ? 1 : -1); // 异常方式

//        list.sort(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer integer, Integer anotherInteger) {
//                return integer.compareTo(anotherInteger); // 正确方式
//            }
//        });
        System.out.println(Arrays.toString(list.toArray()));

    }
}
