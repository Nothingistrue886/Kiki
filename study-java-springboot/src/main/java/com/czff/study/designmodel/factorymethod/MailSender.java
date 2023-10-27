package com.czff.study.designmodel.factorymethod;

/**
 * @author cuidi
 * @date 2022/4/7 11:32
 * @description
 */
public class MailSender implements Sender {
    @Override
    public void sender() {
        System.out.println("this is mailsender!");
    }
}
