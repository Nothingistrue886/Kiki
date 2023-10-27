package com.czff.study.knowledge.juc.volatiledemo.volatilefeature;

/**
 * @author cuidi
 * @date 2021/9/24 15:33
 * @description VolatileFeature1类和VolatileFeature2是等价的区别在于实例变量是否有volatile关键字修饰
 * 锁的 happens-before 规则保证了释放锁和获取锁的两个线程之间的内存可见性
 * 任意单个volatile变量的读/写具有原子性，但volatile++这种复合操作不具有原子性
 */
public class VolatileFeature1 {
    volatile long vl = 0L;      // 使用volatile声明64位的long型变量

    public void set(long l) {
        vl = l;                 // 单个volatile变量的写
    }

    public synchronized void getAndIncrement() {
        vl++;                   // 复合（多个）volatile变量的读/写
    }

    public long get() {
        return vl;              // 单个volatile变量的读
    }
}
