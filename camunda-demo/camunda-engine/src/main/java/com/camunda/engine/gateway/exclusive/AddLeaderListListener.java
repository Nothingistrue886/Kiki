package com.camunda.engine.gateway.exclusive;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.IdentityService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.impl.identity.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cuidi
 * @description
 * @date 2023/4/20 18:49
 */
@Slf4j
@Component("addLeaderList")
public class AddLeaderListListener implements JavaDelegate {

    @Autowired
    private IdentityService identityService;

    @Override
    public void execute(DelegateExecution execution) {
        long leaveday = (long) execution.getVariable("leaveday");
        Authentication currentAuthentication = identityService.getCurrentAuthentication();
        String userId = currentAuthentication.getUserId();
        log.info("获取员工" + userId + "请假天数：" + leaveday);
        if (leaveday < 3) {
            execution.setVariable("leader", "wanger");
        }
        else {
            List<String> list = new ArrayList<>();
            list.add("wanger");
            list.add("lisi");
            execution.setVariable("leaderList", list);
        }
    }
}
