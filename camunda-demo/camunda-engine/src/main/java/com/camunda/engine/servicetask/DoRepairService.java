package com.camunda.engine.servicetask;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

/**
 * @description 
 * @author cuidi
 * @date 2023/4/18 10:49
 */
@Slf4j
@Component
public class DoRepairService implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) {
        log.info("师傅开始维修");
        String activityName = execution.getCurrentActivityName();
        String processDefinitionId = execution.getProcessDefinitionId();
        log.info("当前活动名：" + activityName + "流程定义id：" + processDefinitionId);
        execution.setVariable("repairManName", "z3");
    }
}
