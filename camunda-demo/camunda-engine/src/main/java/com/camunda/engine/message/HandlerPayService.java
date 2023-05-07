package com.camunda.engine.message;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.ProcessEngineServices;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @description 
 * @author cuidi
 * @date 2023/4/25 17:03
 */
@Slf4j
@Component("handlerPay")
public class HandlerPayService implements JavaDelegate {

//    @Autowired
//    private RuntimeService runtimeService;

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        log.info("开始处理Pay");
        String terminal = (String) execution.getVariable("terminal");
//        runtimeService.startProcessInstanceByMessage("Message_elm");
//        runtimeService.startProcessInstanceByMessage("Message_mt");
        ProcessEngineServices processEngineServices = execution.getProcessEngineServices();
        RuntimeService runtimeService = processEngineServices.getRuntimeService();
        if ("elm".equals(terminal)) {
            runtimeService.startProcessInstanceByMessage("Message_elm");
        } else if ("mt".equals(terminal)) {
            runtimeService.startProcessInstanceByMessage("Message_mt");
        }
    }
}
