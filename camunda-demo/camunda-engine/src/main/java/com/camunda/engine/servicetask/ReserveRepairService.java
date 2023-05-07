package com.camunda.engine.servicetask;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

/**
 * @author cuidi
 * @description
 * @date 2023/4/18 10:08
 */
@Slf4j
@Component
public class ReserveRepairService implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) {
        log.info("开始预约修理");
        String activityName = execution.getCurrentActivityName();
        String processDefinitionId = execution.getProcessDefinitionId();
        log.info("当前活动名称：" + activityName + "\t流程定义id:" + processDefinitionId);
    }
}
