package com.camunda.engine.usertask;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.delegate.TaskListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cuidi
 * @description
 * @date 2023/4/18 10:08
 */
@Slf4j
@Component
public class UserCompleteTaskListener implements TaskListener {

    @Override
    public void notify(DelegateTask delegateTask) {
        log.info("设置候选人");
        List<String> list = new ArrayList<>();
        list.add("wanger");
        list.add("lisi");
        delegateTask.addCandidateUsers(list);
    }
}
