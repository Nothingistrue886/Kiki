package com.czff.study.designmodel.factorymethod.staticfactory;


import com.czff.study.designmodel.factorymethod.Sender;
import com.czff.study.designmodel.factorymethod.SmsSender;
import com.czff.study.designmodel.factorymethod.MailSender;

/**
 * @author cuidi
 * @date 2022/4/7 11:45
 * @description
 */
public class SendFactory {

    public static Sender produceMail(){
        return new MailSender();
    }

    public static Sender produceSms(){
        return new SmsSender();
    }
}
