package com.camunda.engine.listener;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author cuidi
 * @description
 * @date 2023/4/18 19:09
 */
@Slf4j
@Component("noticeCustomer")
public class NoticeCustomerStartListener implements ExecutionListener {

    @Override
    public void notify(DelegateExecution exception) throws Exception {
        log.info("进入通知客户任务");
        String userAddress = (String) exception.getVariable("userAddress");
        TimeUnit.SECONDS.sleep(1);
        log.info("您好，师傅正在前往" + userAddress + "的路上");
    }
}
