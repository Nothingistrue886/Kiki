package com.czff.study.designmodel.factorymethod.staticfactory;

import com.czff.study.designmodel.factorymethod.Sender;

/**
 * @author cuidi
 * @date 2022/4/7 11:46
 * @description
 */
public class FactoryTest {

    public static void main(String[] args) {
        Sender sender = SendFactory.produceMail();
        sender.sender();
    }
}
