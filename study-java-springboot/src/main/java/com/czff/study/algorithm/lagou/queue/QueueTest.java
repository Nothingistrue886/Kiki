package com.czff.study.algorithm.lagou.queue;

/**
 * @author 疾风劲草
 * @date 2022/4/20 17:38
 * @description TODO
 */
public class QueueTest {

    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(5);
        arrayQueue.enqueue("a");
        arrayQueue.enqueue("b");
        arrayQueue.enqueue("c");
        arrayQueue.enqueue("d");
        arrayQueue.enqueue("e");
        String dequeue1 = arrayQueue.dequeue();
        String dequeue2 = arrayQueue.dequeue();
        arrayQueue.enqueue("f");
    }
}
