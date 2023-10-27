package com.czff.study.knowledge.comparator;

import java.util.*;

/**
 * @author cuidi
 * @date 2020/8/6 16:51
 * @description Comparable相当于“内部比较器”，而Comparator相当于“外部比较器”。
 */
@SuppressWarnings("MapOrSetKeyShouldOverrideHashCodeEquals")
public class ComparaMainTest {
    public static void main(String[] args) {
        comparator();
        comparable();
        treeSetComparator();
    }

    private static void treeSetComparator() {
        List<Dog> list = new ArrayList<>();
        list.add(new Dog("a"));
        list.add(new Dog("a"));
        list.add(new Dog("b"));
        list.add(new Dog("c"));
        list.add(new Dog("c"));
        list.add(new Dog("b"));
        Set<Dog> treeSet = new TreeSet<>(new TreeSetComparator());
        treeSet.addAll(list);
        System.out.println(treeSet.toString());
    }

    private static void comparator() {
        ArrayList<Song> list = new ArrayList<>();
        Song song1 = new Song("攀登", "邓紫棋", 3);
        Song song2 = new Song("吻别", "张学友", 1);
        Song song3 = new Song("最美的太阳", "南征北战", 2);
        list.add(song1);
        list.add(song2);
        list.add(song3);
        SongComparator songComparator = new SongComparator();

        list.sort(songComparator);
        //Collections.sort(list, songComparator);
        // lambda 表达式优化为 方法引用
        //list.sort(Comparator.comparing(Song::getVersion));
        System.out.println(list);
    }

    private static void comparable() {
        Book[] books = new Book[]{
                new Book("李白", "静夜思", 12.0),
                new Book("杜甫", "三别", 22.0),
                new Book("白居易", "琵琶行", 10.0),
        };
        System.out.println(Arrays.toString(books));
        Arrays.sort(books);
        System.out.println(Arrays.toString(books));
//        [Book{name='李白', title='静夜思', price=12.0}, Book{name='杜甫', title='三别', price=22.0}, Book{name='白居易', title='琵琶行', price=10.0}]
//        [Book{name='白居易', title='琵琶行', price=10.0}, Book{name='李白', title='静夜思', price=12.0}, Book{name='杜甫', title='三别', price=22.0}]
    }
}
