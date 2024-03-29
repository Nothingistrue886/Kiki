package com.czff.study.designmodel.factorymethod.abstractfactory;

import com.czff.study.designmodel.factorymethod.Sender;

/**
 * @author cuidi
 * @date 2022/4/7 12:32
 * @description
 * 工厂方法模式有一个“缺陷”就是，类的创建依赖工厂类，也就是说，如果想要拓展程序，必须对工厂类进行修改，这违背了闭包原则，
 * 所以，从设计角度考虑，有一定的问题，如何解决？
 * 就用到抽象工厂模式，创建多个工厂类，这样一旦需要增加新的功能，直接增加新的工厂类就可以了，不需要修改之前的代码。
 *
 * 抽象工厂的优点：
 * 如果你现在想增加一个功能：发及时信息，则只需做一个实现类，实现Sender接口，同时做一个工厂类，实现Provider接口，就OK了，无需去改动现成的代码。这样做，拓展性较好！
 */
public class ProduceTest {

    public static void main(String[] args) {
        FactoryProduce sendMailFacotory = new SendMailFacotory();
        Sender produce = sendMailFacotory.produce();
        produce.sender();
    }
}
