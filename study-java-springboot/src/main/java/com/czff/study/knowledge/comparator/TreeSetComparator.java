package com.czff.mydemo.knowledge.comparator;

import java.util.Comparator;

/**
 * @author cuidi
 * @date 2021/3/31 17:47
 * @description TreeSet依靠Comparator或Comparable对key实现去重
 */
public class TreeSetComparator implements Comparator<Dog> {

    @Override
    public int compare(Dog o1, Dog o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

