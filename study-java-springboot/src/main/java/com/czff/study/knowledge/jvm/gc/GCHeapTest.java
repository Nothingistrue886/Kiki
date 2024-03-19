package com.czff.study.knowledge.jvm.gc;

import java.util.ArrayList;

/**
 *  -XX:+PrintCommandLineFlags
 *
 *  -XX:+UseSerialGC:表明新生代使用Serial GC ，同时老年代使用Serial Old GC
 *
 *  -XX:+UseParNewGC：标明新生代使用ParNew GC
 *
 *  -XX:+UseParallelGC:表明新生代使用Parallel GC
 *  -XX:+UseParallelOldGC : 表明老年代使用 Parallel Old GC
 *  说明：二者可以相互激活
 *
 *  -XX:+UseConcMarkSweepGC：表明老年代使用CMS GC。同时，年轻代会触发对ParNew 的使用
 */
/**
 * @author 疾风劲草
 * @date 2024/2/29 17:39
 * @description out of memory error
 */
public class GCHeapTest {
    public static void main(String[] args) {
        ArrayList<byte[]> list = new ArrayList<>();


        while (true) {
            byte[] arr = new byte[1000];
            list.add(arr);
            System.out.println(list.size());
//            try {
//                Thread.sleep(10);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
    }
}
