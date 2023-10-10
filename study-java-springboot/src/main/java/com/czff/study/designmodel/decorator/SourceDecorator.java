package com.czff.mydemo.designmodel.decorator;

/**
 * @author cuidi
 * @date 2022/4/7 17:25
 * @description 装饰器
 */
public class SourceDecorator implements Sourceable{

    private Source source;

    public SourceDecorator(Source source) {
        this.source = source;
    }

    @Override
    public void say() {
        System.out.println("this is women say");
        source.say();
        System.out.println("the end!");
    }
}
