package com.czff.mydemo.designmodel.factorymethod.abstractfactory;


import com.czff.mydemo.designmodel.factorymethod.Sender;

/**
 * @author cuidi
 * @date 2022/4/7 12:27
 * @description TODO
 */
public class MailSender implements Sender {
    @Override
    public void sender() {
        System.out.println("this is mailsender!");
    }
}
