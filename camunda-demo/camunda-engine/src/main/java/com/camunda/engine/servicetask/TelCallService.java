package com.camunda.engine.servicetask;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.springframework.stereotype.Component;

/**
 * @author cuidi
 * @description
 * @date 2023/4/18 10:52
 */
@Slf4j
@Component
public class TelCallService {

    public int doCall(DelegateExecution execution) {
        log.info("开始电话回访");
        log.info("流程定义id：" + execution.getProcessDefinitionId());
        String repairManName = (String) execution.getVariable("repairManName");
        log.info("您对" + repairManName + "的服务打几分");
        return 10;
    }

    public void getSorce(DelegateExecution execution) {
        log.info("开始查询评分");
        log.info("流程定义id：" + execution.getProcessDefinitionId());
        String repairManName = (String) execution.getVariable("repairManName");
        int score = (int) execution.getVariable("score");
        log.info("顾客对" + repairManName + "的服务打 " + score + "分");
    }
}
