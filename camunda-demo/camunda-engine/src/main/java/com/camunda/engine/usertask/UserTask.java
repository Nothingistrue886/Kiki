package com.camunda.engine.usertask;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.IdentityService;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.variable.VariableMap;
import org.camunda.bpm.engine.variable.Variables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @description 请假开启流程
 * @author cuidi
 * @date 2023/4/18 9:38
 */
@Slf4j
@RestController
public class UserTask {

    @Autowired
    private IdentityService identityService;

    @Autowired
    private RuntimeService runtimeService;

    @GetMapping("/start/{processKey}")
    public void start(@PathVariable("processKey") String processKey){
        identityService.setAuthenticatedUserId("cuidi");
        runtimeService.startProcessInstanceByKey(processKey);
    }
}
