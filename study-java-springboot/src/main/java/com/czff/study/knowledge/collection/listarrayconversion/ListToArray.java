package com.czff.mydemo.knowledge.collection.listarrayconversion;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author cuidi
 * @date 2022/2/10 11:07
 * @description
 */
public class ListToArray {
    public static void main(String[] args) {

        ArrayList<String> arrayList = new ArrayList<>(3);
        arrayList.add("libai");
        arrayList.add("wangergou");
        arrayList.add("zhangsan");

        String[] toArray3 = new String[3];
        arrayList.toArray(toArray3);
        System.out.println(Arrays.asList(toArray3));
    }
}
