package com.czff.mydemo.designmodel.factorymethod.abstractfactory;


import com.czff.mydemo.designmodel.factorymethod.Sender;

/**
 * @author cuidi
 * @date 2022/4/7 12:28
 * @description
 */
public class SendMailFacotory implements FactoryProduce{


    @Override
    public Sender produce() {
        return new MailSender();
    }
}
