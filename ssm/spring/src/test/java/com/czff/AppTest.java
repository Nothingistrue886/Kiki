package com.czff;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }


    @Test
    public void remove() {
        List<String> stringList = new ArrayList<>();
        stringList.add("1");
        stringList.add("a");
        stringList.add("2");
        stringList.add("1");
        stringList.add("3");
        stringList.add("4");
        stringList.add("6");
        stringList.add("q");

//        for (int i = 0; i < stringList.size(); i++) {
//            for (int j = i + 1; j < stringList.size(); j++) {
//                String si = stringList.get(i);
//                String sj = stringList.get(j);
//                if(si.equals(sj)){
//                    stringList.remove(j);
//                }
//            }
//        }

        for (int i = 0; i < stringList.size(); i++) {
            for (int j = stringList.size() - 1; j > i; j--) {
                String si = stringList.get(i);
                String sj = stringList.get(j);
                if(si.equals(sj)){
                    stringList.remove(j);
                }
            }
        }


        for (String s : stringList) {
            System.out.println(s);
        };

//        for (String s : stringList) {
//
//        }
//        for (int i = 0; i < stringList.size(); i++) {
//            String s = stringList.get(i);
//            stringList.remove(s);
//        }

//        Iterator<String> iterator = stringList.iterator();
//        while (iterator.hasNext()) {
//            String next = iterator.next();
//            iterator.remove();
//        }
//        System.out.println(stringList.isEmpty());


    }
}
