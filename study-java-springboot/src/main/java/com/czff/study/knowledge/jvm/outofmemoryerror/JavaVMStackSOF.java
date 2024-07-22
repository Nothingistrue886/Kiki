package com.czff.study.knowledge.jvm.outofmemoryerror;

/**
 * @author 疾风劲草
 * @date 2024/2/29 17:39
 * @description 栈内存溢出
 * vm Args: -Xss128k
 * java.lang.StackOverflowError
 */
public class JavaVMStackSOF {

    public static void main(String[] args) {
        recursiveMethod();
    }

    public static void recursiveMethod() {
        recursiveMethod();
    }
}
