package com.czff.mydemo.knowledge.juc;

import java.util.LinkedList;

/**
 * @author cuidi
 * @date 2020/11/23 15:10
 * @description 多线程问题如何解答，在什么情况下会出现问题，问题的根源是什么
 * https://blog.csdn.net/a13662080711/article/details/107583333
 */

public class Stack {

    LinkedList list = new LinkedList();

    public synchronized void push(Object x) {
        synchronized (list) {
            list.addLast(x);
            notify();
        }
    }

    public synchronized Object pop() throws Exception {
        synchronized (list) {
            if (list.size() <= 0) {
                wait();
            }
            return list.removeLast();
        }
    }

    public int size() {
        return list.size();
    }
}


