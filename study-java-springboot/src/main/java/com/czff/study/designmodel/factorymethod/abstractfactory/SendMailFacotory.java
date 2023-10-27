package com.czff.study.designmodel.factorymethod.abstractfactory;


import com.czff.study.designmodel.factorymethod.MailSender;
import com.czff.study.designmodel.factorymethod.Sender;

/**
 * @author cuidi
 * @date 2022/4/7 12:28
 * @description
 */
public class SendMailFacotory implements FactoryProduce {


    @Override
    public Sender produce() {
        return new MailSender();
    }
}
