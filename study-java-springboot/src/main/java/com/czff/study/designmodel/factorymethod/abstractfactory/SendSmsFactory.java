package com.czff.study.designmodel.factorymethod.abstractfactory;


import com.czff.study.designmodel.factorymethod.Sender;
import com.czff.study.designmodel.factorymethod.SmsSender;

/**
 * @author cuidi
 * @date 2022/4/7 12:32
 * @description
 */
public class SendSmsFactory implements FactoryProduce {
    @Override
    public Sender produce() {
        return new SmsSender();
    }
}
