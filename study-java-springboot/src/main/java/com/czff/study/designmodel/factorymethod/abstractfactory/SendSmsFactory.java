package com.czff.mydemo.designmodel.factorymethod.abstractfactory;

import com.czff.study.designmodel.factorymethod.Sender;

/**
 * @author cuidi
 * @date 2022/4/7 12:32
 * @description
 */
public class SendSmsFactory implements FactoryProduce{
    @Override
    public Sender produce() {
        return new SmsSender();
    }
}
