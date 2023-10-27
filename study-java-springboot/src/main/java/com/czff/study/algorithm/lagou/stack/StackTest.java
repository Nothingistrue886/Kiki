package com.czff.study.algorithm.lagou.stack;

/**
 * @author 疾风劲草
 * @date 2022/4/20 13:48
 * @description TODO
 */
public class StackTest {
    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(4);
        arrayStack.push("c");
        arrayStack.push("z");
        arrayStack.push("f");
        arrayStack.push("f");

        System.out.println(arrayStack.pop());
    }
}
