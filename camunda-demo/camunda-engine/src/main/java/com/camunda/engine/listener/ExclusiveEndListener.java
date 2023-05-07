package com.camunda.engine.listener;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.springframework.stereotype.Component;

/**
 * @author cuidi
 * @description
 * @date 2023/4/20 19:33
 */
@Slf4j
@Component
public class ExclusiveEndListener implements ExecutionListener {

    @Override
    public void notify(DelegateExecution execution) {
        String activityName = execution.getCurrentActivityName();
        boolean approve = (boolean) execution.getVariable("approve");
        String leader = (String) execution.getVariable("leader");
        log.info("当前活动：" + activityName + "结束，" + "审批人" + leader + "意见：" + approve);
    }
}
