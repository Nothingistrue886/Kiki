package com.czff.mydemo.designmodel.decorator;

/**
 * @author cuidi
 * @date 2022/4/7 17:28
 * @description 装饰模式就是给一个对象动态的增加一些新的功能，要求装饰对象和被装饰对象实现同一个接口，装饰对象持有被装饰对象的实例
 */
public class DecoratorTest {

    public static void main(String[] args) {
        Source source = new Source();
        SourceDecorator decorator = new SourceDecorator(source);
        decorator.say();
    }
}
