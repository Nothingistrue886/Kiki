package com.czff.mydemo.hutool.dfa;

import ch.qos.logback.core.util.TimeUtil;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.dfa.WordTree;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @description 
 * @author cuidi
 * @date 2023/6/5 16:52
 */
public class DFATest {

    public static void main(String[] args) {



        String text = "I love dogs";
        List<String> stringList = Arrays.asList("dogs", "I", "love");
        WordTree wordTree = new WordTree();
        wordTree.addWords(stringList);
        long start = System.currentTimeMillis();
        System.out.println(start);
        List<String> matchAll = wordTree.matchAll(text, -1, true, false);
        long l = System.currentTimeMillis() - start;
        System.out.println(l);
        matchAll.forEach(System.out::println);

    }
}
