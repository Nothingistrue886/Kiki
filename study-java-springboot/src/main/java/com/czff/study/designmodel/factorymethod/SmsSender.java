package com.czff.study.designmodel.factorymethod;

/**
 * @author cuidi
 * @date 2022/4/7 11:33
 * @description
 */
public class SmsSender implements Sender {
    @Override
    public void sender() {
        System.out.println("this is sms sender!");
    }
}
