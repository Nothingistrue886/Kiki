package com.czff.mydemo.designmodel.factorymethod.commonfactory;

import com.czff.study.designmodel.factorymethod.MailSender;
import com.czff.study.designmodel.factorymethod.Sender;
import com.czff.study.designmodel.factorymethod.SmsSender;

/**
 * @author cuidi
 * @date 2022/4/7 11:34
 * @description 工厂类
 */
public class SendFactory {
    public Sender produce(String type) {
        if ("mail".equals(type)) {
            return new MailSender();
        } else if ("sms".equals(type)) {
            return new SmsSender();
        } else {
            System.out.println("请输入正确的类型!");
            return null;
        }
    }
}
