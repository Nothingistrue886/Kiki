package com.czff.study.knowledge.comparator;

import java.util.Comparator;

/**
 * @author cuidi
 * @date 2020/9/5 12:52
 * @description Comparator是比较器，我们若需要控制某个类的次序，可以建立一个“该类的比较器”来进行排序。
 */
public class SongComparator implements Comparator<Song> {
    @Override
    public int compare(Song o1, Song o2) {
        if (o1.getVersion() > o2.getVersion()) {
            return 1;
        } else if (o1.getVersion() < o2.getVersion()) {
            return -1;
        } else {
            return 0;
        }
    }
}
