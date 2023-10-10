package com.czff.mydemo.designmodel.factorymethod.multiplant;

import com.czff.study.designmodel.factorymethod.Sender;

/**
 * @author cuidi
 * @date 2022/4/7 11:36
 * @description
 */
public class FactoryTest {

    public static void main(String[] args) {
        SendFactory sendFactory = new SendFactory();
        Sender sender = sendFactory.produceMail();
        sender.sender();
    }
}
