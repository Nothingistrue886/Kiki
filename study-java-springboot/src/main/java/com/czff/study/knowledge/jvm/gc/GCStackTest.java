package com.czff.study.knowledge.jvm.gc;

/**
 * @author 疾风劲草
 * @date 2024/2/29 17:39
 * @description stack over flow error
 */
public class GCStackTest {

    public static void main(String[] args) {
        recursiveMethod();
    }

    public static void recursiveMethod() {
        recursiveMethod();
    }
}
