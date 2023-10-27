package com.czff.study.designmodel.decorator;

/**
 * @author cuidi
 * @date 2022/4/7 17:22
 * @description 被装饰类
 */
public class Source implements Sourceable{
    @Override
    public void say() {
        System.out.println("hello world!");
    }
}
